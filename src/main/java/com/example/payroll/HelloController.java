package com.example.payroll;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML private TextField tfEmployerName;
    @FXML private TextField tfEmpRef;
    @FXML private TextField tfEmpName;
    @FXML private TextField tfEmpAddress;
    @FXML private TextField tfPostCode;
    @FXML private TextField tfICW;             // Inner City Weighting
    @FXML private TextField tfBasicSalary;
    @FXML private TextField tfOvertime;
    @FXML private TextField tfGrossPay;
    @FXML private TextField tfPensionablePay;
    @FXML private TextField tfNetPay;

    // RIGHT SECTION (Pay + Deductions)
    @FXML private TextField tfPayDate;
    @FXML private ComboBox<String> cbTaxPeriod;
    @FXML private ComboBox<String> cbTaxCode;
    @FXML private ComboBox<String> cbNICode;
    @FXML private TextField tfNINumber;
    @FXML private TextField tfTax;
    @FXML private TextField tfPension;
    @FXML private TextField tfStudentLoan;
    @FXML private TextField tfNIPayment;
    @FXML private TextField tfTaxablePay;
    @FXML private TextField tfDeductions;

    // PAYSLIP AREA + BUTTONS
    @FXML private TextArea taPayslip;
    @FXML private Button btnNetWages;
    @FXML private Button btnPaySlip;
    @FXML private Button btnReset;
    @FXML private Button btnExit;

    @FXML
    private void initialize() {
        cbTaxPeriod.getItems().addAll(
                "1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12"
        );
        cbTaxPeriod.setPromptText("Select Period");

        cbTaxCode.getItems().addAll(
                "1257L", "BR", "D0", "D1", "NT"
        );
        cbTaxCode.setPromptText("Select Tax Code");

        cbNICode.getItems().addAll(
                "A", "B", "C", "H", "J", "M", "Z"
        );
        cbNICode.setPromptText("Select NI Code");

        // Make Calculation Fields Read-Only ---
        tfGrossPay.setEditable(false);
        tfNetPay.setEditable(false);
        tfDeductions.setEditable(false);
        tfTaxablePay.setEditable(false);
        tfPensionablePay.setEditable(false);

        // Make the Payslip area read-only
        taPayslip.setEditable(false);
    }

    @FXML
    private void handleNetWages() {
        // This method calculates Gross Pay, Deductions, and Net Pay based on input fields.

        double basicSalary   = parseDoubleSafe(tfBasicSalary.getText());
        double overtime      = parseDoubleSafe(tfOvertime.getText());
        double icw           = parseDoubleSafe(tfICW.getText());// Inner City Weighting
        double tax           = parseDoubleSafe(tfTax.getText());
        double pension       = parseDoubleSafe(tfPension.getText());
        double studentLoan   = parseDoubleSafe(tfStudentLoan.getText());
        double niPayment     = parseDoubleSafe(tfNIPayment.getText());

        // Gross = basic + overtime + inner city weighting
        double grossPay = basicSalary + overtime + icw;

        // Deductions = tax + pension + student loan + national insurance
        double totalDeductions = tax + pension + studentLoan + niPayment;

        // Net Pay = Gross Pay - Total Deductions
        double netPay = grossPay - totalDeductions;

        tfGrossPay.setText(String.format("%.2f", grossPay));
        tfDeductions.setText(String.format("%.2f", totalDeductions));
        tfNetPay.setText(String.format("%.2f", netPay));
        tfTaxablePay.setText(String.format("%.2f", grossPay)); // optional placeholder
        tfPensionablePay.setText(String.format("%.2f", grossPay)); // optional placeholder
    }

    @FXML
    private void handlePaySlip() {
        // Clear previous text
        taPayslip.clear();

        // Header
        taPayslip.appendText("========================================\n");
        taPayslip.appendText("           PAY SLIP RECEIPT             \n");
        taPayslip.appendText("========================================\n\n");

        // Employee Details
        taPayslip.appendText("Name:          " + tfEmpName.getText() + "\n");
        taPayslip.appendText("Address:       " + tfEmpAddress.getText() + "\n");
        taPayslip.appendText("Reference:     " + tfEmpRef.getText() + "\n");
        taPayslip.appendText("NI Number:     " + tfNINumber.getText() + "\n");
        taPayslip.appendText("Pay Date:      " + tfPayDate.getText() + "\n");

        // Handle ComboBoxes safely (check if null)
        String taxCode = cbTaxCode.getValue() != null ? cbTaxCode.getValue() : "";
        String taxPeriod = cbTaxPeriod.getValue() != null ? cbTaxPeriod.getValue() : "";
        taPayslip.appendText("Tax Code:      " + taxCode + "\n");
        taPayslip.appendText("Tax Period:    " + taxPeriod + "\n");

        taPayslip.appendText("----------------------------------------\n");

        // Financials
        taPayslip.appendText("Basic Salary:  £" + tfBasicSalary.getText() + "\n");
        taPayslip.appendText("Overtime:      £" + tfOvertime.getText() + "\n");
        taPayslip.appendText("Gross Pay:     £" + tfGrossPay.getText() + "\n");

        taPayslip.appendText("\n--- DEDUCTIONS -------------------------\n");
        taPayslip.appendText("Tax:           £" + tfTax.getText() + "\n");
        taPayslip.appendText("Pension:       £" + tfPension.getText() + "\n");
        taPayslip.appendText("Student Loan:  £" + tfStudentLoan.getText() + "\n");
        taPayslip.appendText("NI Payment:    £" + tfNIPayment.getText() + "\n");
        taPayslip.appendText("Total Ded.:    £" + tfDeductions.getText() + "\n");

        taPayslip.appendText("\nNET PAY:       £" + tfNetPay.getText() + "\n");
    }

    @FXML
    private void handleReset() {
        // Clear TextFields
        tfEmployerName.setText("");
        tfEmpRef.setText("");
        tfEmpName.setText("");
        tfEmpAddress.setText("");
        tfPostCode.setText("");
        tfICW.setText("");
        tfBasicSalary.setText("");
        tfOvertime.setText("");
        tfGrossPay.setText("");
        tfPensionablePay.setText("");
        tfNetPay.setText("");
        tfPayDate.setText("");
        tfNINumber.setText("");
        tfTax.setText("");
        tfPension.setText("");
        tfStudentLoan.setText("");
        tfNIPayment.setText("");
        tfTaxablePay.setText("");
        tfDeductions.setText("");

        // Clear ComboBox selections
        cbTaxPeriod.setValue(null);
        cbTaxCode.setValue(null);
        cbNICode.setValue(null);

        // Clear Payslip Area
        taPayslip.setText("");
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    private double parseDoubleSafe(String text) {
        try {
            return Double.parseDouble(text.trim());
        } catch (Exception e) {
            return 0.0;
        }
    }
}