# Bài toán: Climbing Stairs

## 1. Đề bài
Bạn đang leo một cái cầu thang có `n` bậc.
Mỗi lần bạn có thể leo **1 bậc** hoặc **2 bậc**.
Hỏi có bao nhiêu cách khác nhau để leo lên đỉnh?

**Ví dụ:**
- Input: `n = 2` -> Output: `2` (1+1, 2)
- Input: `n = 3` -> Output: `3` (1+1+1, 1+2, 2+1)

## 2. Phân tích tối ưu

### Nhận xét quan trọng
Để leo lên bậc thứ `n`, bạn chỉ có thể đến từ:
1. Bậc `n-1` (leo thêm 1 bước).
2. Bậc `n-2` (leo thêm 2 bước).

=> Số cách lên bậc `n` = (Số cách lên `n-1`) + (Số cách lên `n-2`).
=> Công thức: $f(n) = f(n-1) + f(n-2)$.
=> **Đây chính là dãy Fibonacci!**

### Cách 1: Đệ quy (Recursion) ❌
- Gọi `climbStairs(n-1) + climbStairs(n-2)`.
- Độ phức tạp: $O(2^n)$. Quá chậm, tính đi tính lại các bài toán con trùng nhau.

### Cách 2: Dynamic Programming (Quy hoạch động) ✅
- **Tư duy:** Thay vì tính lại từ đầu, ta nhớ kết quả của 2 bậc trước đó.
- Ta chỉ cần 2 biến để lưu:
  - `one`: Số cách để lên bậc trước đó (n-1).
  - `two`: Số cách để lên bậc trước nữa (n-2).
- Tại mỗi bước mới: `current = one + two`.
- Sau đó dời vị trí: `two = one`, `one = current`.

- **Độ phức tạp thời gian:** $O(n)$ (Chạy vòng lặp 1 lần).
- **Độ phức tạp không gian:** $O(1)$ (Chỉ dùng 2 biến, không cần mảng `dp[]`).