package org.example.PA_303_4_1;

import java.util.Scanner;

public class ControlFlow5 {

    public static void main(String[] args) {
        // Write a program that uses if-else-if statements to print out grades A, B, C, D, F,
        Scanner input = new Scanner(System.in);
        System.out.println("Enter score to determine grade: ");
        int grade = input.nextInt();

        if ( grade >= 90 & grade <=100 ) {
            System.out.println("A");
        } else if ( grade >= 80 & grade <= 89 ) {
            System.out.println("B");
        } else if ( grade >= 70 & grade <= 79 ) {
            System.out.println("C");
        } else if ( grade >= 60 & grade <= 69 ) {
            System.out.println("D");
        } else if ( grade < 60 ) {
            System.out.println("F");
        }
        // according to the following criteria:
        //A: 90-100
        //B: 80-89
        //C: 70-79
        //D: 60-69
        //F: <60
        //Use the Scanner class to accept a number score from the user to determine the letter grade.
        // Print out “Score out of range” if the score is less than 0 or greater than 100.
    }
}
