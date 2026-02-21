# SQL Practice 2: University Management System

## 1. Giới thiệu
Bài tập số 2 tập trung vào hệ thống quản lý sinh viên, học phần và điểm số. Đây là một domain cực kỳ phổ biến trong các đề thi thực hành chuyên môn.

## 2. Cấu trúc Database (Schema)
Hệ thống gồm 3 bảng:
- **Students**: Sinh viên (student_id, full_name, major, enrollment_year).
- **Courses**: Học phần (course_id, course_name, credits).
- **Enrollments**: Bảng trung gian lưu lịch sử đăng ký và điểm số (enrollment_id, student_id, course_id, semester, grade).

## 3. Kỹ năng trọng tâm
- **Aggregation functions**: `AVG()`, `COUNT()`.
- **Lọc dữ liệu gom nhóm**: Sử dụng `HAVING` kết hợp `GROUP BY`.
- **LEFT JOIN / IS NULL**: Kỹ thuật kinh điển để tìm các bản ghi "mồ côi" (ví dụ: Môn học chưa có ai đăng ký).