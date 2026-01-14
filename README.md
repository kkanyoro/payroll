# Payroll Management System

A JavaFX desktop application designed to manage employee payroll, calculate wages, and generate payslips.

## Description

This application allows users to input employee details and financial data to automatically calculate Gross Pay, Deductions, and Net Pay. It includes features for handling tax codes, National Insurance inputs, and generating a text-based payslip receipt.

## Features

* **Wage Calculation**: Automatically calculates Gross Pay, Taxable Pay, and Net Pay based on basic salary, overtime, and inner city weighting.
* **Deductions Management**: Computes total deductions including Tax, Pension, Student Loan, and National Insurance payments.
* **Payslip Generation**: Generates a detailed text receipt of the employee's current pay period.
* **Input Validation**: Prevents invalid data entry and ensures required fields are populated before calculation.
* **Read-Only Output**: Locks calculation result fields to prevent manual tampering.

## Technologies Used

* **Java**: JDK 21
* **JavaFX**: Version 21.0.6
* **Build Tool**: Maven
* **UI Design**: FXML (Scene Builder)

## Prerequisites

* Java Development Kit (JDK) 21 or higher.
* Maven 3.8.0 or higher.

## Installation and Run

1. **Clone the repository**
```bash
git clone <repository-url>
cd payroll

```


2. **Build the project**
```bash
mvn clean install

```


3. **Run the application**
```bash
mvn clean javafx:run

```



## Usage

1. Fill in the **Employee Details** (Name, Reference, Address, etc.).
2. Select the **Tax Period**, **Tax Code**, and **NI Code** from the dropdown menus.
3. Enter the financial figures (Basic Salary, Overtime, Tax, etc.).
4. Click **Net Wages** to perform calculations. The output fields (Gross Pay, Deductions, Net Pay) will populate automatically.
5. Click **Pay Slip** to generate a receipt in the scrollable view.
6. Click **Reset** to clear all fields for a new entry.