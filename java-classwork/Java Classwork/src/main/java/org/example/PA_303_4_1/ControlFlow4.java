package org.example.PA_303_4_1;

public class ControlFlow4 {

    public static void main(String[] args) {
        // Write a program that declares 1 integer variable x, and then assigns 15 to it.
        int x = 5;
        // Write an if-else statement that prints “Out of range” if the number is less than 10 or greater than 20 and
        if ( x < 10 | x > 20 ){
            System.out.println("Out of range");
        } else if ( x >= 10 & x <= 20 & x < 21) {
            System.out.println("In range");
        }
        // prints “In range” if the number is between 10 and 20 (including equal to 10 or 20).
        // Change x to 5 and notice the result.
    }
}
