-- =================================================================
-- HỆ THỐNG ĐẶT VÉ RẠP CHIẾU PHIM (CINEMA BOOKING)
-- =================================================================

-- 1. Bảng Khách hàng
CREATE TABLE Customers (
    cust_id INT PRIMARY KEY,
    full_name VARCHAR(100),
    phone VARCHAR(20)
);

-- 2. Bảng Phim
CREATE TABLE Movies (
    movie_id INT PRIMARY KEY,
    title VARCHAR(150),
    duration INT, -- Tính bằng phút
    genre VARCHAR(50)
);

-- 3. Bảng Phòng chiếu
CREATE TABLE Rooms (
    room_id INT PRIMARY KEY,
    room_name VARCHAR(50),
    capacity INT
);

-- 4. Bảng Suất chiếu (Liên kết Phim và Phòng)
CREATE TABLE Showtimes (
    show_id INT PRIMARY KEY,
    movie_id INT,
    room_id INT,
    start_time DATETIME,
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id),
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);

-- 5. Bảng Vé (Liên kết Khách hàng và Suất chiếu)
CREATE TABLE Tickets (
    ticket_id INT PRIMARY KEY,
    show_id INT,
    cust_id INT,
    seat_no VARCHAR(10),
    price DECIMAL(10, 2),
    FOREIGN KEY (show_id) REFERENCES Showtimes(show_id),
    FOREIGN KEY (cust_id) REFERENCES Customers(cust_id)
);

-- =================================================================
-- CHÈN DỮ LIỆU MẪU (Mock Data)
-- =================================================================
INSERT INTO Customers VALUES 
(1, 'Dylan Zheng', '0909000001'),
(2, 'Fan Marvel', '0909000002');

INSERT INTO Movies VALUES 
(10, 'Deadpool & Wolverine', 127, 'Action'),
(11, 'Kung Fu Panda 4', 94, 'Animation');

INSERT INTO Rooms VALUES 
(100, 'Cinema 1', 150),
(200, 'IMAX', 300);

INSERT INTO Showtimes VALUES 
(1001, 10, 200, '2026-03-01 19:00:00'), -- Deadpool chiếu rạp IMAX lúc 7h tối
(1002, 11, 100, '2026-03-01 10:00:00'); -- Panda chiếu rạp 1 lúc 10h sáng

INSERT INTO Tickets VALUES 
(1, 1001, 1, 'G10', 120000), -- Dylan mua vé xem Deadpool ghế G10
(2, 1001, 1, 'G11', 120000), -- Dylan mua thêm vé ghế G11
(3, 1002, 2, 'A1', 85000);   -- Fan mua vé xem Panda

-- =================================================================
-- BÀI TẬP THỰC HÀNH (Đã giảm tải)
-- =================================================================

-- Câu 1 (Hiểu cấu trúc ERD): 
-- Hãy in ra cái vé chi tiết của khách hàng 'Dylan Zheng'.
-- Yêu cầu hiển thị: Tên người mua, Tên phim, Tên Rạp, Giờ chiếu, Số ghế.
-- (Bắt buộc phải JOIN 5 bảng lại với nhau mới lấy đủ thông tin)
SELECT c.full_name, m.title, r.room_name, s.start_time, t.seat_no
FROM Tickets t
JOIN Customers c ON t.cust_id = c.cust_id
JOIN Showtimes s ON t.show_id = s.show_id
JOIN Movies m ON s.movie_id = m.movie_id
JOIN Rooms r ON s.room_id = r.room_id
WHERE c.full_name = 'Dylan Zheng';

-- Câu 2 (Thống kê Doanh thu):
-- Tính tổng doanh thu (tổng tiền bán vé) cho từng bộ phim.
-- Hiển thị: Tên phim, Tổng doanh thu.
SELECT m.title, SUM(t.price) AS total_revenue
FROM Tickets t
JOIN Showtimes s ON t.show_id = s.show_id
JOIN Movies m ON s.movie_id = m.movie_id
GROUP BY m.movie_id, m.title;