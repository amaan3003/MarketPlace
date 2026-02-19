📸 Dublin Student Marketplace

A Spring Boot-based web application for Dublin students to buy and sell camera gear. This project features a full MVC architecture, database integration, and dynamic image uploading.This project bridges the gap between a standard university assignment and a real-world functional application.

**NOTE** - The project is still under work and is in it's last stage of completion.

## Branch Structure
This repository is organized into two distinct branches:

**master**: The foundation. A basic web application featuring core CRUD (Create, Read, Update, Delete) functionality, built strictly for University submission.

**camera-marketplace**: The evolution. This is the primary branch where I have implemented advanced features like dynamic image uploading, professional UI layouts, and specialized logic for camera gear trading.

🚀 Features
- **Product** Listing: Users can list gear with name, description, and price.
- **Image Upload:** Professional image handling using UUID for unique naming and local storage.
- **Dynamic Marketplace:** Real-time table updates using Thymeleaf.
- **Professional UI:** Styled with Bootstrap for a clean, modern look.

## 🛠️ Tech Stack
- **Backend:** Java 17, Spring Boot 3, Spring Data JPA
- **Frontend:** Thymeleaf, Bootstrap 5, HTML/CSS
- **Database:** H2 Database (In-memory for development)
- **Build Tool:** Maven


## 🛠️ How to Run
1. Clone the repository.
2. Ensure you have JDK and Maven installed.
3. Run `./mvnw spring-boot:run` or play from IntelliJ.
5. Access the app at `http://localhost:8080`

## 🏗️ Future Enhancements
- [ ] User Authentication (Spring Security)
- [ ] External Image Storage (AWS S3)
- [ ] Search and Category Filters
- [ ] Delete and Update functionality
