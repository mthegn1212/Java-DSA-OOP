# OOP Concepts: Observer Pattern (YouTube Subscription)

## 1. Đề bài
Mô phỏng tính năng "Đăng ký kênh" (Subscribe) của YouTube.
- Có một Kênh (Channel).
- Có nhiều Người đăng ký (Subscribers).
- Khi Kênh ra video mới -> Tự động thông báo cho TẤT CẢ người đăng ký biết.

## 2. Phân tích: Polling vs Push

### Cách cũ (Polling - Hỏi liên tục)
Người dùng cứ 5 phút lại vào kênh check: "Có video mới chưa?".
-> **Tệ:** Tốn tài nguyên, server quá tải, người dùng tốn công.

### Cách mới (Observer - Cơ chế Đẩy) ✅
- **Subject (Kênh):** Giữ một danh sách email của người đăng ký.
- **Observer (Người xem):** Ngồi chơi xơi nước.
- Khi có video mới, Kênh sẽ chạy vòng lặp, gửi thông báo đến từng người trong danh sách.
- **Loose Coupling:** Kênh không cần biết người xem là ai, làm nghề gì, chỉ cần biết họ có hàm `update()` để nhận tin.

## 3. Cấu trúc
1.  **Interface Observer**: Quy định hàm `update(String msg)`.
2.  **Interface Subject**: Quy định hàm `registerObserver`, `removeObserver`, `notifyObservers`.
3.  **Class YouTubeChannel**: Implement Subject.
4.  **Class Subscriber**: Implement Observer.