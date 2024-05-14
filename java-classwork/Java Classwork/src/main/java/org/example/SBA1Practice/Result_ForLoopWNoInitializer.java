package org.example.SBA1Practice;

public class Result_ForLoopWNoInitializer {

    public static int getDigitsSum(int largeNumber) {
        int sum = 0;
        for (; largeNumber > 0; largeNumber /= 10) {
            sum += largeNumber % 10; // Add the last digit to sum
        }
        return sum;
    }

}
