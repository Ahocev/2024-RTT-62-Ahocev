package org.example.SBA1Practice;

public class SBA1Practice {

    public static void main (String[] args) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // part 1 - create a for loop to print each character of the string s on its own line
        // you can use the s.charAt(pos) function

        for (int pos = 0; pos < s.length(); pos++) {
            System.out.println(s.charAt(pos));
        }

        // part 2 - given the following Strings, convert them to integer values
        // Integer.valueOf()
        String ten = "10";
        String hundred = "100";

        int tenInt = Integer.valueOf(ten);
        int hundredInt = Integer.valueOf(hundred);
        System.out.println(tenInt);
        System.out.println(hundredInt);

        // part 3 - given an integer array find the sum of all the integers in the array

        int[] array = { 2, 4, 5, 6, 7, 8, 10 };
        int sum = 0;

        for ( int i = 0; i < array.length; i++ ) {
            sum += array[i];
        }

        System.out.println(sum);

        // part 4 - given an array of strings, convert them to numbers and print the sum

        String[] nums = { "2", "4", "5", "6", "7", "8", "10" };

        int sum2 = 0;
        for ( String num : nums ) {
            sum2 += Integer.valueOf(num);
        }

        System.out.println(sum2);

    }
}
