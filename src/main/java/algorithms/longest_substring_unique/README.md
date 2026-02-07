# Bài toán: Longest Substring Without Repeating Characters

## 1. Đề bài
Cho một chuỗi `s`. Hãy tìm độ dài của chuỗi con dài nhất mà trong đó **không có ký tự nào lặp lại**.

**Ví dụ:**
- Input: `s = "abcabcbb"`
- Output: `3`
- Giải thích: Chuỗi con dài nhất là "abc" (độ dài 3). Lưu ý "abcabc" là sai vì 'a' lặp lại.

## 2. Phân tích tối ưu

### Cách 1: Brute Force (Trâu bò) ❌
- Duyệt tất cả các chuỗi con có thể.
- Với mỗi chuỗi con, kiểm tra xem có ký tự trùng không.
- Độ phức tạp: $O(n^3)$. Chắc chắn TLE (Time Limit Exceeded).

### Cách 2: Sliding Window + HashSet ✅
- **Tư duy:** Dùng 2 con trỏ `left` và `right` tạo thành một cửa sổ.
- Dùng một cái `Set` để nhớ những ký tự đang có trong cửa sổ.
- **Quy tắc trượt:**
  1. Mở rộng `right`: Nếu ký tự `s[right]` **CHƯA** có trong Set -> Thêm vào Set, tính max độ dài, tăng `right`.
  2. Co lại `left`: Nếu ký tự `s[right]` **ĐÃ** có trong Set (bị trùng) -> Bắt buộc phải thu hẹp cửa sổ từ bên trái. Xóa `s[left]` khỏi Set và tăng `left` lên. Lặp lại việc xóa cho đến khi hết trùng.
- Độ phức tạp: $O(n)$ (Mỗi ký tự chỉ được thêm vào và xóa ra tối đa 1 lần).