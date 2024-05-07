package org.example.PA_303_7_1;

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {

        // Write a program that creates an array of String type and
        String[] colors = { "red", "green", "blue", "yellow" };
        // initializes it with the strings “red,” “green,” “blue,” and “yellow.”
        // Print out the array length.
        System.out.println(colors.length);

        String[] clone = colors.clone();
        // Make a copy using the clone( ) method.
        // Use the Arrays.toString( ) method on the new array to verify that the original array was copied.
        System.out.println(Arrays.toString(clone));

    }

}
