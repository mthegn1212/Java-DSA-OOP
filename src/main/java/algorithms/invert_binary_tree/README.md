# Bài toán: Invert Binary Tree

## 1. Đề bài
Cho `root` của một cây nhị phân (Binary Tree). Hãy lật ngược cây đó lại (như soi gương) và trả về `root` mới.

**Ví dụ:**
- Input: `4 -> [2, 7] -> [1, 3, 6, 9]`
- Output: `4 -> [7, 2] -> [9, 6, 3, 1]`

## 2. Phân tích tối ưu

### Cách tiếp cận: Đệ quy (Recursion - DFS)
- **Tư duy:** Để lật ngược cả cây, ta chỉ cần đứng tại mỗi node và ra lệnh: "Đổi chỗ 2 đứa con trái và phải của tao!".
- Sau đó, đệ quy xuống con trái và con phải để tụi nó tự làm việc tương tự với con của tụi nó.

**Thuật toán:**
1.  **Điều kiện dừng:** Nếu node hiện tại là `null` -> Trả về `null`.
2.  **Đổi chỗ (Swap):**
    - `temp = root.left`
    - `root.left = root.right`
    - `root.right = temp`
3.  **Đệ quy:**
    - `invertTree(root.left)`
    - `invertTree(root.right)`
4.  Trả về `root`.

- **Độ phức tạp thời gian:** O(n).
- **Độ phức tạp không gian:** O(h) (Chiều cao của cây).