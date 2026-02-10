# OOP Concepts: Employee Management

## 1. Đề bài
Xây dựng hệ thống quản lý nhân viên gồm:
- **Nhân viên Full-time:** Lương tính theo tháng cố định.
- **Nhân viên Part-time:** Lương tính theo giờ làm việc.
Yêu cầu tính lương và hiển thị thông tin, đảm bảo an toàn dữ liệu.

## 2. Phân tích 4 tính chất OOP

### 1. Abstraction (Trừu tượng hóa)
- Tạo một lớp cha trừu tượng `Employee`.
- Chúng ta không cần biết chi tiết tính lương thế nào ở mức này, chỉ biết là nhân viên thì phải có hành động `calculateSalary()`.
- -> Dùng `abstract class` và `abstract method`.

### 2. Encapsulation (Đóng gói)
- Dữ liệu cá nhân (tên, ID, lương cơ bản) không được để lộ thiên (`public`) cho ai muốn sửa thì sửa.
- -> Dùng `private` fields và cung cấp `Getter/Setter` để kiểm soát truy cập.

### 3. Inheritance (Kế thừa)
- `FullTimeEmployee` và `PartTimeEmployee` đều là con của `Employee`.
- Tụi nó sở hữu chung các thuộc tính (tên, id) của cha, không cần viết lại code.
- -> Từ khóa `extends`.

### 4. Polymorphism (Đa hình)
- Cùng là hàm `calculateSalary()`, nhưng:
  - Ông Full-time: Trả về lương cứng.
  - Ông Part-time: Trả về `lương giờ * số giờ`.
- -> Kỹ thuật `Override` phương thức.