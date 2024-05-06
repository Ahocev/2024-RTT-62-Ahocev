package org.example.PA_303_5_1;

public class MultTableLoopUnformatted {

    public static void main(String[] args) {
        System.out.print("    "); // formats the header to be in line with rest of table

        // Header Loop
        for (int h = 1; h <= 12; h++) { // initiates header row, starting at 1, postfix incrementing until 12
            System.out.printf("%4d", h); // prints the header ints with 4 spaces for alignment
        }
        System.out.println(); // creates a line break to allow the outer column to start on the second row

        // Outer Column Loop
        for (int o = 1; o <=12; o++){ // initiates outer column, starting at one, stopping at 12
                System.out.printf("%4d", o); // prints o, then moves to nested loop

            // Inner Multiplication Loop
            for (int m = 1; m <= 12; m++) { // initiates multiplication loop, multiplies by o 12 then goes back to outer nest
                System.out.printf("%4d", o * m); // prints column o * multi m
            }
            System.out.println(); // line break at the end of the multiplication loop, then column loop starts over
        }
    }
}
