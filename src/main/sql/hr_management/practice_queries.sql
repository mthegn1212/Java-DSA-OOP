-- =================================================================
-- HỆ THỐNG QUẢN LÝ NHÂN SỰ & DỰ ÁN
-- =================================================================

-- 1. Tạo bảng Phòng ban (Departments)
CREATE TABLE Departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(100)
);

-- 2. Tạo bảng Nhân viên (Employees)
CREATE TABLE Employees (
    emp_id INT PRIMARY KEY,
    full_name VARCHAR(100),
    salary DECIMAL(15, 2),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);

-- 3. Tạo bảng Dự án (Projects)
CREATE TABLE Projects (
    project_id VARCHAR(20) PRIMARY KEY,
    project_name VARCHAR(100),
    budget DECIMAL(15, 2)
);

-- 4. Tạo bảng Phân công (Assignments)
CREATE TABLE Assignments (
    emp_id INT,
    project_id VARCHAR(20),
    role VARCHAR(50),
    PRIMARY KEY (emp_id, project_id),
    FOREIGN KEY (emp_id) REFERENCES Employees(emp_id),
    FOREIGN KEY (project_id) REFERENCES Projects(project_id)
);

-- =================================================================
-- CHÈN DỮ LIỆU MẪU (Mock Data)
-- =================================================================
INSERT INTO Departments VALUES 
(10, 'IT Department'),
(20, 'Marketing'),
(30, 'Human Resources');

INSERT INTO Employees VALUES 
(1, 'Dylan Zheng', 25000000, 10),
(2, 'Nguyen Van A', 15000000, 10),
(3, 'Tran Thi B', 18000000, 20),
(4, 'Le Van C', 12000000, 20),
(5, 'Pham Thi D', 10000000, 30);

INSERT INTO Projects VALUES 
('P1', 'E-commerce Website', 500000000),
('P2', 'Marketing Campaign Q1', 200000000),
('P3', 'Internal HR Portal', 100000000);

INSERT INTO Assignments VALUES 
(1, 'P1', 'Tech Lead'),
(2, 'P1', 'Developer'),
(3, 'P2', 'Marketing Manager'),
(1, 'P3', 'Consultant'); -- Dylan tham gia 2 dự án

-- =================================================================
-- BÀI TẬP THỰC HÀNH (Kèm Lời Giải)
-- =================================================================

-- Câu 1 (Cơ bản): 
-- Hiển thị danh sách nhân viên gồm: tên nhân viên, lương và tên phòng ban của họ.
SELECT e.full_name, e.salary, d.dept_name
FROM Employees e
JOIN Departments d ON e.dept_id = d.dept_id;

-- Câu 2 (Trung bình - Multi-JOIN): 
-- Tìm tất cả các dự án mà nhân viên 'Dylan Zheng' đang tham gia. 
-- Hiển thị: project_name, role.
SELECT p.project_name, a.role
FROM Employees e
JOIN Assignments a ON e.emp_id = a.emp_id
JOIN Projects p ON a.project_id = p.project_id
WHERE e.full_name = 'Dylan Zheng';

-- Câu 3 (Khó - Subquery / NOT IN): 
-- Tìm những nhân viên HIỆN TẠI KHÔNG tham gia bất kỳ dự án nào.
-- (Bảng Employees có 5 người, nhưng Assignments chỉ phân công 3 người).
SELECT full_name, salary
FROM Employees
WHERE emp_id NOT IN (
    SELECT emp_id FROM Assignments
);

-- Câu 4 (Cực khó - Correlated Subquery): 
-- Liệt kê những nhân viên có mức lương CAO HƠN mức lương trung bình của PHÒNG BAN MÀ HỌ ĐANG LÀM VIỆC.
-- Hiển thị: full_name, salary, dept_id.
SELECT e1.full_name, e1.salary, e1.dept_id
FROM Employees e1
WHERE e1.salary > (
    SELECT AVG(e2.salary)
    FROM Employees e2
    WHERE e2.dept_id = e1.dept_id
);