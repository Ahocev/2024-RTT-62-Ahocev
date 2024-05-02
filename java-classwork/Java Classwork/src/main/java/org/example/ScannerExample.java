package org.example;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        Scanner sc1 = new Scanner (System.in);
        //System.in is a stream and best practice is to close streams for memory allocation
        System.out.println("Enter a number: ");
        int num1 = sc1.nextInt();

        System.out.println("This is the number: " + num1);

        sc1.close();
    }

}
