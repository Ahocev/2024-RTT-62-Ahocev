package org.example.PA_303_4_1;

import java.util.Scanner;

public class ControlFlow7 {
    public static void main(String[] args) {
        // Create a program that lets the users input their filing status and income.
        // Display how much tax the user would have to pay according to status and income.
        // The U.S. federal personal income tax is calculated based on the filing status and taxable income.
        // There are four filing statuses:
        // Single, Married Filing Jointly, Married Filing Separately, and Head of Household.
        // The tax rates for 2009 are shown below.
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter filing status and income: ");
        int status = input.nextInt();
    }
}
