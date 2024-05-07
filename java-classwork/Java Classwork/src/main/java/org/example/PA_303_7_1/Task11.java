package org.example.PA_303_7_1;

import java.util.Scanner;

public class Task11 {

    public static void main(String[] args) {

        // Write some Java code that asks the user how many favorite things they have.
        // Based on their answer, you should create a String array of the correct size.
        // Then ask the user to enter the things and store them in the array you created.
        // Finally, print out the contents of the array.

        Scanner scanner = new Scanner(System.in);

        // Asking how many favorite things they have
        System.out.println("How many favorite things do you have?");
        int numFavorites = scanner.nextInt();
        scanner.nextLine(); // clearing out the newline character from the input buffer

        // Creating a String array to hold favorite things
        String[] favoriteThings = new String[numFavorites];

        // Prompting user to enter each of their favorite things
        System.out.println("Please enter your favorite things:");
        // looping the prompt for the number of favorite things entered
        for (int i = 0; i < numFavorites; i++) {
            System.out.print("Enter favorite thing " + (i + 1) + ": ");
            favoriteThings[i] = scanner.nextLine(); // do not need to clear the buffer because nextLine consumes
                                                    // newline char at end of input
                                                    // nextInt() leaves input in buffer if not cleared
        }

        // Print out the contents of the array
        System.out.println("\nYour favorite things are:");
        for (String item : favoriteThings) {
            System.out.println(item);
        }
    }
}