# Bài toán: Maximum Subarray Sum

## 1. Đề bài
Cho một mảng số nguyên `nums`. Hãy tìm một mảng con liên tiếp (contiguous subarray) có tổng lớn nhất và trả về tổng đó.

**Ví dụ:**
- Input: `nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`
- Output: `6`
- Giải thích: Mảng con `[4, -1, 2, 1]` có tổng lớn nhất là 6.

## 2. Phân tích tối ưu

### Cách 1: Brute Force (Trâu bò) - Dở tệ ❌
- Dùng 2 vòng for lồng nhau để tính tổng tất cả các mảng con có thể.
- Độ phức tạp: $O(n^2)$.
- **Kết quả:** Chậm, không đạt yêu cầu full điểm.

### Cách 2: Kadane's Algorithm - Tối ưu ✅
- Tư duy: Duyệt qua mảng đúng **1 lần** duy nhất.
- Tại mỗi phần tử, ta quyết định:
    1. Cộng gộp phần tử hiện tại vào tổng trước đó?
    2. Hay là bỏ cái cũ đi, bắt đầu tính lại từ phần tử hiện tại (nếu tổng trước đó làm mình "lỗ", tức là < 0)?
- Độ phức tạp: $O(n)$.