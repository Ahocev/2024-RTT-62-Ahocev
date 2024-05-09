package org.example.PA_303_7_1;

import java.util.Random;

public class EricTask {

        // 1) Create an int array of length 10
        //
        // 2) Initialize the array to random integers
        //
        // 3) I want you to get the smallest integer in the array
        //
        // 4) I want you to get the largest integer in the array
        //
        // 5) I want you to calculate the average value in the array as a double.  Average is the sum of all elements in the array divided by the length of the array
        //
        // You can only use a single for loop

    public static void main(String[] args) {
        int[] numbers = new int[10]; // Create an array of length 10
        Random random = new Random(); // Random object for generating numbers

        int min = Integer.MAX_VALUE; // Start with the highest possible value
        int max = Integer.MIN_VALUE; // Start with the lowest possible value
        double sum = 0; // To store the sum of all elements

        System.out.println("Array: ");
        // Fill the array with random integers, calculate min, max, sum, and print in one loop
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // Random integers between 0 and 99
            System.out.print(numbers[i] + " "); // Print the current number
            sum += numbers[i]; // Add to sum

            if (numbers[i] < min) {
                min = numbers[i]; // Update min if current number is smaller
            }
            if (numbers[i] > max) {
                max = numbers[i]; // Update max if current number is larger
            }
        }

        double average = sum / numbers.length; // Calculate average

        // Print results after the loop
        System.out.println("\nSmallest number: " + min);
        System.out.println("Largest number: " + max);
        System.out.println("Average value: " + average);
    }
}
