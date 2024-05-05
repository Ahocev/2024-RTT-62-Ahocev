package org.example.PA_303_4_1;

import java.util.Scanner;

public class ControlFlow6 {

    public static void main(String[] args) {
        // Write a program that accepts an integer between 1 and 7 from the user.
        // Use a switch statement to print out the corresponding weekday.
        // Print “Out of range” if the number is less than 1 or greater than 7.
        // Do not forget to include “break” statements in each of your cases.
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number 1-7: ");
        int day = input.nextInt();

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Out of range");
                break;
        }
    }
}
