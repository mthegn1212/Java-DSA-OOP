# SOLID: Liskov Substitution Principle (LSP)

## 1. Đề bài
Chúng ta có class `Bird` với hành động `fly()`.
Class `Ostrich` (Đà điểu) kế thừa `Bird`.
Vấn đề là đà điểu không biết bay.

## 2. Phân tích: Bad vs Good

### Code vi phạm (Bad Design)

    class Bird {
        void fly() { ... }
    }
    
    class Ostrich extends Bird {
        @Override
        void fly() {
            throw new Error("Đà điểu không biết bay!");
        }
    }

-> **Rủi ro:** Một hàm nào đó nhận vào `Bird` và gọi `bird.fly()`. Nếu ta truyền `Ostrich` vào, chương trình sẽ **CRASH** ngay lập tức. Đây là vi phạm LSP (Con không thay thế được Cha).

### Code chuẩn LSP (Good Design) ✅
Tách hành vi ra. Không phải con chim nào cũng biết bay.
1.  Class `Bird`: Chỉ có hành động chung như `eat()`.
2.  Interface `FlyingBird`: Kế thừa `Bird`, thêm `fly()`.
3.  `Sparrow` (Chim sẻ): Implements `FlyingBird`.
4.  `Ostrich` (Đà điểu): Chỉ implements `Bird`.

-> **Lợi ích:** Code xử lý bay chỉ làm việc với `FlyingBird`. Code xử lý ăn làm việc với `Bird`. Không còn rủi ro gọi nhầm hàm `fly()` cho đà điểu.