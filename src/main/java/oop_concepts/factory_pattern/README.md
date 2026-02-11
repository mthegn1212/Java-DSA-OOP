# OOP Concepts: Factory Pattern (Notification System)

## 1. Đề bài
Hệ thống cần gửi thông báo (Notification) cho người dùng qua nhiều kênh: Email, SMS, Push Notification.
Client (người dùng code) chỉ muốn nói: "Gửi cho tôi cái Email", chứ không muốn lo lắng về việc khởi tạo đối tượng Email phức tạp thế nào.

## 2. Phân tích: Tại sao dùng Factory?

### Cách cũ (Không dùng Factory)
Client phải tự viết logic kiểm tra để chọn class, rất thủ công:

    Notification n;
    if (type.equals("EMAIL")) {
        n = new EmailNotification(); // Client bị dính chặt với class cụ thể
    } else if (type.equals("SMS")) {
        n = new SMSNotification();
    }

-> **Vấn đề:** Nếu sau này thêm `ZaloNotification`, ta phải sửa code ở phía Client -> Vi phạm nguyên tắc **Open/Closed** (Mở rộng thì được, hạn chế sửa code cũ).

### Cách mới (Factory Pattern) ✅
- Tạo một class `NotificationFactory`.
- Client chỉ cần gọi: `Factory.createNotification("EMAIL")`.
- Factory sẽ lo việc `if-else` và khởi tạo.
- **Lợi ích:** Giấu logic khởi tạo phức tạp, Client code gọn gàng, dễ bảo trì.

## 3. Cấu trúc
1.  **Interface Notification**: Định nghĩa hành vi chung (ví dụ: `notifyUser()`).
2.  **Concrete Classes**: `Email`, `SMS`, `Push` implement interface trên.
3.  **Class NotificationFactory**: Chứa hàm `createNotification(String type)` trả về đối tượng `Notification`.