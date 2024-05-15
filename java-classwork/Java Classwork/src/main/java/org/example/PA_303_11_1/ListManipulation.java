package org.example.PA_303_11_1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of initial elements in the list
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);

        // Read the initial elements into the list
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        // Read the number of queries
        int q = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline

        // Process each query
        for (int i = 0; i < q; i++) {
            String queryType = scanner.nextLine(); // Read the type of the query

            if (queryType.equals("Insert")) {
                int index = scanner.nextInt(); // Read the index for the insert
                int value = scanner.nextInt(); // Read the value to be inserted
                if (index <= list.size()) { // Check if the index is within the current list size
                    list.add(index, value);
                }
                if (scanner.hasNextLine()) scanner.nextLine(); // Clean up the input stream
            } else if (queryType.equals("Delete")) {
                int index = scanner.nextInt(); // Read the index for the delete
                if (index < list.size()) { // Check if the index is within the current list size
                    list.remove(index);
                }
                if (scanner.hasNextLine()) scanner.nextLine(); // Clean up the input stream
            }
        }

        // Output the modified list
        for (Integer num : list) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
