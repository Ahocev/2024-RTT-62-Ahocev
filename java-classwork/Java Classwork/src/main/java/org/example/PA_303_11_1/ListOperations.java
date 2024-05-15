package org.example.PA_303_11_1;
import java.util.ArrayList;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the initial number of elements in the list
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);

        // Read the initial elements into the list
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        // Read the number of queries
        int q = scanner.nextInt();

        // Process each query
        for (int i = 0; i < q; i++) {
            String queryType = scanner.next(); // Read the type of the query

            if (queryType.equals("Insert")) {
                int index = scanner.nextInt(); // Read the index for the insert
                int value = scanner.nextInt(); // Read the value to be inserted
                list.add(index, value); // Insert the value at the specified index
            } else if (queryType.equals("Delete")) {
                int index = scanner.nextInt(); // Read the index for the delete
                list.remove(index); // Remove the element at the specified index
            }
        }

        // Output the modified list
        for (int num : list) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
