package org.example.PA_303_7_1;

public class Task4 {

    public static void main(String[] args) {

        // Task 4: Write a program that creates an integer array with 5 elements (i.e., numbers).
        int [] iArray = {1, 2, 3, 4, 5};
        // The numbers can be any integers.
        // Print out the value at the first index and the last index using length - 1 as the index.

        // iArray[5] = 3;

        System.out.println(iArray[0]);

        // Print the last element using length - 1
        System.out.println(iArray[iArray.length - 1]);

        // Now try printing the value at index = length (e.g., myArray[myArray.length] ).
        System.out.println(iArray[iArray.length]);
        // Notice the type of exception which is produced.
        // Now try to assign a value to the array index 5.
        // You should get the same type of exception.

    }
}
