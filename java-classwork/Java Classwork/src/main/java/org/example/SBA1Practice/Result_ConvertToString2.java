package org.example.SBA1Practice;

public class Result_ConvertToString2 {

    public static int getDigitsSum(int largeNumber) {
        String numString = String.valueOf(largeNumber);
        int sum = 0;

        for (int pos = 0; pos < numString.length(); pos++) {
            sum = sum + Character.getNumericValue(numString.charAt(pos));
        }

        return sum;
    }

}
