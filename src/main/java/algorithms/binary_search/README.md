# Bài toán: Binary Search

## 1. Đề bài
Cho một mảng số nguyên `nums` **đã được sắp xếp tăng dần** và một số `target`.
Hãy tìm chỉ số (index) của `target` trong mảng. Nếu không tìm thấy, trả về `-1`.

**Ví dụ:**
- Input: `nums = [-1, 0, 3, 5, 9, 12]`, `target = 9`
- Output: `4` (Số 9 nằm ở vị trí index 4).

## 2. Phân tích tối ưu

### Cách 1: Linear Search (Duyệt tuần tự) ❌
- Chạy vòng lặp từ đầu đến cuối: `for (i -> n)`.
- Độ phức tạp: $O(n)$.
- **Vấn đề:** Nếu mảng có 1 tỷ phần tử, phải so sánh 1 tỷ lần. Quá chậm.

### Cách 2: Binary Search (Chia để trị) ✅
- **Điều kiện tiên quyết:** Mảng PHẢI đã được sắp xếp.
- **Tư duy:** Giống như tra từ điển. Ta mở trang giữa ra xem:
  1. Nếu `nums[mid] == target`: **BINGO!** Tìm thấy.
  2. Nếu `nums[mid] > target`: Số cần tìm nhỏ hơn số ở giữa -> Vứt bỏ nửa bên phải -> Chỉ tìm ở nửa bên trái (`right = mid - 1`).
  3. Nếu `nums[mid] < target`: Số cần tìm lớn hơn số ở giữa -> Vứt bỏ nửa bên trái -> Chỉ tìm ở nửa bên phải (`left = mid + 1`).
- Độ phức tạp: $O(\log n)$. (1 tỷ phần tử chỉ cần so sánh khoảng 30 lần).