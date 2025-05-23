# 🍔 Online Food Delivery Management System (Java Console App)

## 📌 Overview

The **Online Food Delivery Management System** is a console-based Java application that simulates the core functionalities of a food ordering and delivery platform. It allows customers to browse a menu, place orders, and manage deliveries, while a Manager oversees inventory and personnel.

This project demonstrates **core Java Object-Oriented Programming (OOP)** concepts including:
- Abstraction
- Inheritance
- Polymorphism
- Encapsulation

It also integrates advanced topics such as:
- Java Collections Framework
- Reflection API
- Custom Annotations
- Exception Handling

---

## 🚀 Features

- 👤 **User Management**  
  Supports registration of Customers, Delivery Personnel, and Manager (admin).

- 🍕 **Menu & Inventory**  
  Food items are managed using `Map<FoodItem, Integer>`. Each order reduces stock accordingly.

- 🛒 **Order Placement**  
  Validates inventory, assigns available delivery personnel, and updates stock dynamically.

- 🔐 **Role-Based Access Control**  
  Managers can add or restock items and remove delivery personnel using a custom `@RoleCheck` annotation with Reflection API.

- ❌ **Custom Exceptions**  
  Throws `InvalidOrderException` if stock is insufficient or no delivery personnel are available.

- 📋 **Delivery Management**  
  Assigns and manages delivery personnel with real-time availability status.

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- Maven (build automation)
- OOP Concepts (Abstract Class, Inheritance, Polymorphism)
- Java Collections (`List`, `Map`)
- Reflection & Custom Annotations
- Exception Handling

---

## 🧾 Class Structure

### 1. Abstract Class: `User`
- Fields: `id`, `name`
- Abstract Method: `showProfile()`

### 2. `Customer` (extends `User`)
- Displays customer info

### 3. `DeliveryPerson` (extends `User`)
- Tracks availability (`boolean available`)
- Methods: `isAvailable()`, `setAvailable()`, `showProfile()`

### 4. `FoodItem`
- Fields: `name`, `price`
- Overrides: `equals()`, `hashCode()`, `toString()`

### 5. `Order`
- Fields: `Customer`, `DeliveryPerson`, `Map<FoodItem, Integer>`, `status`
- Constructor:
  - Validates inventory
  - Reduces stock
  - Assigns delivery personnel
- Methods: `completeOrder()`, `orderDetails()`, `getStatus()`

### 6. `Manager` (extends `User`)
- Annotated with: `@RoleCheck(role = "Manager")`
- Methods:
  - `addNewItem(...)`
  - `restockItem(...)`
  - `removeDeliveryPerson(...)`

### 7. `DeliverySystem`
- Manages customers, delivery personnel, orders, and inventory
- Methods:
  - `registerCustomer()`
  - `registerDeliveryPerson()`
  - `addFoodItem()`
  - `displayMenu()`
  - `placeOrder()`
  - `showAllDeliveryPersons()`

### 8. `InvalidOrderException`
- Custom exception for order failures

### 9. `@RoleCheck`
- Custom Annotation with Reflection support for secure Manager operations

---

## 📦 Project Structure


---

## 🧑‍💻 How to Run

### ✅ Prerequisites
- Java 8 or above
- Maven installed

### ▶️ Steps

 Clone the repository and run

   ```bash
   git clone https://github.com/yourusername/online-food-delivery-java.git
   cd online-food-delivery-java
   mvn clean compile
  mvn exec:java -Dexec.mainClass="com.fooddelivery.Main"
 ```
Console Output: 
1. Register Customer
2. Register Delivery Person
3. Show Menu & Place Order
4. Add Food Item (Manager only)
5. Restock Food Item (Manager only)
6. Show All Delivery Personnel
7. Exit
