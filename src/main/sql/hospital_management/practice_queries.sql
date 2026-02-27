-- =================================================================
-- HỆ THỐNG QUẢN LÝ PHÒNG KHÁM / BỆNH VIỆN (HOSPITAL MANAGEMENT)
-- =================================================================

-- 1. Bảng Chuyên khoa
CREATE TABLE Specialties (
    spec_id INT PRIMARY KEY,
    spec_name VARCHAR(100),
    floor_no INT
);

-- 2. Bảng Bác sĩ
CREATE TABLE Doctors (
    doc_id INT PRIMARY KEY,
    spec_id INT,
    full_name VARCHAR(100),
    phone VARCHAR(20),
    FOREIGN KEY (spec_id) REFERENCES Specialties(spec_id)
);

-- 3. Bảng Bệnh nhân
CREATE TABLE Patients (
    pat_id INT PRIMARY KEY,
    full_name VARCHAR(100),
    dob DATE,
    gender VARCHAR(10)
);

-- 4. Bảng Lịch hẹn khám (Kết nối Bệnh nhân và Bác sĩ)
CREATE TABLE Appointments (
    appt_id INT PRIMARY KEY,
    pat_id INT,
    doc_id INT,
    appt_date DATETIME,
    status VARCHAR(50), -- 'Scheduled', 'Completed', 'Cancelled'
    FOREIGN KEY (pat_id) REFERENCES Patients(pat_id),
    FOREIGN KEY (doc_id) REFERENCES Doctors(doc_id)
);

-- 5. Bảng Đơn thuốc / Điều trị (Phụ thuộc vào Lịch hẹn)
CREATE TABLE Prescriptions (
    presc_id INT PRIMARY KEY,
    appt_id INT,
    medicine VARCHAR(150),
    dosage VARCHAR(100),
    FOREIGN KEY (appt_id) REFERENCES Appointments(appt_id)
);

-- =================================================================
-- CHÈN DỮ LIỆU MẪU (Mock Data)
-- =================================================================
INSERT INTO Specialties VALUES 
(1, 'Cardiology (Tim mach)', 2),
(2, 'Pediatrics (Nhi khoa)', 1);

INSERT INTO Doctors VALUES 
(101, 1, 'Dr. Strange', '0999111222'),
(102, 2, 'Dr. House', '0999333444');

INSERT INTO Patients VALUES 
(1001, 'Dylan Zheng', '2000-05-15', 'Male'),
(1002, 'Baby Boss', '2023-01-01', 'Male');

INSERT INTO Appointments VALUES 
(5001, 1001, 101, '2026-03-05 08:30:00', 'Completed'), -- Dylan khám Tim mạch
(5002, 1002, 102, '2026-03-05 09:00:00', 'Scheduled');  -- Em bé khám Nhi

INSERT INTO Prescriptions VALUES 
(1, 5001, 'Panadol', '2 vien/ngay'),
(2, 5001, 'Vitamin C', '1 vien/ngay'); -- 1 ca khám của Dylan được kê 2 loại thuốc

-- =================================================================
-- BÀI TẬP THỰC HÀNH (Đã giảm tải)
-- =================================================================

-- Câu 1 (Hiểu cấu trúc luồng ERD): 
-- Xuất "Hồ sơ khám bệnh" chi tiết của bệnh nhân 'Dylan Zheng' cho ca khám 'Completed'.
-- Yêu cầu hiển thị: Tên bệnh nhân, Tên Bác sĩ, Tên Chuyên Khoa, Tên Thuốc, Liều lượng.
-- (Cần JOIN từ Patients -> Appointments -> Doctors -> Specialties, và nối với Prescriptions)
SELECT p.full_name AS Patient, 
       d.full_name AS Doctor, 
       s.spec_name AS Specialty, 
       pr.medicine AS Medicine, 
       pr.dosage AS Dosage
FROM Appointments a
JOIN Patients p ON a.pat_id = p.pat_id
JOIN Doctors d ON a.doc_id = d.doc_id
JOIN Specialties s ON d.spec_id = s.spec_id
JOIN Prescriptions pr ON a.appt_id = pr.appt_id
WHERE p.full_name = 'Dylan Zheng' AND a.status = 'Completed';

-- Câu 2 (Thống kê theo Nhóm Cha):
-- Đếm số lượng ca khám bệnh (Appointments) theo từng CHUYÊN KHOA (Specialties).
-- Hiển thị: Tên Chuyên khoa, Số lượng ca khám.
SELECT s.spec_name, COUNT(a.appt_id) AS total_appointments
FROM Specialties s
LEFT JOIN Doctors d ON s.spec_id = d.spec_id
LEFT JOIN Appointments a ON d.doc_id = a.doc_id
GROUP BY s.spec_id, s.spec_name;