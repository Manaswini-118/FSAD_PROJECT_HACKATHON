package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tax_record")
public class TaxRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double salaryIncome;
    private double otherIncome;
    private double deductions;

    private double totalIncome;
    private double taxableIncome;
    private double oldRegimeTax;
    private double newRegimeTax;

    private String recommendedRegime;

    public Long getId() { return id; }

    public double getSalaryIncome() { return salaryIncome; }
    public void setSalaryIncome(double salaryIncome) { this.salaryIncome = salaryIncome; }

    public double getOtherIncome() { return otherIncome; }
    public void setOtherIncome(double otherIncome) { this.otherIncome = otherIncome; }

    public double getDeductions() { return deductions; }
    public void setDeductions(double deductions) { this.deductions = deductions; }

    public double getTotalIncome() { return totalIncome; }
    public void setTotalIncome(double totalIncome) { this.totalIncome = totalIncome; }

    public double getTaxableIncome() { return taxableIncome; }
    public void setTaxableIncome(double taxableIncome) { this.taxableIncome = taxableIncome; }

    public double getOldRegimeTax() { return oldRegimeTax; }
    public void setOldRegimeTax(double oldRegimeTax) { this.oldRegimeTax = oldRegimeTax; }

    public double getNewRegimeTax() { return newRegimeTax; }
    public void setNewRegimeTax(double newRegimeTax) { this.newRegimeTax = newRegimeTax; }

    public String getRecommendedRegime() { return recommendedRegime; }
    public void setRecommendedRegime(String recommendedRegime) { this.recommendedRegime = recommendedRegime; }
}