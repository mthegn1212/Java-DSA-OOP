# SQL Practice: E-Commerce Fashion System

## 1. Giới thiệu
Đây là bài tập thực hành SQL mô phỏng một hệ thống cơ sở dữ liệu bán hàng thời trang (E-commerce). Mục tiêu là ôn tập và củng cố các kỹ năng truy vấn từ cơ bản đến nâng cao để chuẩn bị cho kỳ thi Kỹ năng thực hành chuyên môn.

## 2. Cấu trúc Database (Schema)
Hệ thống bao gồm 4 bảng chính có quan hệ với nhau:
- **Customers**: Lưu trữ thông tin khách hàng (customer_id, full_name, email, registration_date).
- **Products**: Lưu trữ thông tin sản phẩm quần áo (product_id, product_name, category, price).
- **Orders**: Lưu trữ thông tin tổng quan của đơn hàng (order_id, customer_id, order_date, total_amount).
- **Order_Items**: Lưu trữ chi tiết từng sản phẩm trong đơn hàng (order_item_id, order_id, product_id, quantity, unit_price).

## 3. Kỹ năng ôn tập
Bài tập này bao phủ các kiến thức trọng tâm thường gặp trong đề thi:
1.  **DDL & DML cơ bản**: `CREATE TABLE`, `INSERT INTO`.
2.  **Lọc dữ liệu**: `SELECT`, `WHERE`, toán tử so sánh.
3.  **Kết nối bảng (JOIN)**: Kết hợp dữ liệu từ nhiều bảng (ví dụ: lấy tên khách hàng cho từng đơn hàng).
4.  **Hàm tổng hợp & Gom nhóm**: `SUM()`, `COUNT()`, `GROUP BY`, `ORDER BY`.
5.  **Truy vấn con (Subquery) / Giới hạn**: Lọc ra các đối tượng có giá trị lớn nhất/nhỏ nhất.

## 4. Cách sử dụng
Toàn bộ mã nguồn tạo bảng, chèn dữ liệu giả (mock data) và các câu hỏi thực hành đều nằm trong file `practice_queries.sql`. Hãy tự viết lại các câu truy vấn trước khi xem phần lời giải!