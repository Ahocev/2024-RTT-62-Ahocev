package org.example.Slides_303_12;

import java.util.Scanner;

public class ExceptionsExamples {

    private Scanner scanner = new Scanner(System.in);

    public int captureInput() {

        while ( true ) {
            System.out.println("Enter an array position: ");
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("You must enter a valid integer.");
            }
        }
    }

    public void run() {

        int[] array = new int[10];

        try {
            System.out.println("Before error");

        int pos = captureInput();

            // when the exception occurs on this line it will automatically jump to the catch block
            array[2] = 5;

            // any code after the exception will not get run
            System.out.println("After Error");
        } catch ( Exception e ) {
            System.out.println("Caught the exception e with message : " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void main (String[] args){
        ExceptionsExamples ee = new ExceptionsExamples();
        ee.run();
    }

}
