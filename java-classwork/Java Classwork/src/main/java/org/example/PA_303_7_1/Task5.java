package org.example.PA_303_7_1;

public class Task5 {

    public static void main(String[] args) {

        // Write a program where you create an integer array with a length of 5.
        int[] iArray = {1, 2, 3, 4, 5};
        // Loop through the array and
        for ( int pos = 3 ; pos < 5 ; pos++ ) {
            iArray[pos] = pos;
            // assign the value of the loop control variable (e.g., i) to the corresponding index in the array.
        }
        for (int value : iArray) {
            System.out.println(value);
        }
    }
}
