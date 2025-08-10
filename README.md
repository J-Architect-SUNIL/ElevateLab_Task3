# ElevateLab_Task3
# 📚 Library Management System

## 📌 Description
The **Library Management System** is a Java-based console application that allows **admins** and **users** to manage and reserve books. It provides:
- **Admin Features:**
  - Add new books.
  - View all books with availability status.
  - Update book availability.
  - Delete books.
- **User Features:**
  - View available books.
  - Reserve books (status changes to "Not Available").
- **Registration & Authentication:**
  - Users/Admins must be registered before accessing the system.
  - New users can register with Name, User ID, and Department.

This program uses **Java Vectors** for storing user and book data and provides an interactive **console-based menu system**.

---

## ⚙️ How It Works
1. **Start Program** → Choose `(1) Admin`, `(2) User`, or `(3) Exit`.
2. **Admin Mode**:
   - Login with existing Admin ID or register.
   - Access menu to Add/View/Update/Delete books.
3. **User Mode**:
   - Login with existing User ID or register.
   - View books and reserve them.
4. **Exit** → Closes the system.

---

## 🛠 Technologies Used
- Java (Core Java, Collections - `Vector`)
- Console I/O (`Scanner`)

---

## ▶️ How to Run
1. Save the file as `Task_3_Library_Management_System.java`.
2. Open terminal/command prompt in the file's directory.
3. Compile:
   ```bash
   javac Task_3_Library_Management_System.java
   java Task_3_Library_Management_System
