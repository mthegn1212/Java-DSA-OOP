# SOLID: Dependency Inversion Principle (DIP)

## 1. Đề bài
Hệ thống E-commerce cần chức năng thanh toán đơn hàng (Checkout).
Ban đầu, hệ thống chỉ hỗ trợ thanh toán qua Momo.

## 2. Phân tích: Bad vs Good

### Code vi phạm (Bad Design)
Module cấp cao (`CheckoutService`) trực tiếp gọi (`new`) module cấp thấp (`MomoAPI`).

```java
class MomoAPI {
    void pay(double amount) { ... }
}

class CheckoutService {
    private MomoAPI momo = new MomoAPI();
    
    void processOrder(double total) {
        momo.pay(total);
    }
}
```

-> **Hậu quả:** Ngày mai sếp muốn thêm `ZaloPayAPI`, sếp phải chui vào class `CheckoutService` để sửa code (Vi phạm luôn cả OCP). Module cấp cao đang bị phụ thuộc vào một chi tiết cấp thấp.

### Code chuẩn DIP (Good Design) ✅
Tạo một "cái phễu" (Interface) ở giữa. Module cấp cao chỉ nói chuyện với cái phễu này.
1.  Interface `PaymentProcessor`: Khai báo hàm `pay()`.
2.  `MomoAPI` và `ZaloPayAPI`: Implements `PaymentProcessor`.
3.  `CheckoutService`: Chỉ nhận vào `PaymentProcessor` qua Constructor (gọi là Dependency Injection). Nó không tự `new` bất kỳ API nào.

-> **Lợi ích:** `CheckoutService` giờ đây miễn nhiễm với mọi thay đổi từ bên thứ 3. Thêm bao nhiêu cổng thanh toán cũng được!