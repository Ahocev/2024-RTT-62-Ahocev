package org.example.PA_303_5_1;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {

        //Write a program that prompts the user to enter two positive integers, and
        Scanner scanner = new Scanner(System.in); // initialize scanner

        System.out.println("Enter two positive integers."); // prompt user to enter two positive integers

        System.out.println("Integer 1: "); // prompt for n1
        int n1 = scanner.nextInt(); // scans in n1

        System.out.println("Integer 2: "); // prompt for n2
        int n2 = scanner.nextInt(); // scans in n2

        int min = Math.min(n1, n2); // finds the minimum of n1 and n2
        int gcd = 1; // intial minimum possible guess for the GCD

        for ( int i = min; i >=1; i-- ) { // Start from the smaller number and count down
            if (n1 % i == 0 && n2 % i == 0 ) { // check if 1 is a divisor of n1 and n2
                gcd = i; // update gcd if a new common divisor is found
                break; // exit once highest divisor found
            }
        }

        System.out.println("The GCD of " + n1 + " and " + n2 + " is: " + gcd);
        //find their greatest common divisor (GCD).
        // for ( n1 =)
        //Examples:
        //Enter 2 and 4. The gcd is 2.
        //Enter 16 and 24.  The gcd is 8.
        //How do you find the gcd?
        //Name the two input integers n1 and n2.
        //You know number 1 is a common divisor, but it may not be the gcd.
        //Check whether k (for k = 2, 3, 4, and so on) is a common divisor for n1 and n2,
        //until k is greater than n1 or n2.
    }
}
