-- =================================================================
-- HỆ THỐNG QUẢN LÝ VẬN CHUYỂN & GIAO HÀNG (LOGISTICS)
-- =================================================================

-- 1. Tạo bảng Tài xế (Drivers)
CREATE TABLE Drivers (
    driver_id INT PRIMARY KEY,
    full_name VARCHAR(100),
    phone VARCHAR(20),
    vehicle_type VARCHAR(50) -- 'Xe May', 'Xe Tai Nho', 'Xe Tai Lon'
);

-- 2. Tạo bảng Vận đơn (Shipments)
CREATE TABLE Shipments (
    shipment_id VARCHAR(20) PRIMARY KEY,
    driver_id INT,
    destination VARCHAR(200),
    status VARCHAR(50), -- 'Pending', 'Delivering', 'Completed'
    FOREIGN KEY (driver_id) REFERENCES Drivers(driver_id)
);

-- 3. Tạo bảng Lịch sử theo dõi (Tracking_Logs)
CREATE TABLE Tracking_Logs (
    log_id INT PRIMARY KEY,
    shipment_id VARCHAR(20),
    location VARCHAR(200),
    status_note VARCHAR(100),
    log_time DATETIME,
    FOREIGN KEY (shipment_id) REFERENCES Shipments(shipment_id)
);

-- =================================================================
-- CHÈN DỮ LIỆU MẪU (Mock Data)
-- =================================================================
INSERT INTO Drivers VALUES 
(1, 'Nguyen Van X', '0901234567', 'Xe May'),
(2, 'Tran Thi Y', '0987654321', 'Xe Tai Nho'),
(3, 'Le Van Z', '0912345678', 'Xe Tai Lon'); -- Tài xế Z đang rảnh rỗi

INSERT INTO Shipments VALUES 
('SHP001', 1, 'Quan 1, TP.HCM', 'Delivering'),
('SHP002', 1, 'Quan 3, TP.HCM', 'Completed'),
('SHP003', 2, 'Di An, Binh Duong', 'Delivering');

INSERT INTO Tracking_Logs VALUES 
(1, 'SHP001', 'Kho Tong', 'Xuat kho', '2026-02-25 08:00:00'),
(2, 'SHP001', 'Tram trung chuyen Q1', 'Dang phan loai', '2026-02-25 10:30:00'),
(3, 'SHP001', 'Duong Le Duan', 'Tai xe dang giao', '2026-02-25 14:00:00'), -- Log mới nhất của SHP001

(4, 'SHP002', 'Kho Tong', 'Xuat kho', '2026-02-24 09:00:00'),
(5, 'SHP002', 'Quan 3, TP.HCM', 'Giao thanh cong', '2026-02-24 11:00:00'), -- Log mới nhất của SHP002

(6, 'SHP003', 'Kho Tong', 'Xuat kho', '2026-02-25 07:30:00'),
(7, 'SHP003', 'Tram QL1K', 'Dang di chuyen', '2026-02-25 12:15:00'); -- Log mới nhất của SHP003

-- =================================================================
-- BÀI TẬP THỰC HÀNH
-- =================================================================

-- Câu 1 (Cơ bản): 
-- Tìm tất cả các vận đơn đang trong quá trình giao hàng (status là 'Delivering').
SELECT shipment_id, destination 
FROM Shipments 
WHERE status = 'Delivering';

-- Câu 2 (Trung bình - JOIN): 
-- Hiển thị danh sách các chuyến hàng kèm theo tên tài xế và loại xe phụ trách.
SELECT s.shipment_id, s.destination, d.full_name, d.vehicle_type, s.status
FROM Shipments s
JOIN Drivers d ON s.driver_id = d.driver_id;

-- Câu 3 (Khó - LEFT JOIN & COUNT): 
-- Thống kê xem mỗi tài xế đang phụ trách tổng cộng bao nhiêu vận đơn.
-- Yêu cầu hiển thị cả những tài xế chưa có đơn nào (như 'Le Van Z' sẽ có count = 0).
SELECT d.driver_id, d.full_name, COUNT(s.shipment_id) AS total_shipments
FROM Drivers d
LEFT JOIN Shipments s ON d.driver_id = s.driver_id
GROUP BY d.driver_id, d.full_name;

-- Câu 4 (Khó - Tìm Log MỚI NHẤT của từng đơn hàng): 
-- Ứng dụng Shopee/Lazada luôn hiển thị vị trí hiện tại của đơn hàng.
-- Hãy tìm ra dòng Tracking_Log có thời gian (log_time) gần đây nhất cho TỪNG shipment_id.
-- Hiển thị: shipment_id, location, status_note, log_time.
SELECT t1.shipment_id, t1.location, t1.status_note, t1.log_time
FROM Tracking_Logs t1
WHERE t1.log_time = (
    SELECT MAX(t2.log_time)
    FROM Tracking_Logs t2
    WHERE t2.shipment_id = t1.shipment_id
);