# 📚 Pahana Education – Billing Management System

A simple **web-based billing and customer management system** for *Pahana Education Bookshop*. This project was built using **Java (Servlets + JSP), JDBC, and MySQL**, styled with CSS for a clean UI.

It helps manage customers, items (books/stationery), and billing records efficiently.

---

## 🚀 Features

* **User Authentication**

  * Secure login/logout system.

* **Customer Management**

  * Add new customers.
  * Edit existing customer details.
  * Delete customers with confirmation.

* **Item Management**

  * Add, update, and delete bookshop items.
  * View all existing items in a styled table.

* **Billing System**

  * Generate bills based on customer and items.
  * Quantity and price calculation.
  * Bill inquiry page with detailed breakdown.
  * Bill history maintained.

* **Help Section**

  * Guidance for system usage.

---

## 🛠️ Tech Stack

* **Backend:** Java (Servlets, JSP)
* **Frontend:** JSP, HTML, CSS
* **Database:** MySQL
* **Server:** Apache Tomcat 9
* **Build Tool:** Manual deployment / IDE-based (IntelliJ IDEA / Eclipse)

---

## ⚙️ Setup & Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/yourusername/pahana-education.git
   ```

2. **Database setup**

   * Create a new MySQL database (e.g., `pahana_db`).
   * Import the provided SQL file (if included).
   * Update database credentials in your DAO classes.

3. **Deploy on Tomcat**

   * Copy project to Tomcat `webapps` folder OR
   * Run directly from IDE with Tomcat configured.

4. **Access the application**

   * Open browser → `http://localhost:8080/Pahana-Education`

---

## 📂 Project Structure

```
Pahana-Education/
│── src/
│   ├── dao/          # Database access (CustomerDAO, ItemDAO, etc.)
│   ├── model/        # POJO classes (Customer, Item)
│   ├── servlet/      # Servlets (AddCustomer, EditCustomer, Item, Bill, etc.)
│   └── util/         # Utility classes (BillCalculator)
│
│── WebContent/
│   ├── CSS/          # Stylesheets
│   ├── *.jsp         # JSP pages (dashboard, addCustomer, editCustomer, etc.)
│   └── WEB-INF/      # Config files (web.xml)
│
└── README.md
```

---

## ✅ Test Plan

Testing was conducted using a **Test-Driven Development (TDD)** approach.
Each page has defined test cases (see full `Test Plan` document).

---


## 👨‍💻 Author

Developed by **\[Chenula Jayathilaka]**
📧 Contact: [chenula.j2004@gmail.com](mailto:your.email@example.com)

---
