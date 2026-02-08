# Bài toán: Best Time to Buy and Sell Stock

## 1. Đề bài
Cho một mảng `prices` trong đó `prices[i]` là giá của một cổ phiếu vào ngày thứ `i`.
Bạn chỉ được phép thực hiện **một giao dịch** duy nhất (mua 1 lần và bán 1 lần).
Hãy tìm lợi nhuận lớn nhất có thể đạt được. (Lưu ý: Phải mua trước rồi mới được bán).

**Ví dụ:**
- Input: `prices = [7, 1, 5, 3, 6, 4]`
- Output: `5`
- Giải thích: Mua vào ngày 2 (giá = 1) và bán ra vào ngày 5 (giá = 6). Lợi nhuận = 6 - 1 = 5.

## 2. Phân tích tối ưu

### Cách 1: Brute Force (Trâu bò) ❌
- Dùng 2 vòng for lồng nhau:
  - Vòng 1 (i): Ngày mua.
  - Vòng 2 (j > i): Ngày bán.
  - Tính `profit = prices[j] - prices[i]`.
- Độ phức tạp: $O(n^2)$.

### Cách 2: One Pass (Duyệt 1 lần) ✅
- **Tư duy:** Để lãi cao nhất, ta cần mua ở giá **thấp nhất có thể** và bán ở giá cao nhất sau đó.
- Ta chỉ cần duy trì một biến `minPrice` (Giá thấp nhất từng thấy từ đầu đến giờ).
- Khi duyệt qua mỗi ngày:
  1. Nếu giá hôm nay < `minPrice` -> Cập nhật `minPrice` mới (Bắt đáy!).
  2. Nếu giá hôm nay > `minPrice` -> Tính thử lợi nhuận (`todayPrice - minPrice`) và so sánh với kỷ lục `maxProfit`.

- **Độ phức tạp thời gian:** $O(n)$.
- **Độ phức tạp không gian:** $O(1)$.