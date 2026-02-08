# Bài toán: Linked List Cycle

## 1. Đề bài
Cho `head` của một danh sách liên kết. Hãy xác định xem danh sách này có chứa vòng lặp (cycle) hay không.
(Vòng lặp là khi node cuối cùng lại trỏ ngược về một node nào đó phía trước, khiến danh sách chạy mãi không dừng).

## 2. Phân tích tối ưu

### Cách 1: Dùng HashSet ❌
- Đi qua từng node và lưu địa chỉ node đó vào HashSet.
- Nếu gặp một node đã có trong Set -> Có vòng lặp.
- **Nhược điểm:** Tốn bộ nhớ $O(n)$ để lưu Set.

### Cách 2: Floyd's Tortoise and Hare (Rùa và Thỏ) ✅
- **Tư duy:** Dùng 2 con trỏ chạy trên đường đua.
  - **Rùa (Slow):** Chạy 1 bước/lần.
  - **Thỏ (Fast):** Chạy 2 bước/lần.
- **Logic:**
  - Nếu không có vòng lặp: Thỏ sẽ chạy đến đích (`null`) trước.
  - Nếu có vòng lặp: Thỏ chạy nhanh hơn sẽ "bắt vòng" và đuổi kịp Rùa (hai con trỏ gặp nhau tại 1 điểm).

- **Độ phức tạp thời gian:** $O(n)$.
- **Độ phức tạp không gian:** $O(1)$ (Không tốn thêm bộ nhớ lưu trữ).