package org.example.PA_303_7_1;

import java.util.Arrays;

public class Task10 {

    public static void main(String[] args) {

        // Create an array that includes an integer, 3 strings, and 1 double.
        // Print the array.
        Object[] objectArray = new Object[5];
        objectArray[0] = new String("String 1");
        objectArray[1] = new String("String 2");
        objectArray[2] = new String("String 3");
        objectArray[3] = new Integer( 10);
        objectArray[4] = new Double( 12.32);


        // Used Arrays.toString() to properly print the contents of the array.
        // This utility method returns a string representation of the array contents formatted as a list.
        System.out.println(Arrays.toString(objectArray));


    }

}
