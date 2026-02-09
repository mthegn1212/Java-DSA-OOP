# Bài toán: Valid Anagram

## 1. Đề bài
Cho hai chuỗi `s` và `t`. Hãy kiểm tra xem `t` có phải là từ đảo (anagram) của `s` hay không.

**Ví dụ:**
- Input: `s = "anagram"`, `t = "nagaram"` -> Output: `true`
- Input: `s = "rat"`, `t = "car"` -> Output: `false`

## 2. Phân tích tối ưu

### Cách 1: Sorting (Sắp xếp) ⚠️
- Sắp xếp cả 2 chuỗi theo thứ tự bảng chữ cái (`abc...`).
- So sánh 2 chuỗi sau khi sắp xếp.
- Độ phức tạp: $O(n \log n)$ (do chi phí sắp xếp). Hơi chậm.

### Cách 2: Frequency Counter (Mảng đếm) ✅
- **Tư duy:** Hai từ là anagram của nhau khi và chỉ khi chúng có **số lượng mỗi ký tự giống hệt nhau**.
- Vì đề bài thường chỉ gồm các chữ cái tiếng Anh thường ('a' -> 'z'), ta dùng một mảng số nguyên kích thước 26 (`int[26]`) thay vì dùng `HashMap` (vừa tốn bộ nhớ hơn, vừa chậm hơn chút).

**Thuật toán:**
1. Nếu độ dài `s` khác `t` -> `false` ngay lập tức.
2. Tạo mảng `count[26]`.
3. Duyệt qua chuỗi `s`: Tăng tần suất ký tự tương ứng lên.
4. Duyệt qua chuỗi `t`: Giảm tần suất ký tự tương ứng xuống.
5. Kiểm tra mảng `count`: Nếu tất cả đều về `0` thì là đúng. Nếu có bất kỳ số nào khác 0 -> Sai.

- **Độ phức tạp thời gian:** $O(n)$.
- **Độ phức tạp không gian:** $O(1)$ (Vì mảng luôn cố định 26 phần tử, không phụ thuộc độ dài chuỗi).