# OOP Concepts: Composition ("Has-a" Relationship)

## 1. Đề bài
Mô phỏng một chiếc máy tính (Computer).
Một máy tính không "kế thừa" từ CPU hay RAM, mà nó **SỞ HỮU** (contains/has) các linh kiện đó.
- Máy tính **có** 1 bộ vi xử lý (Processor).
- Máy tính **có** 1 bộ nhớ (Memory).
- Máy tính **có** 1 màn hình (Monitor).

Khi máy tính khởi động, nó sẽ ra lệnh cho các linh kiện này hoạt động.

## 2. Phân tích: Composition vs Inheritance

| Đặc điểm | Inheritance (Kế thừa) | Composition (Hợp thành) |
| :--- | :--- | :--- |
| **Quan hệ** | "Is-a" (Laptop **là** Máy tính) | "Has-a" (Máy tính **có** CPU) |
| **Độ linh hoạt** | Thấp (Cấu trúc cứng nhắc, sửa cha ảnh hưởng con) | **Cao** (Dễ dàng thay thế linh kiện, ví dụ thay RAM 8GB bằng RAM 16GB) |
| **Tái sử dụng** | Kế thừa code | Tái sử dụng đối tượng |

**Thiết kế:**
- Class `Processor`, `Memory`, `Monitor`: Các linh kiện độc lập.
- Class `Computer`: Chứa các biến `private Processor cpu;`, `private Memory ram;`...
- Constructor của `Computer` sẽ nhận các linh kiện này vào (lắp ráp).