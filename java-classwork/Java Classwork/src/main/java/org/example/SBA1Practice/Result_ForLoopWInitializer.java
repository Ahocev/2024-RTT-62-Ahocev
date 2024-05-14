package org.example.SBA1Practice;

public class Result_ForLoopWInitializer {
    public static int getDigitsSum(int largeNumber) {
        int sum = 0; // create a container int variable with no contents
        // Initialize loop variable from the method parameter
        for (int num = largeNumber; num > 0; num /= 10) { // create a loop variable num which is equal to largeNumber
            // while largeNumber is greater than 0, keep looping, and divide by 10 with every loop to remove the last digit of largeNumber
            sum += num % 10; // with every loop, mod largeNumber(num) by 10 to extract the last digit and add it to the container variable sum
        } // when largeNumber reaches 0, loop stops
        return sum; // sum of large number is printed
    }
}
