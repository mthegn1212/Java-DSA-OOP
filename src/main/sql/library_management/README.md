# SQL Practice 4: Library Management System

## 1. Giới thiệu
Hệ thống Quản lý Thư viện tập trung vào việc theo dõi danh sách sách, độc giả và lịch sử mượn/trả. Bài tập này giúp rèn luyện kỹ năng xử lý dữ liệu kiểu thời gian (Date) và các truy vấn liên quan đến trạng thái chưa hoàn thành (ví dụ: sách chưa trả).

## 2. Sơ đồ thực thể liên kết (ERD)
Dưới đây là mô hình ERD thể hiện mối quan hệ 1-N (Một - Nhiều) giữa các bảng:

```text
+-------------------+       1   +-------------------+   N       +-------------------+
|     MEMBERS       |-----------|  BORROW_RECORDS   |-----------|       BOOKS       |
+-------------------+       N   +-------------------+   1       +-------------------+
| PK: member_id     |           | PK: record_id     |           | PK: book_id       |
|     full_name     |           | FK: member_id     |           |     title         |
|     join_date     |           | FK: book_id       |           |     author        |
|     status        |           |     borrow_date   |           |     total_copies  |
+-------------------+           |     return_date   |           +-------------------+
```
**Giải thích:**
- Một Độc giả (Member) có thể mượn nhiều lần (N Borrow_Records).
- Một Cuốn sách (Book) có thể được mượn nhiều lần bởi nhiều người (N Borrow_Records).
- `Borrow_Records` đóng vai trò là bảng trung gian xử lý quan hệ N-N giữa Members và Books.

## 3. Kỹ năng trọng tâm
- **Xử lý NULL**: `IS NULL` để tìm các sách chưa được trả.
- **Tính toán số liệu**: Kết hợp `COUNT()` với `GROUP BY` để tìm top sách mượn nhiều nhất.
- **Lọc theo logic thời gian**: Tìm những người mượn sách quá hạn.