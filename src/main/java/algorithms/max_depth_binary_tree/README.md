# Bài toán: Maximum Depth of Binary Tree

## 1. Đề bài
Cho `root` của một cây nhị phân. Hãy tìm chiều sâu lớn nhất (số lượng node trên đường đi dài nhất từ gốc xuống lá).

**Ví dụ:**
- Input:
```text
    3
   / \
  9  20
    /  \
   15   7
```
- Output: `3`
- Giải thích: Đường đi dài nhất là `3 -> 20 -> 7` hoặc `3 -> 20 -> 15`.

## 2. Phân tích tối ưu

### Cách tiếp cận: Đệ quy (DFS - Depth First Search) ✅

**Tư duy:**
Chiều sâu của một node sẽ bằng: `1 (chính nó) + Max(Chiều sâu con trái, Chiều sâu con phải)`.

Đây là bài toán con điển hình: Muốn biết bố cao bao nhiêu, phải hỏi 2 đứa con xem đứa nào cao hơn rồi cộng thêm 1.

**Thuật toán:**
1. **Base case:** Nếu node là `null` -> Chiều sâu là `0`.
2. **Đệ quy:**
   - Gọi `maxDepth(root.left)` để lấy chiều sâu bên trái.
   - Gọi `maxDepth(root.right)` để lấy chiều sâu bên phải.
3. **Kết quả:** Trả về `1 + Math.max(left, right)`.

**Độ phức tạp:**
- Thời gian: $O(n)$ (Thăm mỗi node đúng 1 lần).
- Không gian: $O(h)$ (Chiều cao cây - do ngăn xếp đệ quy).