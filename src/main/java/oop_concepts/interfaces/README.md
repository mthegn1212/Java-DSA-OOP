# OOP Concepts: Interfaces (Shape Calculator)

## 1. Đề bài
Chúng ta cần tính diện tích và chu vi cho các hình học khác nhau (Hình tròn, Hình chữ nhật).
Về mặt toán học, công thức của chúng khác nhau hoàn toàn, nhưng chúng có chung một **"Hợp đồng hành vi"**: Đã là hình học thì phải đo đạc được.

## 2. Phân tích: Interface vs Abstract Class

Tại sao dùng `interface` ở đây thay vì `abstract class`?

| Đặc điểm | Abstract Class | Interface |
| :--- | :--- | :--- |
| **Quan hệ** | "Là một" (Chó **là** Động vật) | "Có thể làm" / Hợp đồng (Hình **có thể** đo đạc) |
| **Đa kế thừa** | Không (Java chỉ cho extends 1 cha) | **Có** (Một class có thể implements nhiều interface) |
| **Thành phần** | Có thể có thuộc tính, hàm bình thường | Chỉ chứa hằng số và hàm trừu tượng (abstract methods) |

**Kết luận:**
Ở đây, `Shape` (Hình học) đóng vai trò là một **bản cam kết**. Bất kỳ class nào (Circle, Rectangle) muốn được gọi là `Shape` thì **BẮT BUỘC** phải viết code xử lý cho 2 hàm: `getArea()` và `getPerimeter()`.

## 3. Kiến trúc
- **Interface `Shape`**: Định nghĩa 2 hàm trống `getArea`, `getPerimeter`.
- **Class `Circle`**: `implements Shape` -> Cài đặt công thức hình tròn ($Pi * r^2$).
- **Class `Rectangle`**: `implements Shape` -> Cài đặt công thức hình chữ nhật ($dài * rộng$).