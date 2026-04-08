package com.example.dto;

public class TaxResponse {

    private double totalIncome;
    private double taxableIncome;
    private double oldRegimeTax;
    private double newRegimeTax;
    private String recommendedRegime;

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