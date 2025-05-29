# ✈️ App

Ứng dụng quản lý vé máy bay gồm 2 phần: **Frontend (React/Vite)** và **Backend (Spring Boot + SQL Server)**.

---

## 💻 Yêu cầu hệ thống

### 1. Phần mềm cần cài đặt

| Phần mềm       | Phiên bản khuyên nghị   |
| -------------- | ----------------------- |
| Java           | 22                      |
| Maven          | 3.8+                    |
| Node.js + npm  | Node 18+ / npm 9+       |
| SQL Server     | 2019 hoặc mới hơn       |
| IDE (tuỳ chọn) | IntelliJ IDEA / VS Code |

---

## 🛠️ Thiết lập cơ sở dữ liệu

### 1. Tạo database trong SQL Server

Ví dụ:

```sql
CREATE DATABASE flightdb;
```

### 2. Cấu hình file `application.properties`

Tạo file `src/main/resources/application.properties` trong thư mục `backend`, thêm vào:

```properties
spring.application.name=flightapp
# Địa chỉ kết nối đến SQL Server
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=banve1;encrypt=true;trustServerCertificate=true

# Thông tin đăng nhập
spring.datasource.username=
spring.datasource.password=

# Hiện SQL trong console
#spring.jpa.show-sql=true

# Hibernate tự cập nhật bảng theo entity
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.SQLServerDialect
spring.jpa.properties.hibernate.format_sql=true
# Dialect cho SQL Server
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect


# (Tùy chọn) Charset
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

spring.jpa.properties.hibernate.c3p0.max_size=20
spring.jpa.properties.hibernate.c3p0.min_size=5x

spring.jpa.show-sql=true
logging.level.org.hibernate.SQL=false
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=false

```

điền thông tin đăng nhập database ở trên  và tên database vừa mới tạo 

```
spring.datasource.username=
spring.datasource.password=
```
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=[điền tên data base vào đây];encrypt=true;trustServerCertificate=true



---

## 🚀 Cách chạy chương trình

### 📦 Chạy Backend (Spring Boot)

1. Mở terminal tại thư mục `backend`
2. Build chương trình:

```bash
mvn clean install
```

3. Chạy chương trình:

```bash
mvn spring-boot:run
```

> Backend sẽ chạy ở địa chỉ: `http://localhost:8080`

---

### 🌐 Chạy Frontend (React)

1. Mở terminal tại thư mục `frontend`

2. Chạy ứng dụng:

```bash
npm run dev
```

> Frontend thường chạy ở địa chỉ: `http://localhost:5173` (tuỳ theo cấu hình Vite)

---

## 🔗 Kết nối Frontend ↔ Backend

Trong file cấu hình API bên frontend (thường là `api.js`, `.env`, hoặc tương tự), hãy đảm bảo URL trỏ đến backend:

```js
const API_BASE_URL = "http://localhost:8080";
```

---

