# Bài toán: Binary Tree Level Order Traversal

## 1. Đề bài
Cho `root` của một cây nhị phân. Hãy trả về giá trị của các node theo thứ tự **từng tầng một** (từ trái sang phải, từ trên xuống dưới).
**Ví dụ:**
- Input:
```text
    3
   / \
  9  20
    /  \
   15   7
```
- Output: `[[3], [9, 20], [15, 7]]`

## 2. Phân tích tối ưu
### Tại sao không dùng Đệ quy (DFS)?
- DFS (như bài Max Depth) có xu hướng đâm sâu xuống dưới cùng rồi mới quay lại. Muốn gom nhóm theo tầng bằng DFS khá phức tạp (phải truyền thêm biến `level` và dùng HashMap).

### Cách tiếp cận: BFS (Queue) ✅
- **Tư duy:** Sử dụng hàng đợi (**Queue** - Vào trước ra trước).
- **Quy trình:**
  1. Cho `root` vào Queue.
  2. Khi Queue không rỗng:
     - Đếm xem hiện tại trong Queue có bao nhiêu node (đó chính là **số node của tầng hiện tại**).
     - Lấy từng đó node ra, cho vào danh sách con.
     - Đồng thời, nếu node đó có con (trái/phải), nhét con vào cuối Queue (để dành cho tầng sau).
  3. Lặp lại cho đến khi Queue rỗng.

- **Độ phức tạp thời gian:** $O(n)$ (Thăm mỗi node 1 lần).
- **Độ phức tạp không gian:** $O(w)$ (w là độ rộng lớn nhất của cây - số node tối đa ở 1 tầng).