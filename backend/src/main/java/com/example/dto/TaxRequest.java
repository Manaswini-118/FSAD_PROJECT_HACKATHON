package com.example.dto;

public class TaxRequest {

    private double salaryIncome;
    private double otherIncome;
    private double deductions;

    public double getSalaryIncome() { return salaryIncome; }
    public void setSalaryIncome(double salaryIncome) { this.salaryIncome = salaryIncome; }

    public double getOtherIncome() { return otherIncome; }
    public void setOtherIncome(double otherIncome) { this.otherIncome = otherIncome; }

    public double getDeductions() { return deductions; }
    public void setDeductions(double deductions) { this.deductions = deductions; }
}