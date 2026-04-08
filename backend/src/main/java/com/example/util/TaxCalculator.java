package com.example.util;

public class TaxCalculator {

    public static double calculateOldRegime(double income) {
        double tax = 0;

        if (income <= 250000) return 0;

        if (income <= 500000) {
            tax += (income - 250000) * 0.05;
            return tax;
        }

        tax += 250000 * 0.05;

        if (income <= 1000000) {
            tax += (income - 500000) * 0.20;
            return tax;
        }

        tax += 500000 * 0.20;
        tax += (income - 1000000) * 0.30;

        return tax;
    }

    public static double calculateNewRegime(double income) {
        double tax = 0;

        if (income <= 300000) return 0;

        if (income <= 600000) {
            tax += (income - 300000) * 0.05;
            return tax;
        }

        tax += 300000 * 0.05;

        if (income <= 900000) {
            tax += (income - 600000) * 0.10;
            return tax;
        }

        tax += 300000 * 0.10;

        if (income <= 1200000) {
            tax += (income - 900000) * 0.15;
            return tax;
        }

        tax += 300000 * 0.15;

        if (income <= 1500000) {
            tax += (income - 1200000) * 0.20;
            return tax;
        }

        tax += 300000 * 0.20;
        tax += (income - 1500000) * 0.30;

        return tax;
    }

    public static String getBetterRegime(double oldTax, double newTax) {
        return oldTax < newTax ? "OLD REGIME" : "NEW REGIME";
    }
}