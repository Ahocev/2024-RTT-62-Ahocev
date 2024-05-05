package org.example.GLAB_303_5_2;

import java.util.Scanner;

public class SentinelValueDemo {
    public static void main(String[] args) {
        // Create a scanner
        Scanner input = new Scanner(System.in);
        // Read an initial data
        System.out.println("Enter an int value (program exits if input is 0): ");
        int data = input.nextInt();
        // Keep reading data until input is 0
        int sum = 0;
        while (data != 0) {
            sum += data;
            // Read the next data
            System.out.print("Enter an int value (program exits if input is 0): ");
            data = input.nextInt();
        }
        System.out.println("The sum is: " + sum);
    }
}
