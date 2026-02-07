# Bài toán: Maximum Sum Subarray of Size K

## 1. Đề bài
Cho một mảng số nguyên `arr` và một số nguyên `k`. Hãy tìm tổng lớn nhất của một mảng con liên tiếp có độ dài đúng bằng `k`.

**Ví dụ:**
- Input: `arr = [2, 1, 5, 1, 3, 2]`, `k = 3`
- Output: `9`
- Giải thích: Mảng con có tổng lớn nhất là `[5, 1, 3]` (Tổng = 9).

## 2. Phân tích tối ưu

### Cách 1: Brute Force (Trâu bò) ❌
- Với mỗi phần tử, chạy một vòng lặp `k` lần để tính tổng.
- Độ phức tạp: $O(n \times k)$.
- **Vấn đề:** Tính toán trùng lặp quá nhiều. Ví dụ `[2, 1, 5]` và `[1, 5, 1]` có chung đoạn `[1, 5]` mà phải tính lại 2 lần.

### Cách 2: Sliding Window (Cửa sổ trượt) ✅
- **Tư duy:** Coi `k` phần tử như một cái khung cửa sổ.
- Bước 1: Tính tổng cửa sổ đầu tiên (k phần tử đầu).
- Bước 2: Trượt cửa sổ sang phải 1 đơn vị:
  - **Cộng** phần tử mới đi vào (`arr[i]`).
  - **Trừ** phần tử cũ bị rớt ra (`arr[i-k]`).
- Độ phức tạp: $O(n)$ (Mỗi phần tử chỉ cộng/trừ đúng 1 lần).