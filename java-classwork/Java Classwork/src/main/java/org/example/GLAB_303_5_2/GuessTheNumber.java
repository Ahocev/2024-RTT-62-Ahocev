package org.example.GLAB_303_5_2;

import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Generate a random number to be guessed
        int number = (int) (Math.random() * 11);
        Scanner input = new Scanner(System.in);
        System.out.println("Guess a number between 0 and 10");
        int guess = -1;
        while ( guess != number ) {
            // prompt user to guess the number
            System.out.println("Enter your guess: ");
            guess = input.nextInt();
            if (guess == number)
                System.out.println("You got it! The number is: " + number);
            else if (guess > number)
                System.out.println("Your guess is too high!");
            else
                System.out.println("Your guess is too low!");
        }
    }
}
