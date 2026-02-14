# SOLID: Single Responsibility Principle (SRP)

## 1. Đề bài
Chúng ta có một class `User`.
Ban đầu, class này làm đủ thứ:
1.  Lưu thông tin user (Tên, Email).
2.  Lưu user xuống Database.
3.  Gửi email chào mừng.

Điều này vi phạm SRP. Nếu sếp muốn đổi cách gửi email, sếp phải sửa class `User`. Nếu sếp muốn đổi Database, sếp cũng phải sửa class `User`. Rủi ro lỗi rất cao.

## 2. Phân tích: Bad vs Good

### Code vi phạm (Bad Design)

    class User {
        String name;
        
        // Sai: User không nên biết cách tự lưu mình vào DB
        void saveToDatabase() { ... } 
        
        // Sai: User không nên biết cách gửi Email
        void sendEmail() { ... } 
    }

### Code chuẩn SRP (Good Design) ✅
Chúng ta tách ra làm 3 class riêng biệt, mỗi người một việc:
1.  **User**: Chỉ chứa dữ liệu (POJO - Plain Old Java Object).
2.  **UserRepository**: Chuyên lo việc Database (Lưu, Xóa, Tìm).
3.  **EmailService**: Chuyên lo việc gửi Email.

-> **Lợi ích:** Khi cần sửa logic gửi mail, ta chỉ sửa `EmailService`, không sợ ảnh hưởng đến `UserRepository`.