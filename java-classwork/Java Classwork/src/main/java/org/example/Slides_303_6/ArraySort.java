package org.example.Slides_303_6;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {


        // simplest most inefficient sort method (maximum value "bubbles up to the top")
        int[] array = { 1, 2, 3, 5, 1, 10, 20 } ;


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

            System.out.println(Arrays.toString(array));

            if ( ! swapped ) {
                break;
            }
        }
    }
}
