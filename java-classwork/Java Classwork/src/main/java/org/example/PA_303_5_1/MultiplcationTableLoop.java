package org.example.PA_303_5_1;

public class MultiplcationTableLoop {
    public static void main(String[] args) {
        // Header for the table
        System.out.print("     ");
        for (int header = 1; header <= 12; header++) {
            System.out.printf("%4d", header);
        }
        System.out.println("\n------------------------------------------------------------");

        // Nested loops to generate the table
        for (int i = 1; i <= 12; i++) {  // This is the outer loop, for each row.
            System.out.printf("%4d |", i);  // Print the row label

            for (int j = 1; j <= 12; j++) {  // This is the inner loop, for each column in a row.
                System.out.printf("%4d", i * j);  // Print the product of i and j
            }
            System.out.println();  // Move to the next line after finishing each row
        }
    }
}
