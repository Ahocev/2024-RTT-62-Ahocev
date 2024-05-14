package org.example.SBA1Practice;

public class Result_WhileLoop {

    public static int getDigitsSum(int largeNumber) {
        int sum = 0; // create a container variable that starts with no value (0)
        while (largeNumber > 0) { // while largeNumber is above zero
            sum += largeNumber % 10; // Extract the last digit and add it to the sum container
            largeNumber /= 10; // Remove the last digit of the largeNumber
        }                       // keep looping until largeNumber reaches 0
        return sum; // container variable prints once loop has finished
    }

}
