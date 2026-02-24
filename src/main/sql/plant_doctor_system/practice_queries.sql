-- =================================================================
-- HỆ THỐNG CHẨN ĐOÁN BỆNH CÂY TRỒNG (PLANT DOCTOR)
-- =================================================================

-- 1. Tạo bảng Nông dân / Người dùng (Farmers)
CREATE TABLE Farmers (
    farmer_id INT PRIMARY KEY,
    full_name VARCHAR(100),
    region VARCHAR(100)
);

-- 2. Tạo bảng Cây trồng (Crops)
CREATE TABLE Crops (
    crop_id INT PRIMARY KEY,
    crop_name VARCHAR(100),
    plant_type VARCHAR(50)
);

-- 3. Tạo bảng Bệnh hại (Diseases)
CREATE TABLE Diseases (
    disease_id INT PRIMARY KEY,
    disease_name VARCHAR(100),
    severity VARCHAR(20) -- 'Low', 'Medium', 'High'
);

-- 4. Tạo bảng Lịch sử chẩn đoán (Diagnosis_Logs)
CREATE TABLE Diagnosis_Logs (
    log_id INT PRIMARY KEY,
    farmer_id INT,
    crop_id INT,
    disease_id INT,
    scan_date DATE,
    confidence DECIMAL(5, 2), -- Điểm tin cậy của AI (VD: 98.50%)
    FOREIGN KEY (farmer_id) REFERENCES Farmers(farmer_id),
    FOREIGN KEY (crop_id) REFERENCES Crops(crop_id),
    FOREIGN KEY (disease_id) REFERENCES Diseases(disease_id)
);

-- =================================================================
-- CHÈN DỮ LIỆU MẪU (Mock Data)
-- =================================================================
INSERT INTO Farmers VALUES 
(1, 'Dylan Zheng', 'Mekong Delta'),
(2, 'Le Van Lua', 'Red River Delta'),
(3, 'Tran Thi Ca Chua', 'Da Lat');

INSERT INTO Crops VALUES 
(101, 'Rice', 'Cereal'),
(102, 'Tomato', 'Vegetable'),
(103, 'Coffee', 'Industrial');

INSERT INTO Diseases VALUES 
(201, 'Rice Blast (Đạo ôn)', 'High'),
(202, 'Late Blight (Mốc sương)', 'High'),
(203, 'Leaf Spot (Đốm lá)', 'Medium'),
(204, 'Healthy (Không bệnh)', 'Low');

INSERT INTO Diagnosis_Logs VALUES 
(1, 1, 101, 201, '2026-02-20', 95.50),
(2, 1, 101, 203, '2026-02-21', 88.00),
(3, 2, 101, 201, '2026-02-22', 99.10),
(4, 3, 102, 202, '2026-02-23', 92.40),
(5, 1, 103, 204, '2026-02-24', 98.90);

-- =================================================================
-- BÀI TẬP THỰC HÀNH (Kèm Lời Giải)
-- =================================================================

-- Câu 1 (Cơ bản): 
-- Lọc ra các lượt chẩn đoán có độ tin cậy (confidence) của AI lớn hơn 90%.
-- Hiển thị: log_id, scan_date, confidence.
SELECT log_id, scan_date, confidence
FROM Diagnosis_Logs
WHERE confidence > 90.00;

-- Câu 2 (Trung bình - JOIN 4 Bảng): 
-- Xuất báo cáo chi tiết các ca bệnh "High" severity.
-- Hiển thị: Tên người quét (full_name), Tên cây (crop_name), Tên bệnh (disease_name), Ngày quét.
SELECT f.full_name, c.crop_name, d.disease_name, l.scan_date
FROM Diagnosis_Logs l
JOIN Farmers f ON l.farmer_id = f.farmer_id
JOIN Crops c ON l.crop_id = c.crop_id
JOIN Diseases d ON l.disease_id = d.disease_id
WHERE d.severity = 'High';

-- Câu 3 (Khó - GROUP BY & COUNT): 
-- Thống kê xem mỗi loại bệnh (disease_name) đã được hệ thống phát hiện bao nhiêu lần.
-- Sắp xếp kết quả từ cao xuống thấp để biết bệnh nào đang lây lan mạnh nhất.
SELECT d.disease_name, COUNT(l.log_id) AS total_cases
FROM Diagnosis_Logs l
JOIN Diseases d ON l.disease_id = d.disease_id
GROUP BY d.disease_id, d.disease_name
ORDER BY total_cases DESC;

-- Câu 4 (Khó - Tìm Max trong từng Nhóm): 
-- Tìm lượt chẩn đoán có độ tin cậy (confidence) CAO NHẤT cho từng loại cây trồng (crop_name).
-- Cú pháp dưới đây dùng Subquery với MAX(). Đi thi gặp câu này thì điểm A+ chắc tay!
SELECT c.crop_name, d.disease_name, l1.confidence
FROM Diagnosis_Logs l1
JOIN Crops c ON l1.crop_id = c.crop_id
JOIN Diseases d ON l1.disease_id = d.disease_id
WHERE l1.confidence = (
    SELECT MAX(l2.confidence)
    FROM Diagnosis_Logs l2
    WHERE l2.crop_id = l1.crop_id
);