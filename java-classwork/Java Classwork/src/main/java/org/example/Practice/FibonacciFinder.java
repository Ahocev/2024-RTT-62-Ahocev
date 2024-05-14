package org.example.Practice;

import java.math.BigInteger;

public class FibonacciFinder {

    public static void main(String[] args) {
        // Use BigInteger for handling very large numbers
        BigInteger a = BigInteger.ZERO;  // First Fibonacci number
        BigInteger b = BigInteger.ONE;  // Second Fibonacci number
        BigInteger c = BigInteger.ZERO; // For storing the sum temporarily

        int index = 0; // To count up to the 1000th number
        while (index < 1000) {
            c = a.add(b);  // Sum of the two previous numbers
            a = b;         // Move to the next number
            b = c;         // New sum becomes the next number to add
            index++;
        }

        // Print the 1000th Fibonacci number
        System.out.println("The 1000th Fibonacci number is: " + a);
    }
}
