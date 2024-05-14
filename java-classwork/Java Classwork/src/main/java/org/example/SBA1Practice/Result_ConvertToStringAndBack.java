package org.example.SBA1Practice;

public class Result_ConvertToStringAndBack {

    public static int getDigitsSum(int largeNumber) {
        // Convert the integer to a String
        String numberString = String.valueOf(largeNumber);

        int sum = 0;
        // Iterate over each character in the string
        for (int i = 0; i < numberString.length(); i++) { // if 0 is less than the numberString.length, keep looping
            // Extract each character, convert it to a string and then parse it back to an integer
            int digit = Integer.parseInt(Character.toString(numberString.charAt(i)));
            // Add the digit to the sum
            sum += digit;
        }

        return sum;
    }

}
