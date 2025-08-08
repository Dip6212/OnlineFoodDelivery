# OnlineFoodDelivery 🍔

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Description 📝

This project provides a basic structure for an online food delivery system. It includes entity classes for defining the data model and service classes for implementing the business logic. The project is built using Java and Maven. It also includes basic JUnit tests to check implemented functionalities.

## Table of Contents 📌

- [Description](#description)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)
- [Footer](#footer)

## Features ✨

- Basic entity classes for `Customer`, `DeliveryPerson`, and `FoodItem`.
- Service layer with classes like `DeliverySystem`, `Manager`, and `Order`.
- Exception handling with `InvalidOrderException`.
- JUnit tests for entities and services.
- Uses Maven for dependency management (commons-io).

## Tech Stack 💻

- Java
- Maven
- JUnit

## Installation 🛠️

1.  Ensure you have Java and Maven installed.
2.  Clone the repository:
    ```bash
    git clone https://github.com/Dip6212/OnlineFoodDelivery.git
    ```
3.  Navigate to the project directory:
    ```bash
    cd OnlineFoodDelivery
    ```
4.  Build the project using Maven:
    ```bash
    mvn clean install
    ```

## Usage 🚀

1.  **Implement Business Logic**: Extend the provided entity and service classes to implement the core functionality of the online food delivery system.
2.  **Define Data Models**: Add attributes and methods to the entity classes (`Customer`, `FoodItem`, `Order`) to define the structure of the data.
3.  **Implement Service Methods**: Implement the methods in the service layer (`DeliverySystem`, `Manager`) to handle order placement, delivery management, etc.
4.  **Write JUnit Tests**: Write JUnit tests to ensure the correctness of the implemented functionality. The existing tests serve as placeholders.

Example:

```java
package com.cg.onlinefooddeliverysystem.service;

public class Order {

}
```

Real world use case of this project is to simulate the different functionaries like customer,delivery person and the manager for an Online Food Delivery application. The project provides different functionalities for an end to end application to deploy.

## Project Structure 📂

```
OnlineFoodDelivery/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── cg/
│   │               └── onlinefooddeliverysystem/
│   │                   ├── entity/
│   │                   │   ├── Customer.java
│   │                   │   ├── DeliveryPerson.java
│   │                   │   ├── FoodItem.java
│   │                   │   └── User.java
│   │                   └── service/
│   │                       ├── DeliverySystem.java
│   │                       ├── InvalidOrderException.java
│   │                       ├── Manager.java
│   │                       ├── Order.java
│   │                       └── RoleCheck.java
│   │       └── com/
│   │           └── cg/
│   │               └── onlinefooddelivery/
│   │                       └── ui/
│   │                           └── Main.java
│   └── test/
│       └── java/
│           └── com/
│               └── cg/
│                   └── onlinefooddeliverysystem/
│                       ├── entity/
│                       │   ├── CustomerTest.java
│                       │   ├── DeliveryPersonTest.java
│                       │   └── FoodItemTest.java
│                       └── service/
│                           ├── DeliverySystemTest.java
│                           ├── ManagerTest.java
│                           └── OrderTest.java
└──
```

## Contributing 🤝

Contributions are always welcome! Please follow these steps:

1.  Fork the repository.
2.  Create a new branch.
3.  Make your changes.
4.  Submit a pull request.

## License 📜

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Footer 👣

- Repository: [OnlineFoodDelivery](https://github.com/Dip6212/OnlineFoodDelivery)
- Author: [Dip6212](https://github.com/Dip6212)

⭐️ Star the repository if you like it!

🍴 Fork the repository to contribute!

🐛 Report issues to help improve the project!
