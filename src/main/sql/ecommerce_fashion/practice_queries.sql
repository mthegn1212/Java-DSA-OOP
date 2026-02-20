-- =================================================================
-- HỆ THỐNG QUẢN LÝ ĐƠN HÀNG THỜI TRANG (E-COMMERCE)
-- =================================================================

-- 1. Tạo bảng Khách hàng (Customers)
CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    full_name VARCHAR(100),
    email VARCHAR(100),
    registration_date DATE
);

-- 2. Tạo bảng Sản phẩm (Products)
CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(10, 2)
);

-- 3. Tạo bảng Đơn hàng (Orders)
CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

-- 4. Tạo bảng Chi tiết đơn hàng (Order_Items)
CREATE TABLE Order_Items (
    order_item_id INT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    unit_price DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

-- =================================================================
-- CHÈN DỮ LIỆU MẪU (Mock Data)
-- =================================================================
INSERT INTO Customers VALUES 
(1, 'Nguyen Van A', 'a@gmail.com', '2025-01-10'),
(2, 'Tran Thi B', 'b@gmail.com', '2025-02-15'),
(3, 'Le Van C', 'c@gmail.com', '2025-03-20');

INSERT INTO Products VALUES 
(101, 'Ao So Mi Nam', 'Ao', 350000),
(102, 'Quan Jean Nu', 'Quan', 450000),
(103, 'Ao Thun Unisex', 'Ao', 200000),
(104, 'Vay Hoa Nhi', 'Vay', 550000);

INSERT INTO Orders VALUES 
(1001, 1, '2025-05-01', 550000),
(1002, 2, '2025-05-05', 900000),
(1003, 1, '2025-05-10', 200000);

INSERT INTO Order_Items VALUES 
(1, 1001, 101, 1, 350000),
(2, 1001, 103, 1, 200000),
(3, 1002, 102, 2, 450000),
(4, 1003, 103, 1, 200000);

-- =================================================================
-- BÀI TẬP THỰC HÀNH
-- =================================================================

-- Câu 1 (Cơ bản - Lọc dữ liệu): 
-- Lấy danh sách các sản phẩm thuộc danh mục 'Ao' có giá lớn hơn 250,000.
SELECT product_id, product_name, price 
FROM Products 
WHERE category = 'Ao' AND price > 250000;

-- Câu 2 (Trung bình - JOIN): 
-- Hiển thị danh sách các đơn hàng bao gồm: order_id, tên khách hàng (full_name), ngày đặt và tổng tiền.
SELECT o.order_id, c.full_name, o.order_date, o.total_amount
FROM Orders o
JOIN Customers c ON o.customer_id = c.customer_id;

-- Câu 3 (Khó - GROUP BY & Hàm tổng hợp): 
-- Tính tổng số lượng sản phẩm đã bán ra cho từng product_id. 
-- Hiển thị: product_name, tổng số lượng bán (total_sold).
SELECT p.product_name, SUM(oi.quantity) AS total_sold
FROM Order_Items oi
JOIN Products p ON oi.product_id = p.product_id
GROUP BY p.product_id, p.product_name
ORDER BY total_sold DESC;

-- Câu 4 (Khó - Subquery / HAVING): 
-- Tìm khách hàng (full_name) có tổng giá trị mua hàng (tất cả các đơn) lớn nhất.
-- Cách dùng Subquery & LIMIT (Phổ biến trong MySQL/PostgreSQL)
SELECT c.full_name, SUM(o.total_amount) AS total_spent
FROM Customers c
JOIN Orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id, c.full_name
ORDER BY total_spent DESC
LIMIT 1;