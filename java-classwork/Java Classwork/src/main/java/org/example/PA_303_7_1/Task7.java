package org.example.PA_303_7_1;

public class Task7 {

    public static void main(String[] args) {

        // Write a program where you create an array of 5 elements.
        int[] iArray = {1, 2, 3, 4, 5};

        int mid = iArray.length / 2;
        // Loop through the array and print the value of each element,
        for (int pos = 0; pos < iArray.length; pos++) {
            if (pos != mid) { // Check if the current index is not the middle index
                System.out.println(iArray[pos]);
                // except for the middle (index 2) element.
            }
        }

    }
}
