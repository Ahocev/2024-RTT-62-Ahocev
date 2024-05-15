package org.example.PA_303_11_1;

import java.util.HashSet;
import java.util.Scanner;

public class UniquePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPairs = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline after the integer

        HashSet<String> uniquePairs = new HashSet<>();

        for (int i = 0; i < numberOfPairs; i++) {
            // Read the entire line and split it into two parts
            String pairLine = scanner.nextLine();
            String[] pair = pairLine.split(" ");
            String first = pair[0];
            String second = pair[1];

            // Create a unique representation of the pair
            String pairString = first + " " + second;
            uniquePairs.add(pairString);

            // Print the number of unique pairs
            System.out.println(uniquePairs.size());
        }
        scanner.close();
    }
}
