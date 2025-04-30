# 🏏 Cricket Player Management App

This is a simple **Spring Boot CRUD application** that manages cricket players using RESTful APIs. It allows adding, viewing, searching, and deleting players based on their roles.

---

## 🚀 Features

- Add a new player
- View all players
- View player by ID
- Delete player by ID
- Search players by role

---

## 📦 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Hibernate
- Lombok
- Log4j2
- Jakarta Validation

---

## 🧱 Project Structure

src/main/java/com/anik/cricket_app/<br>
├── controller/        --> REST API Controllers<br>
├── entity/            --> JPA Entity Classes<br>
├── exception/         --> Custom Exceptions<br>
├── model/             --> Request & Response DTOs<br>
├── repository/        --> Spring Data JPA Repositories<br>
├── service/           --> Service Layer Interfaces & Implementations

---

## 🔌 API Endpoints

| Method | Endpoint            | Description             |
|--------|---------------------|-------------------------|
| POST   | `/player`           | Add a new player        |
| GET    | `/player`           | Get all players         |
| GET    | `/player/{id}`      | Get player by ID        |
| DELETE | `/player/{id}`      | Delete player by ID     |
| GET    | `/player/search?role={role}` | Search players by role |

---

## 💻 How to Run the Project
git clone https://github.com/nazzmul-anik/cricket-player-management.git

---

### 📞 Contact
If you like this project or have any suggestions, feel free to connect with me on GitHub or nazzmul.anik@gmail.com

