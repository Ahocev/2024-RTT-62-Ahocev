package org.example.PA_303_2_3;

public class OperatorDemo7 {
    public static void main(String[] args) {
        // Write a program that declares two integer variables: x, and y, and then
        // assigns 5 to x and 8 to y.
        int x = 5;
        int y = 8;
        int sum = x++ + y;
        System.out.println(sum);
        // Create another variable sum and assign the value of ++x added to y, and
        // print the result.
        // Notice the value of the sum (should be 14).
        // Now change the increment operator to postfix (x++) and re-run the program.
        // Notice what the value of the sum is.
        // The first configuration incremented x, and then
        // calculated the sum,
        // while the second configuration calculated the sum, and then
        // incremented x.
    }
}
