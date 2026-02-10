# OOP Concepts: Singleton Pattern (Database Connection)

## 1. Đề bài
Trong một ứng dụng, việc tạo kết nối đến cơ sở dữ liệu (Database Connection) rất tốn tài nguyên (RAM, CPU, Time).
Chúng ta muốn đảm bảo rằng **chỉ có duy nhất một đối tượng kết nối** được tạo ra và dùng chung cho toàn bộ hệ thống. Không cho phép ai đó tùy tiện `new DatabaseConnection()` nhiều lần.

## 2. Phân tích: Singleton hoạt động thế nào?

Để biến một class thường thành Singleton, ta cần 3 bước "trấn phái":

1.  **Private Static Variable**: Tạo một biến tĩnh `instance` để lưu trữ bản thể duy nhất đó.
2.  **Private Constructor**: Khóa chặt hàm khởi tạo lại. Không cho phép bên ngoài gọi `new ClassName()`.
3.  **Public Static Method**: Cung cấp một "cánh cổng" duy nhất (`getInstance`) để bên ngoài xin cấp phát đối tượng.
    - Nếu đối tượng chưa có -> Tạo mới.
    - Nếu có rồi -> Trả về cái đang có.

**So sánh:**
- **Class thường:** `A x = new A();` (Mỗi lần new là một vùng nhớ mới).
- **Singleton:** `A x = A.getInstance();` (Gọi 100 lần thì vẫn trả về đúng 1 vùng nhớ đó).