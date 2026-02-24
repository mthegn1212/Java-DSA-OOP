# SQL Practice 5: PlantDoctor Diagnosis System

## 1. Giới thiệu
Hệ thống mô phỏng cơ sở dữ liệu cho một ứng dụng AI chẩn đoán bệnh cây trồng (PlantDoctor). Bài tập này yêu cầu kỹ năng phân tích dữ liệu thống kê, đếm số lượng ca bệnh, và lọc các kết quả chẩn đoán dựa trên điểm tin cậy của mô hình AI.

## 2. Sơ đồ thực thể liên kết (ERD)
Hệ thống lấy bảng `Diagnosis_Logs` (Lịch sử chẩn đoán) làm trung tâm, liên kết với Người dùng, Cây trồng và Bệnh hại.

```text
+-------------------+       1   +-------------------+   N       +-------------------+
|     FARMERS       |-----------|  DIAGNOSIS_LOGS   |-----------|      CROPS        |
+-------------------+       N   +-------------------+   1       +-------------------+
| PK: farmer_id     |           | PK: log_id        |           | PK: crop_id       |
|     full_name     |           | FK: farmer_id     |           |     crop_name     |
|     region        |           | FK: crop_id       |           |     plant_type    |
+-------------------+           | FK: disease_id    |           +-------------------+
                                |     scan_date     |
+-------------------+   1       |     confidence    |
|    DISEASES       |-----------|                   |
+-------------------+   N       +-------------------+
| PK: disease_id    |
|     disease_name  |
|     severity      |
+-------------------+
```

## 3. Kỹ năng trọng tâm
- **Multi-JOIN 4 bảng**: Nối dữ liệu từ 4 bảng khác nhau để ra một báo cáo hoàn chỉnh.
- **Lọc theo điều kiện số (Float/Decimal)**: Lọc các kết quả có `confidence` (độ tự tin của AI) cao.
- **Thống kê chuyên sâu**: Tìm loại bệnh xuất hiện nhiều nhất trên một loại cây cụ thể.