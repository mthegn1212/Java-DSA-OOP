# SQL Practice 7: Cinema Ticket Booking System

## 1. Giới thiệu
Bài tập này tập trung vào kỹ năng **Thiết kế cơ sở dữ liệu (Database Design)** và **Mô hình Thực thể - Liên kết (ERD)**. Hệ thống đặt vé xem phim là một bài toán kinh điển để rèn luyện tư duy tách bảng và chuẩn hóa dữ liệu (Normalization), tránh tình trạng trùng lặp thông tin.

## 2. Phân tích Mô hình ERD (Chuyên sâu)

Bài toán: Một bộ Phim có thể chiếu ở nhiều Suất, tại nhiều Phòng khác nhau. Một Khách hàng có thể mua nhiều Vé cho một hoặc nhiều Suất chiếu.

```text
+---------------+       1   +---------------+   1       +---------------+
|    MOVIES     |-----------|   SHOWTIMES   |-----------|    TICKETS    |
+---------------+       N   +---------------+   N       +---------------+
| PK: movie_id  |           | PK: show_id   |           | PK: ticket_id |
|     title     |           | FK: movie_id  |           | FK: show_id   |
|     duration  |           | FK: room_id   |           | FK: cust_id   |
|     genre     |           |     start_time|           |     seat_no   |
+---------------+           +---------------+           |     price     |
                                    | N                 +---------------+
+---------------+       1           |                           | N
|    ROOMS      |-------------------+                           |
+---------------+                                               |
| PK: room_id   |                                               | 1
|     room_name |                                       +---------------+
|     capacity  |                                       |   CUSTOMERS   |
+---------------+                                       +---------------+
                                                        | PK: cust_id   |
                                                        |     full_name |
                                                        |     phone     |
                                                        +---------------+
```

### Giải thích các mối quan hệ (Relationships):
1. **MOVIES - SHOWTIMES (1-N):** - Một bộ phim (ví dụ: *Mai*) có thể được chiếu vào nhiều khung giờ khác nhau (Nhiều Suất chiếu).
2. **ROOMS - SHOWTIMES (1-N):** - Một phòng chiếu (Rạp 1) có thể phục vụ nhiều Suất chiếu trong ngày. Tuy nhiên, tại một thời điểm `start_time`, Suất chiếu đó chỉ thuộc về đúng 1 Phòng chiếu.
3. **SHOWTIMES - TICKETS (1-N):** - Một Suất chiếu (Ví dụ: 19:00, Rạp 1, Phim Mai) sẽ phát hành ra nhiều chiếc Vé (Số ghế A1, A2...).
4. **CUSTOMERS - TICKETS (1-N):** - Khách hàng có thể mua nhiều chiếc Vé khác nhau.

*Lưu ý thiết kế:* Bảng `SHOWTIMES` đóng vai trò là "Trái tim" kết nối `MOVIES` và `ROOMS`. Bảng `TICKETS` là chi tiết giao dịch kết nối Khách hàng với Suất chiếu.

## 3. Kỹ năng truy vấn (Đã giảm tải)
- Do cấu trúc bảng chặt chẽ, các truy vấn chỉ tập trung vào việc dùng `JOIN` liên hoàn để lấy thông tin.