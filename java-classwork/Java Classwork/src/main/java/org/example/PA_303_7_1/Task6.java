package org.example.PA_303_7_1;

public class Task6 {

    public static void main(String[] args) {

        //  Write a program where you create an integer array of 5 numbers.
        //  Loop through the array and assign the value of the loop control variable multiplied by 2
        //  to the corresponding index in the array.
        //              0  1  2  3  4
        int[] iArray = {1, 2, 3, 4, 5};

        for ( int pos = 0 ; pos < 5 ; pos++ ) {
            iArray[pos] = pos*2;

        }
        for (int value : iArray) {
            System.out.println(value);
        }


    }

}
