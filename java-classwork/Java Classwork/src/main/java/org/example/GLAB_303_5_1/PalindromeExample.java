package org.example.GLAB_303_5_1;

import java.util.Scanner;

public class PalindromeExample {
    public static void main(String[] args) {
        String original, reverse = ""; //Objects of string class
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string to check it is a palindrome: ");
        original = in.nextLine();
        int length = original.length();
        for ( int i = length - 1; i >= 0; i-- )
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse)) {
            System.out.println("Entered string is a palindrome.");
        } else {
            System.out.println("Entered string is not a palindrome.");
        }
    }
}
