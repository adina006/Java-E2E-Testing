# ✈️ Selenium Test Automation Framework (Java + TestNG)

## 📌 Introduction

This is a simple and scalable test automation project built using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**.  
The project follows the **Page Object Model (POM)** design pattern and includes modular components to support reusability, maintainability, and scalability.

---

## 🧱 Test Architecture

### 📂 `src/main/java`

#### ✅ `testbase`
Contains base setup and teardown methods that run before and after every test. This ensures consistent test execution and environment setup.

#### ✅ `constants`
Global values are centralized here (e.g., URLs, timeouts, and property files), making the configuration easy to maintain.

#### ✅ `factories`
Implements the Page Factory model to initialize page elements efficiently and enable faster, cleaner method calls.

#### ✅ `pages`
Each webpage has a dedicated class that encapsulates its web elements and actions, following the POM approach to improve test clarity and maintainability.

#### ✅ `utils`
Utility classes with reusable helper methods to avoid code repetition. Includes:
- `JDBCUtil` – for database connections and queries
- `ExcelUtil` – for reading and writing Excel data
- `SeleniumUtil` – for common Selenium actions
- `Log4JUtil` – for logging setup and usage

---

### 📂 `src/test/java`

#### ✅ `TestNG.xml`
Used to configure test suites and enable **parallel test execution**.

#### ✅ `FlightsTest`
Automates the flight booking workflow.

#### ✅ `LoginTest`
Includes negative login scenarios using data-driven testing with Excel sheets.

#### ✅ `LinkTest`
Tests all links in the footer section by opening them and capturing their page titles.

#### ✅ Other Tests
- `ExcelTest` – demonstrates Excel data read/write capabilities
- `Log4jTest` – demonstrates logging functionality with Log4j
- `JDBCTest` – shows database interaction using JDBC

---

## 🛠️ Tech Stack

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model**
- **Page Factory**
- **Excel (Apache POI)**
- **JDBC**
- **Log4j**

![main](https://user-images.githubusercontent.com/89051877/129811488-a23266e0-ec4d-4516-969a-bedee2efec47.PNG)

![test](https://user-images.githubusercontent.com/89051877/129811501-2ac51719-dd9c-4520-8116-3cd3e9b0767e.PNG)

![testngxml](https://user-images.githubusercontent.com/89051877/129812428-2953d9f9-8800-4eca-bbee-6f8bd04bff0d.PNG)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-repo-name.git
cd your-repo-name

### 2. Install Dependencies
### Make sure Maven is installed, then:

bash
Copy
Edit
mvn clean install

### 3. Run Tests
### Run all tests using TestNG XML:

bash
Copy
Edit
mvn test -DsuiteXmlFile=testng.xml









