# SQL Practice 8: Hospital Management System

## 1. Giới thiệu
Bài tập này tập trung thiết kế Mô hình Thực thể - Liên kết (ERD) cho một phòng khám. Hệ thống mô tả quy trình luân chuyển dữ liệu từ lúc Bệnh nhân đặt lịch, chọn Bác sĩ (thuộc Chuyên khoa nào đó), cho đến khi được chẩn đoán và kê Đơn thuốc.

## 2. Phân tích Mô hình ERD (Chuyên sâu)

```text
+---------------+       1   +---------------+   1       +---------------+
|  SPECIALTIES  |-----------|    DOCTORS    |-----------| APPOINTMENTS  |
+---------------+       N   +---------------+   N       +---------------+
| PK: spec_id   |           | PK: doc_id    |           | PK: appt_id   |
|     spec_name |           | FK: spec_id   |           | FK: doc_id    |
|     floor_no  |           |     full_name |           | FK: pat_id    |
+---------------+           |     phone     |           |     appt_date |
                            +---------------+           |     status    |
                                                        +---------------+
                                                                | N
                                                                |
+---------------+       1                                       |
|   PATIENTS    |-----------------------------------------------+
+---------------+                                               |
| PK: pat_id    |                                               | 1
|     full_name |                                       +---------------+
|     dob       |                                       | PRESCRIPTIONS |
|     gender    |                                       +---------------+
+---------------+                                       | PK: presc_id  |
                                                        | FK: appt_id   |
                                                        |     medicine  |
                                                        |     dosage    |
                                                        +---------------+
```

### Giải thích các mối quan hệ (Relationships):
1. **SPECIALTIES - DOCTORS (1-N):** Một Chuyên khoa (Khoa Nhi, Khoa Nội...) có nhiều Bác sĩ. Nhưng một Bác sĩ chỉ thuộc biên chế của 1 Khoa.
2. **PATIENTS - APPOINTMENTS (1-N):** Một Bệnh nhân có thể đến khám nhiều lần, tạo ra nhiều Lịch hẹn (Appointments) khác nhau theo thời gian.
3. **DOCTORS - APPOINTMENTS (1-N):** Một Bác sĩ trong một ngày có thể tiếp nhận nhiều Lịch hẹn từ các bệnh nhân khác nhau. Bảng `APPOINTMENTS` chính là bảng trung gian xử lý quan hệ N-N giữa Bác sĩ và Bệnh nhân.
4. **APPOINTMENTS - PRESCRIPTIONS (1-N):** Từ 1 Lịch hẹn khám (1 ca khám bệnh), bác sĩ có thể kê ra nhiều loại thuốc (Đơn thuốc chi tiết).

*Bài học thiết kế:* Khi thiết kế, ta không nối trực tiếp `Patients` với `Prescriptions`, vì thuốc được kê là kết quả của **một lần khám cụ thể** (`Appointments`), chứ không phải cứ là bệnh nhân thì sẽ có thuốc mặc định.

## 3. Kỹ năng truy vấn
Tập trung vào việc JOIN dọc theo chiều dài của ERD để lấy dữ liệu tổng hợp.