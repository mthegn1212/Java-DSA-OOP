# SQL Practice 3: HR & Project Management System

## 1. Giới thiệu
Bài tập số 3 mô phỏng hệ thống quản lý nhân sự và phân công dự án. Đây là dạng bài kiểm tra kỹ năng truy vấn lồng nhau (Subquery) và kết nối nhiều bảng dữ liệu.

## 2. Cấu trúc Database (Schema)
Hệ thống gồm 4 bảng:
- **Departments**: Phòng ban (dept_id, dept_name).
- **Employees**: Nhân viên (emp_id, full_name, salary, dept_id).
- **Projects**: Dự án (project_id, project_name, budget).
- **Assignments**: Phân công (emp_id, project_id, role).

## 3. Kỹ năng trọng tâm
- **Đa kết nối (Multi-JOIN)**: JOIN từ 3-4 bảng cùng lúc.
- **Truy vấn con (Subqueries)**: Dùng mệnh đề `IN`, `NOT IN`.
- **Truy vấn con tương quan (Correlated Subqueries)**: So sánh dữ liệu của một dòng với một tập hợp được tính toán từ chính dòng đó (Ví dụ: So sánh lương nhân viên với trung bình lương của phòng ban đó).