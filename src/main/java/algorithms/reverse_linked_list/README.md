# Bài toán: Reverse Linked List

## 1. Đề bài
Cho đầu (head) của một danh sách liên kết đơn. Hãy đảo ngược danh sách đó và trả về head mới.

**Ví dụ:**
- Input: `1 -> 2 -> 3 -> 4 -> 5 -> NULL`
- Output: `5 -> 4 -> 3 -> 2 -> 1 -> NULL`

## 2. Phân tích tối ưu

### Cách tiếp cận: Iterative (Duyệt tuần tự)
Để đảo ngược, ta cần thay đổi hướng mũi tên của từng node.
Thay vì `1 -> 2`, ta sửa thành `1 <- 2`.

Ta cần dùng **3 con trỏ** để không bị mất dấu:
1.  `prev`: Node phía trước (Ban đầu là `null`).
2.  `curr`: Node hiện tại đang xét (Ban đầu là `head`).
3.  `nextTemp`: Node phía sau (Để lưu đường đi tiếp theo trước khi cắt cầu).

**Thuật toán:**
Trong khi `curr` chưa phải là `null`:
1.  Lưu lại node tiếp theo: `nextTemp = curr.next`.
2.  Đảo chiều mũi tên: `curr.next = prev`.
3.  Dịch chuyển `prev` lên: `prev = curr`.
4.  Dịch chuyển `curr` lên: `curr = nextTemp`.

- **Độ phức tạp thời gian:** $O(n)$ (Duyệt qua mỗi node 1 lần).
- **Độ phức tạp không gian:** $O(1)$ (Chỉ dùng 3 biến con trỏ, không tạo danh sách mới).