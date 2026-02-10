# Bài toán: Two Sum (Unsorted Array)

## 1. Đề bài
Cho một mảng số nguyên `nums` và một số nguyên `target`.
Hãy tìm **chỉ số (index)** của hai số trong mảng sao cho tổng của chúng bằng `target`.
(Giả định: Luôn có đúng 1 cặp kết quả).

**Ví dụ:**
- Input: `nums = [2, 7, 11, 15]`, `target = 9`
- Output: `[0, 1]` (Vì 2 + 7 = 9)

- Input: `nums = [3, 2, 4]`, `target = 6`
- Output: `[1, 2]` (Vì 2 + 4 = 6)

## 2. Phân tích tối ưu

### Tại sao không dùng Two Pointers?
- Two Pointers (`left`, `right`) chỉ dùng được khi mảng **đã sắp xếp**.
- Nếu ta sắp xếp mảng này, vị trí index ban đầu sẽ bị đảo lộn -> Sai yêu cầu đề bài.

### Cách tiếp cận: HashMap (Bảng băm) ✅
- **Tư duy:** Khi đang xét số `x`, ta cần tìm số `y` sao cho `x + y = target`.
  => Ta cần tìm `y = target - x` (gọi là phần bù - complement).
- Ta dùng HashMap để lưu lại những số đã đi qua theo dạng: `Map<Giá trị, Index>`.

**Thuật toán:**
1. Tạo một HashMap rỗng.
2. Duyệt qua từng phần tử `nums[i]`:
   - Tính phần bù cần tìm: `complement = target - nums[i]`.
   - Hỏi HashMap: "Ê, mày có chứa thằng `complement` này không?"
     - Nếu **CÓ**: Tìm thấy rồi! Trả về `[index của complement, i]`.
     - Nếu **KHÔNG**: Lưu thằng `nums[i]` và `i` vào Map để chờ thằng sau tìm tới.

- **Độ phức tạp thời gian:** $O(n)$ (Duyệt mảng 1 lần, tra cứu Map tốn O(1)).
- **Độ phức tạp không gian:** $O(n)$ (Lưu tối đa n phần tử vào Map).