package org.example.PA_303_7_1;

public class Task8 {

    public static void main(String[] args) {

        // Write a program that creates a String array of 5 elements and
        String[] elements = { "String1", "String2", "String3", "String4", "String5" };
        // swaps the first element with the middle element without creating a new array.

        // Determine the index of the middle element
        int middleIndex = elements.length / 2;

        // Swap the first element (index 0) with the middle element
        String temp = elements[0]; // Use a temporary variable to hold the first element
        elements[0] = elements[middleIndex]; // Assign the value of the middle element to the first element
        elements[middleIndex] = temp; // Assign the value of the temporary variable (original first element) to the middle

        // uses enhanced for loop to loop through the collection (of elements) and assigns them to a variable, and
        // prints out the variable and its new assignment with each loop
        // for (Type variable : collection)
        for (String element : elements) {
            System.out.println(element);
        }
    }

}
