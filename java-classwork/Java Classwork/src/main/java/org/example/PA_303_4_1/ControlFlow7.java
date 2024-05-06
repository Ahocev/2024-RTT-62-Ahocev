package org.example.PA_303_4_1;

import java.util.Scanner;

public class ControlFlow7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Filing Status
        System.out.println("Enter your filing status:");
        System.out.println("1 - Single");
        System.out.println("2 - Married Filing Jointly");
        System.out.println("3 - Married Filing Separately");
        System.out.println("4 - Head of Household");
        int status = scanner.nextInt();

        // Income
        System.out.println("Enter your taxable income:");
        double income = scanner.nextDouble();

        double tax = 0.0;
        double[] brackets = new double[0];
        double[] rates = new double[0];

        // Define tax brackets and rates based on filing status
        switch (status) {
            case 1: // Single
                brackets = new double[]{8350, 33950, 82250, 171550, 372950};
                rates = new double[]{0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
                break;
            case 2: // Married Filing Jointly
                brackets = new double[]{16700, 67900, 137050, 208850, 372950};
                rates = new double[]{0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
                break;
            case 3: // Married Filing Separately
                brackets = new double[]{8350, 33950, 68525, 104425, 186475};
                rates = new double[]{0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
                break;
            case 4: // Head of Household
                brackets = new double[]{11950, 45500, 117450, 190200, 372950};
                rates = new double[]{0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
                break;
            default:
                System.out.println("Invalid filing status.");
                scanner.close();
                return; // Exit the program
        }

        double previousBracket = 0.0;
        for (int i = 0; i < brackets.length; i++) {
            if (income > brackets[i]) {
                tax += (brackets[i] - previousBracket) * rates[i];
                previousBracket = brackets[i];
            } else {
                tax += (income - previousBracket) * rates[i];
                break;
            }
        }

        if (income > brackets[brackets.length - 1]) {
            tax += (income - brackets[brackets.length - 1]) * rates[rates.length - 1];
        }

        System.out.printf("Tax to be paid: $%.2f%n", tax);
        scanner.close();
    }
}
