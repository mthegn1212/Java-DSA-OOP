# SQL Practice 6: Logistics & Delivery Tracking

## 1. Giới thiệu
Bài tập mô phỏng hệ thống theo dõi vận đơn và giao hàng. Đây là mảnh ghép quan trọng của các hệ thống thương mại điện tử. Trọng tâm của bài này là kỹ năng truy vấn dữ liệu lịch sử (Time-series data) để tìm ra trạng thái và vị trí hiện tại/mới nhất của một đơn hàng.

## 2. Sơ đồ thực thể liên kết (ERD)

```text
+-------------------+       1   +-------------------+   1       +-------------------+
|      DRIVERS      |-----------|     SHIPMENTS     |-----------|   TRACKING_LOGS   |
+-------------------+       N   +-------------------+   N       +-------------------+
| PK: driver_id     |           | PK: shipment_id   |           | PK: log_id        |
|     full_name     |           | FK: driver_id     |           | FK: shipment_id   |
|     phone         |           |     destination   |           |     location      |
|     vehicle_type  |           |     status        |           |     status_note   |
+-------------------+           +-------------------+           |     log_time      |
                                                                +-------------------+
```
**Giải thích:**
- **Drivers**: Thông tin tài xế giao hàng.
- **Shipments**: Thông tin tổng quan của một chuyến giao hàng (Đích đến, Trạng thái tổng). 1 Tài xế có thể nhận nhiều Shipments.
- **Tracking_Logs**: Lịch sử di chuyển của đơn hàng. 1 Shipment sẽ có nhiều Logs (Ví dụ: Rời kho -> Đang trung chuyển -> Tới trạm phát -> Đã giao).

## 3. Kỹ năng trọng tâm
- **LEFT JOIN & COUNT**: Thống kê số lượng đơn hàng mà mỗi tài xế đang đảm nhận (bao gồm cả tài xế đang rảnh việc).
- **Subquery với MAX()**: Tuyệt chiêu để lấy ra dòng dữ liệu "mới nhất" (latest record) trong một nhóm. Đây là câu hỏi phân loại cực mạnh trong phòng thi.