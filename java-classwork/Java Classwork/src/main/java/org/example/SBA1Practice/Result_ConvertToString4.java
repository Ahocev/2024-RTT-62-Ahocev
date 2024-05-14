package org.example.SBA1Practice;

public class Result_ConvertToString4 {

    public static int getDigitsSum(int largeNumber) {
        // Convert the integer to a String
        String numberString = String.valueOf(largeNumber);

        int sum = 0;
        // Iterate over each character in the string
        for (int i = 0; i < numberString.length(); i++) {
            // Extract each character, convert it to a string and then parse it back to an integer
            int num = Integer.parseInt("" + numberString.charAt(i));
            // Add the num to the sum
            sum += num;
        }

        return sum;
    }

}
