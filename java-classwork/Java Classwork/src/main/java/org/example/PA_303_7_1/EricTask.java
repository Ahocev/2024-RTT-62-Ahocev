package org.example.PA_303_7_1;

import java.util.Random;

public class EricTask {

    public static void main(String[] args) {

        // 1) Create an int array of length 10
        //
        //2) Initialize the array to random integers
        //
        //3) I want you to get the smallest integer in the array
        //
        //4) I want you to get the largest integer in the array
        //
        //5) I want you to calculate the average value in the array as a double.  Average is the sum of all elements in the array divided by the length of the array
        //
        //You can only use a single for loop

        int arraySize = 10;
        int[] myArray = new int[arraySize]; // Create an array of integers with a length of 10

        // Create a Random object
        Random random = new Random();

        // Initialize the array with random integers
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = random.nextInt(10); // Each element is assigned a random integer from 0 to 99
        }

    }

}
