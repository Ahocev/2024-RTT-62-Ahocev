package org.example.PA_303_4_1;

import java.util.Scanner;

public class ControlFlow1 {
    public static void main(String[] args) {
        //Write a program that declares 1 integer variable x, and then
        // assigns 7 to it.
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number between 0 and 20: ");
        int x = input.nextInt();
        // Write an if statement to print out “Less than 10” if x is less than 10.
        if (x < 10) {
            System.out.println("x is less than 10");
        }
        if (x >10) {
            System.out.println("x is greater than 10");
        }
    }
    // Change x to equal 15, and notice the result (console should not display anything).

}
