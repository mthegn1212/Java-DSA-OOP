# Bài toán: Valid Parentheses

## 1. Đề bài
Cho một chuỗi `s` chỉ chứa các ký tự `(`, `)`, `{`, `}`, `[`, `]`. Hãy xác định xem chuỗi đầu vào có hợp lệ hay không.

**Điều kiện hợp lệ:**
1. Dấu mở phải được đóng bởi dấu đóng cùng loại.
2. Dấu mở phải được đóng theo đúng thứ tự (Cái nào mở sau cùng thì phải được đóng trước tiên).

**Ví dụ:**
- Input: `s = "()[]{}"` -> Output: `true`
- Input: `s = "(]"` -> Output: `false`
- Input: `s = "{[]}"` -> Output: `true` (Dấu `[` mở sau nên đóng trước, rồi mới tới `{`)

## 2. Phân tích tối ưu

### Tại sao dùng Stack?
- Đặc điểm của bài toán là **"Cái gì mở sau cùng phải được xử lý (đóng) trước tiên"**.
- Đây chính là nguyên lý **LIFO** (Last In, First Out) của Stack.

### Giải thuật:
1. Duyệt qua từng ký tự của chuỗi:
   - Nếu gặp **Dấu Mở** (`(`, `{`, `[`): Đẩy (push) vào Stack.
   - Nếu gặp **Dấu Đóng** (`)`, `}`, `]`):
     - Kiểm tra Stack có rỗng không? (Nếu rỗng nghĩa là có dấu đóng mà chưa từng có dấu mở -> Sai).
     - Lấy (pop) phần tử trên đỉnh Stack ra.
     - Kiểm tra xem cặp này có khớp không? (Ví dụ: `)` phải đi với `(`). Nếu không khớp -> Sai.
2. Sau khi duyệt hết chuỗi:
   - Kiểm tra Stack còn phần tử nào không?
   - Nếu Stack rỗng -> Hợp lệ (Tất cả đã được ghép cặp).
   - Nếu Stack còn thừa -> Sai (Có dấu mở mà chưa được đóng).

- **Độ phức tạp thời gian:** $O(n)$ (Duyệt chuỗi 1 lần).
- **Độ phức tạp không gian:** $O(n)$ (Trường hợp xấu nhất phải lưu tất cả dấu mở vào Stack).