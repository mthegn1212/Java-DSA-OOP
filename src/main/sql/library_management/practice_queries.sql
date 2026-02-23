-- =================================================================
-- HỆ THỐNG QUẢN LÝ THƯ VIỆN (LIBRARY MANAGEMENT)
-- =================================================================

-- 1. Tạo bảng Sách (Books)
CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(200),
    author VARCHAR(100),
    total_copies INT
);

-- 2. Tạo bảng Độc giả (Members)
CREATE TABLE Members (
    member_id INT PRIMARY KEY,
    full_name VARCHAR(100),
    join_date DATE,
    status VARCHAR(20) -- 'Active' hoặc 'Locked'
);

-- 3. Tạo bảng Lịch sử mượn trả (Borrow_Records)
CREATE TABLE Borrow_Records (
    record_id INT PRIMARY KEY,
    member_id INT,
    book_id INT,
    borrow_date DATE,
    return_date DATE, -- Nếu chưa trả thì cột này sẽ là NULL
    FOREIGN KEY (member_id) REFERENCES Members(member_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

-- =================================================================
-- CHÈN DỮ LIỆU MẪU (Mock Data)
-- =================================================================
INSERT INTO Books VALUES 
(101, 'Clean Code', 'Robert C. Martin', 5),
(102, 'Design Patterns', 'Gang of Four', 3),
(103, 'Giao Trinh SQL Co Ban', 'DH TDTU', 10),
(104, 'Quantum Computing for Babies', 'Chris Ferrie', 2);

INSERT INTO Members VALUES 
(1, 'Dylan Zheng', '2024-09-05', 'Active'),
(2, 'Nguyen Van A', '2025-01-10', 'Active'),
(3, 'Tran Thi B', '2023-11-20', 'Locked');

INSERT INTO Borrow_Records VALUES 
(1, 1, 101, '2026-02-01', '2026-02-15'), -- Dylan đã trả cuốn Clean Code
(2, 1, 104, '2026-02-10', NULL),        -- Dylan đang mượn cuốn Quantum Computing, chưa trả
(3, 2, 102, '2026-01-05', '2026-01-20'),
(4, 3, 103, '2025-12-01', NULL),        -- Người này mượn từ năm ngoái chưa trả (quá hạn)
(5, 1, 102, '2026-02-18', NULL);        -- Dylan mượn thêm cuốn Design Patterns

-- =================================================================
-- BÀI TẬP THỰC HÀNH
-- =================================================================

-- Câu 1 (Cơ bản - Xử lý NULL): 
-- Tìm tất cả các giao dịch mượn sách CHƯA TRẢ (return_date là khoảng trống).
SELECT record_id, member_id, book_id, borrow_date 
FROM Borrow_Records 
WHERE return_date IS NULL;

-- Câu 2 (Trung bình - JOIN 3 bảng): 
-- Hiển thị danh sách NHỮNG CUỐN SÁCH MÀ 'Dylan Zheng' ĐANG MƯỢN (chưa trả).
-- Yêu cầu hiển thị: Tên người mượn, Tên sách, Ngày mượn.
SELECT m.full_name, b.title, r.borrow_date
FROM Borrow_Records r
JOIN Members m ON r.member_id = m.member_id
JOIN Books b ON r.book_id = b.book_id
WHERE m.full_name = 'Dylan Zheng' AND r.return_date IS NULL;

-- Câu 3 (Khó - GROUP BY & ORDER BY): 
-- Thống kê xem mỗi cuốn sách đã được mượn bao nhiêu lần (kể cả đã trả hay chưa).
-- Sắp xếp giảm dần theo số lượt mượn để tìm sách Hot nhất.
-- Yêu cầu hiển thị: Tên sách, Số lượt mượn.
SELECT b.title, COUNT(r.record_id) AS borrow_count
FROM Books b
LEFT JOIN Borrow_Records r ON b.book_id = r.book_id
GROUP BY b.book_id, b.title
ORDER BY borrow_count DESC;

-- Câu 4 (Khó - Logic nghiệp vụ): 
-- Tìm những Độc giả đang giữ sách quá hạn (Giả sử quy định mượn tối đa là 14 ngày).
-- Hiển thị Tên độc giả và Số ngày đã mượn (Tính từ borrow_date đến ngày hiện tại '2026-02-23').
-- Gợi ý: Dùng DATEDIFF(ngày_hiện_tại, ngày_mượn). Cú pháp có thể khác nhau tùy hệ quản trị CSDL.
SELECT m.full_name, DATEDIFF('2026-02-23', r.borrow_date) AS days_borrowed
FROM Borrow_Records r
JOIN Members m ON r.member_id = m.member_id
WHERE r.return_date IS NULL 
  AND DATEDIFF('2026-02-23', r.borrow_date) > 14;