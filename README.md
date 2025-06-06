# 📱 Online Mobile Store

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00758F?style=for-the-badge&logo=mysql&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)

---

## 📝 Project Description

**Online Mobile Store** is a full-stack web application that allows users to manage a collection of mobile phones through an intuitive interface. Built using **Java**, **Spring Boot**, **Spring MVC**, **Spring Data JPA**, and **MySQL**, this project features clean UI design using **HTML**, **CSS**, and **Bootstrap**.

---

## 🎯 Features

🔹 Add new mobile details  
🔹 Update existing mobile information  
🔹 Search mobiles by name or model  
🔹 Delete a mobile record  
🔹 View all mobiles with **pagination**  
🔹 Display useful messages using **HttpSession**

---

## 🛠️ Tech Stack

| Layer         | Technology                     |
|---------------|-------------------------------|
| 💻 Frontend    | HTML, CSS, Bootstrap          |
| 🧠 Backend     | Java, Spring Boot, Spring MVC |
| 💾 Database    | MySQL                         |
| 🧰 ORM         | Spring Data JPA               |
| 🌐 Server      | Embedded Tomcat               |
| 🧮 Pagination  | Spring JPA Pageable + UI      |

---

## 🔐 Session Usage

Session is used to:
- ✅ Display confirmation messages after add/update/delete
- ✅ Temporarily store user interaction feedback

---

## 📄 Pagination

Pagination is implemented using:
- `Pageable` from **Spring Data JPA**
- Page navigation UI for better user experience and performance

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 8 or higher  
- Maven  
- MySQL  
- IDE (IntelliJ / Eclipse)

### ⚙️ Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/online-mobile-store.git

2. Configure Database in application.properties

spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.url=jdbc:mysql://localhost:3306/mobile_db


3. Run the Application

mvn spring-boot:run


4. Open in Browser

http://localhost:8080/

---

## 📸 Screenshots

### 🔹 Home Page
![Home Page](https://via.placeholder.com/800x400?text=Home+Page)

### 🔹 Add Mobile
![Add Mobile](https://via.placeholder.com/800x400?text=Add+Mobile)

### 🔹 Mobile List with Pagination
![Mobile List](https://via.placeholder.com/800x400?text=Mobile+List)

### 🔹 Search Result
![Search Mobile](https://via.placeholder.com/800x400?text=Search+Mobile)

---
