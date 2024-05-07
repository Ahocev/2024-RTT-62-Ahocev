package org.example.Slides_303_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysExample {

    public static void main(String[] args) {

        // creates an array on one line
        double[] dArray = new double[10];


        // this is also a valid way of creating a new array
        // note that it is on two lines
        // first line crates the variable
        // 2nd creates the new array in memory
        int[] iArray;
        iArray = new int[20];

        // this gets used a bit
        // the compiler will se this and create an array with 3 values
        // creates a new array of strings and hard coding the values in one line
        // always name your list or arrays as plurals (it's not one thing)
        String[] constants = { "String1", "String2", "String3" };

        // new style for loop can be used with arrays
        for ( String constant : constants ) {
            System.out.println(constant);
        }
        // this works for other data types
        // integer array variable name is equal to items in brackets
        // primitive numbers initicalise to 0
        int[] intConstants = { 1, 2, 3, 4, 5 };
        for ( int pos = 0 ; pos < intConstants.length ; pos++ ) {
            System.out.println(pos);
        }

        int x = intConstants.length; // getting the length of an array uses wrapper .length

        //same as doing:
        String[] c1 = new String[5];
        c1[0] = "String1";

        // -------------------------

        // Can create an array for a  class for an object
        // these will initialize to null because it is an object array
        // all object arrays init to null
        String[] sArray = new String[10]; // does not need a construct "()"
        for ( int pos = 0 ; pos < intConstants.length ; pos++ ) {
            System.out.println(sArray[pos]);
        }

        //----------------------------

        String s = new String();
        s.length(); //  will give the size of the string

        sArray[0] = s;


        // 99% of what you will use in the future
        // note "size" for Lists
        List<Double> dList = new ArrayList<>();
        dList.size();

        // decending
        int[] desc = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Arrays.sort(desc);
        System.out.println(Arrays.toString(desc));


        // how to create an array of many different variable types i.e. "Object Array"
        Object[] objectArray = new Object[10];
        objectArray[0] = new String("String 1");
        objectArray[1] = new Integer( 10);
        objectArray[2] = new Double( 12.32);
    }
}
