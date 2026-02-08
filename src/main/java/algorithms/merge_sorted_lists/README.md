# Bài toán: Merge Two Sorted Lists

## 1. Đề bài
Cho hai danh sách liên kết `list1` và `list2` đều đã được sắp xếp tăng dần. Hãy gộp chúng lại thành **một** danh sách liên kết mới cũng được sắp xếp tăng dần.

**Ví dụ:**
- Input: `list1 = 1 -> 2 -> 4`, `list2 = 1 -> 3 -> 4`
- Output: `1 -> 1 -> 2 -> 3 -> 4 -> 4`

## 2. Phân tích tối ưu

### Kỹ thuật: Dummy Node (Nút giả)
- Khi gộp 2 danh sách, ta không biết node đầu tiên (head) của danh sách mới sẽ lấy từ `list1` hay `list2` (tùy thuộc số nào nhỏ hơn).
- Thay vì viết `if` để kiểm tra khởi tạo head, ta tạo một **Dummy Node** (ví dụ giá trị -1 hoặc 0) làm mốc.
- Danh sách kết quả sẽ bắt đầu từ `dummy.next`.

### Giải thuật:
1. Tạo `dummy` node. Tạo con trỏ `current` trỏ vào `dummy`.
2. So sánh phần tử đầu của `list1` và `list2`:
   - Bên nào nhỏ hơn thì nối `current.next` vào bên đó.
   - Dịch chuyển con trỏ của bên đó lên 1 bước.
   - Dịch chuyển `current` lên 1 bước.
3. Lặp lại cho đến khi một trong hai danh sách hết node (`null`).
4. Nối phần còn lại của danh sách chưa hết vào đuôi `current`.
5. Trả về `dummy.next`.

- **Độ phức tạp thời gian:** $O(n + m)$ (Duyệt qua tổng số phần tử của cả 2 danh sách).
- **Độ phức tạp không gian:** $O(1)$ (Chỉ thay đổi mối nối, không tạo danh sách mới).