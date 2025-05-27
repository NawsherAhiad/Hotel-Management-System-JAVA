# 🏨 Hotel Management System (Java Console Application)

A console-based Hotel Management System built using Java, designed to handle room bookings, manage customer reservations, calculate payment amounts based on stay duration, and record company earnings.

---

## 📌 Features

- View all available hotel rooms with type, price, and availability.
- Book rooms with customer details and check-in/check-out dates.
- Calculate payment dynamically based on room type and length of stay.
- Validate payment and add to company account balance.
- Maintain records for customers, reservations, and payments.

---

## 🧱 Project Structure & Class Descriptions

| Class Name                | Description |
|---------------------------|-------------|
| `Room`                    | Represents each hotel room with details like room number, type, price, rating, and availability. |
| `Person` (abstract)       | Base class for `Customer`, holds name and contact information. |
| `Customer`                | Inherits from `Person`. Represents a guest making a reservation. |
| `Reservation`             | Represents a reservation, holding references to the `Customer`, `Room`, and check-in/check-out dates. |
| `CompanyAccount`          | Tracks total revenue generated from customer payments. |
| `HotelManagementSystem3`  | Main application class. Manages room booking, availability, payments, and user interface. |
| `HotelInterface`          | Interface defining core operations: displaying rooms, checking availability, booking, and payments. |

---

## 🧮 Payment System

- Automatically calculates the **total cost** using:
totalCost = pricePerNight * numberOfNights

- Accepts payment and validates the amount.
- On successful payment, updates the total balance in `CompanyAccount`.

---

## 🛠 Technologies Used

- **Java SE** (Standard Edition)
- **OOP Concepts**: Inheritance, Abstraction, Encapsulation, Interfaces
- **Console-based UI** using `Scanner`

---

## 🚀 Getting Started

1. Clone this repository:
 ```bash
 git clone https://github.com/yourusername/hotel-management-system-java.git
