# OOP Concepts: Generics (Universal Box)

## 1. Đề bài
Chúng ta cần tạo một lớp `Box` để lưu trữ dữ liệu.
- Yêu cầu: `Box` này lúc thì đựng số nguyên (`Integer`), lúc thì đựng chuỗi (`String`), lúc thì đựng nhân viên (`Employee`).
- Không được copy-paste code ra 3 class riêng biệt (`IntBox`, `StringBox`...).

## 2. Phân tích: Tại sao cần Generics?

### Cách cũ (Dùng Object)

    public class Box {
        private Object data; // Object là cha của mọi loại -> Chứa gì cũng được
    }

-> **Vấn đề:** Khi lấy ra, ta phải ép kiểu thủ công `(String) box.get()`. Nếu nhỡ tay ép sai (ví dụ: trong hộp là Số mà ép về Chuỗi) -> Bùm! `ClassCastException` (Lỗi chạy chương trình).

### Cách mới (Generics `<T>`) ✅
- Định nghĩa class `Box<T>`. `T` là một cái tên đại diện (Type).
- Khi dùng, ta truyền kiểu cụ thể vào: `Box<String>`, `Box<Integer>`.
- **Lợi ích:**
  1.  **An toàn:** Máy sẽ kiểm tra ngay lúc code. Nếu sếp cố nhét Số vào `Box<String>`, nó sẽ báo đỏ ngay (Compile Error), không đợi đến lúc chạy mới lỗi.
  2.  **Tái sử dụng:** Viết 1 lần, dùng cho mọi kiểu dữ liệu.

## 3. Cú pháp
- `T` (Type): Dùng cho kiểu dữ liệu bất kỳ.
- `E` (Element): Thường dùng cho các danh sách (List, Set).
- `K`, `V` (Key, Value): Dùng cho Map.