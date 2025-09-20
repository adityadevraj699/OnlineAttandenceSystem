Here’s a professional **README.md** for your ERP Attendance System project that you can use on GitHub:


# ERP Attendance System

A simple and efficient **ERP Attendance System** built with **Spring Boot**, **Thymeleaf**, **Bootstrap**, and **MySQL**. This system allows students to mark their attendance and teachers to view and manage attendance records by date.

---

## Table of Contents

- [Features](#features)  
- [Demo](#demo)  
- [Technologies Used](#technologies-used)  
- [Setup Instructions](#setup-instructions)  
- [Project Structure](#project-structure)  
- [Screenshots](#screenshots)  
- [Future Enhancements](#future-enhancements)  
- [License](#license)  

---

## Features

### Student Side
- Enter Roll Number to mark attendance.
- Prevents multiple attendance markings for the same day.
- Displays success or error notifications using SweetAlert2.

### Teacher Side
- Select a date to view attendance.
- Displays attendance status for all students.
- Shows total students, present, and absent count.
- Filter attendance by status (Present/Absent) with clear button.
- Responsive design for desktop and mobile.

---

## Demo

- Home page with options to navigate to Student or Teacher dashboard.
- Student can mark attendance easily.
- Teacher can select a date to view attendance summary and table.

---

## Technologies Used

- **Backend:** Spring Boot, Java 17+  
- **Frontend:** Thymeleaf, HTML, CSS, Bootstrap 5  
- **Database:** MySQL  
- **Notifications:** SweetAlert2  
- **Build Tool:** Maven  

---

## Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/adityadevraj699/OnlineAttandenceSystem.git
   cd OnlineAttandenceSystem


2. **Configure MySQL**

   * Create a database named `erp_attendance`.
   * Update `application.properties` with your database credentials:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/erp_attendance
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**

   * Home: [http://localhost:8080](http://localhost:8080)
   * Student Dashboard: `/student`
   * Teacher Dashboard: `/teacher`

---

## Project Structure

```
erp-attendance-system/
├─ src/main/java/com/myproject/OnlineAttandenceSystem/
│  ├─ Controller/
│  │  └─ MainController.java
│  ├─ Model/
│  │  ├─ StudentDetail.java
│  │  └─ Attendance.java
│  ├─ Repository/
│  │  ├─ StudentDetailRepository.java
│  │  └─ AttendanceRepository.java
├─ src/main/resources/
│  ├─ templates/
│  │  ├─ index.html
│  │  ├─ student.html
│  │  └─ teacher.html
│  └─ application.properties
└─ pom.xml
```

---

## Screenshots

### Home Page
![Home Page](https://res.cloudinary.com/ddtcj9ks5/image/upload/v1758392455/Screenshot_2025-09-20_234903_cx3jh7.png)

### Student Dashboard
![Student Dashboard](https://res.cloudinary.com/ddtcj9ks5/image/upload/v1758392454/Screenshot_2025-09-20_234925_jr5os1.png)

### Teacher Dashboard
![Teacher Dashboard](https://res.cloudinary.com/ddtcj9ks5/image/upload/v1758392455/Screenshot_2025-09-20_234950_vjyw4x.png)


---

## Future Enhancements

* Add **login system** for students and teachers.
* Export attendance reports to **Excel/PDF**.
* Email notifications for absent students.
* Analytics dashboard with attendance trends.

---

