# Bài toán: Two Sum II (Input Array Is Sorted)

## 1. Đề bài
Cho một mảng số nguyên `numbers` **đã được sắp xếp tăng dần** và một số nguyên `target`.
Hãy tìm chỉ số (index) của hai số sao cho tổng của chúng bằng `target`.

**Ví dụ:**
- Input: `numbers = [2, 7, 11, 15]`, `target = 9`
- Output: `[0, 1]` (Vì 2 + 7 = 9)

## 2. Phân tích tối ưu

### Cách 1: Brute Force (Trâu bò) ❌
- Dùng 2 vòng for lồng nhau: "Với mỗi số A, chạy hết mảng xem có số B nào khớp không".
- Độ phức tạp: $O(n^2)$.
- **Đánh giá:** Quá chậm, không tận dụng được dữ kiện "mảng đã sắp xếp".

### Cách 2: Two Pointers (Hai con trỏ) ✅
- Vì mảng đã sắp xếp (bé -> lớn), ta dùng 2 con trỏ:
  - `left`: Đứng đầu mảng (số bé nhất).
  - `right`: Đứng cuối mảng (số lớn nhất).
  
- **Chiến thuật:** Tính `sum = numbers[left] + numbers[right]`
  1. Nếu `sum == target`: **BINGO!** Xong phim.
  2. Nếu `sum > target`: Tổng đang to quá -> Cần giảm tổng xuống.
     - Vì mảng đã sắp xếp, muốn giảm tổng thì chỉ có cách chọn số bé hơn ở bên phải.
     - Hành động: `right--` (Dịch trỏ phải sang trái).
  3. Nếu `sum < target`: Tổng đang bé quá -> Cần tăng tổng lên.
     - Muốn tăng tổng thì phải chọn số lớn hơn ở bên trái.
     - Hành động: `left++` (Dịch trỏ trái sang phải).

- Độ phức tạp: $O(n)$ (Mỗi phần tử chỉ được duyệt qua tối đa 1 lần).
- Không gian: $O(1)$ (Không cần dùng Map).