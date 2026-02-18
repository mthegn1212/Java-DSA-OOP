# SOLID: Interface Segregation Principle (ISP)

## 1. Đề bài
Chúng ta có một interface `Machine` với 3 chức năng: In, Scan, Fax.
Class `OldPrinter` (Máy in cũ) chỉ in được thôi.

## 2. Phân tích: Bad vs Good

### Code vi phạm (Bad Design)
Interface quá lớn (Fat Interface).

    interface Machine {
        void print(Document d);
        void scan(Document d);
        void fax(Document d);
    }
    
    class OldPrinter implements Machine {
        public void print(Document d) { ... }
        
        // Buộc phải override dù không dùng
        public void scan(Document d) { 
            throw new UnsupportedOperationException(); // Rác!
        }
        public void fax(Document d) { return; } // Rác!
    }

-> **Hậu quả:** `OldPrinter` bị ô nhiễm bởi những hàm vô dụng. Nếu sếp sửa hàm `scan()` trong interface, class `OldPrinter` cũng bị ảnh hưởng (dù nó chả liên quan gì).

### Code chuẩn ISP (Good Design) ✅
Chia nhỏ interface ra.
1.  Interface `Printer`: Chỉ có `print()`.
2.  Interface `Scanner`: Chỉ có `scan()`.
3.  `OldPrinter`: Chỉ implements `Printer`.
4.  `ModernPrinter`: Implements cả `Printer` và `Scanner`.

-> **Lợi ích:** Class nào dùng gì thì implement nấy. Code sạch sẽ, không thừa thãi.