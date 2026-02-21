-- =================================================================
-- HỆ THỐNG QUẢN LÝ SINH VIÊN VÀ ĐIỂM SỐ
-- =================================================================

-- 1. Tạo bảng Sinh viên (Students)
CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    full_name VARCHAR(100),
    major VARCHAR(50),
    enrollment_year INT
);

-- 2. Tạo bảng Học phần (Courses)
CREATE TABLE Courses (
    course_id VARCHAR(20) PRIMARY KEY,
    course_name VARCHAR(100),
    credits INT
);

-- 3. Tạo bảng Đăng ký học phần (Enrollments)
CREATE TABLE Enrollments (
    enrollment_id INT PRIMARY KEY,
    student_id INT,
    course_id VARCHAR(20),
    semester VARCHAR(20),
    grade DECIMAL(4, 2), -- Điểm hệ 10
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

-- =================================================================
-- CHÈN DỮ LIỆU MẪU (Mock Data)
-- =================================================================
INSERT INTO Students VALUES 
(2001, 'Dylan Zheng', 'Software Engineering', 2022),
(2002, 'Nguyen Van A', 'Information Systems', 2022),
(2003, 'Tran Thi B', 'Software Engineering', 2023),
(2004, 'Le Van C', 'Computer Science', 2023);

INSERT INTO Courses VALUES 
('SE101', 'Object Oriented Programming', 3),
('SE102', 'Data Structures and Algorithms', 4),
('SE103', 'Database Management Systems', 3),
('SE104', 'Quantum Machine Learning', 3), -- Môn tự chọn mới mở
('IS201', 'IT Project Management', 3);

INSERT INTO Enrollments VALUES 
(1, 2001, 'SE101', 'Fall 2025', 9.5),
(2, 2001, 'SE102', 'Fall 2025', 8.0),
(3, 2001, 'SE103', 'Spring 2026', 8.5),
(4, 2002, 'SE101', 'Fall 2025', 7.0),
(5, 2002, 'IS201', 'Spring 2026', 8.0),
(6, 2003, 'SE101', 'Fall 2025', 6.5);

-- =================================================================
-- BÀI TẬP THỰC HÀNH
-- =================================================================

-- Câu 1 (Cơ bản): 
-- Lấy danh sách tên và năm nhập học của tất cả sinh viên ngành 'Software Engineering'.
SELECT full_name, enrollment_year 
FROM Students 
WHERE major = 'Software Engineering';

-- Câu 2 (Trung bình - JOIN): 
-- Hiển thị Bảng điểm của sinh viên có tên 'Dylan Zheng' (Gồm: Tên môn học, Số tín chỉ, Học kỳ, Điểm).
SELECT c.course_name, c.credits, e.semester, e.grade
FROM Enrollments e
JOIN Students s ON e.student_id = s.student_id
JOIN Courses c ON e.course_id = c.course_id
WHERE s.full_name = 'Dylan Zheng';

-- Câu 3 (Khó - GROUP BY & HAVING): 
-- Tính điểm trung bình (GPA) của từng sinh viên. 
-- Chỉ hiển thị những sinh viên có GPA >= 8.0. (Hiển thị: student_id, full_name, GPA).
SELECT s.student_id, s.full_name, AVG(e.grade) AS gpa
FROM Enrollments e
JOIN Students s ON e.student_id = s.student_id
GROUP BY s.student_id, s.full_name
HAVING AVG(e.grade) >= 8.0;

-- Câu 4 (Khó - Lấy phần bù bằng LEFT JOIN): 
-- Tìm những môn học (course_name) CHƯA có bất kỳ sinh viên nào đăng ký.
-- (Tuyệt chiêu: Dùng LEFT JOIN và kiểm tra Null ở bảng bên phải).
SELECT c.course_name
FROM Courses c
LEFT JOIN Enrollments e ON c.course_id = e.course_id
WHERE e.enrollment_id IS NULL;