# SOLID: Open/Closed Principle (OCP)

## 1. Đề bài
Chúng ta có class `AreaCalculator` để tính tổng diện tích các hình.
Ban đầu chỉ có hình chữ nhật (`Rectangle`). Sau đó sếp muốn thêm hình tròn (`Circle`).

## 2. Phân tích: Bad vs Good

### Code vi phạm (Bad Design)
Dùng quá nhiều `if-else` hoặc `instanceof`.

    public double calculateArea(Object shape) {
        if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.width * r.height;
        } else if (shape instanceof Circle) {
            // Phải sửa code ở đây nếu thêm hình mới -> VI PHẠM OCP
            Circle c = (Circle) shape;
            return c.radius * c.radius * Math.PI;
        }
    }

-> **Rủi ro:** Mỗi lần thêm hình mới (Tam giác, Hình vuông...), sếp phải mở class `AreaCalculator` ra sửa. Sửa càng nhiều, bug càng dễ đẻ ra ở code cũ.

### Code chuẩn OCP (Good Design) ✅
Dùng **Polymorphism (Đa hình)** thông qua Interface.
1.  Tạo interface `Shape` có hàm `getArea()`.
2.  `Rectangle`, `Circle` tự mình tính toán diện tích của nó.
3.  `AreaCalculator` chỉ việc gọi `shape.getArea()`.

-> **Lợi ích:** Khi thêm `Triangle`, sếp chỉ cần tạo class mới implements `Shape`. Class `AreaCalculator` **không cần sửa một dòng nào** (Đóng với việc sửa đổi).