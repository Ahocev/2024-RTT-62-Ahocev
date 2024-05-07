package org.example.PA_303_7_1;

import java.util.Arrays;

public class Task9 {

    public static void main(String[] args) {

        // Write a program to sort the following int array in ascending order: {4, 2, 9, 13, 1, 0}.
        // Print the array in ascending order, and print the smallest and the largest element of the array.
        // The output will look like the following:
        // Array in ascending order: 0, 1, 2, 4, 9, 13
        // The smallest number is 0
        // The biggest number is 13

        int[] array = { 4, 2, 9, 13, 1, 0 } ;

        // bubble sort for ascending order
        for ( int outer = 0 ; outer < array.length -1 ; outer++ ) {
            // the boolean can help make it efficient by stopping once sorted
            boolean swapped = false;
            for (int pos = 0; pos < array.length - 1 ; pos++) {
                if (array[pos] > array[pos + 1]) {
                    int temp = array[pos];
                    array[pos] = array[pos + 1];
                    array[pos + 1] = temp;
                    swapped = true;
                }
            }

            if ( ! swapped ) {
                break;
            }
        }

        System.out.println("Array in ascending order: " + Arrays.toString(array));
        System.out.println("The smallest number is: " + array[0]);
        System.out.println("The largest number is: " + array[5]);
    }
}
