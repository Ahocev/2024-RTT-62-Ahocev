package org.example.SBA2Q1;

import java.util.ArrayList;

public class ArrayToList {

    // option one
    private ArrayList<String> arrayToList = new ArrayList<>();

    // option two
    public ArrayToList() {
        arrayToList = new ArrayList<>();


    }

    public void convert(String[] a) {

        for ( int pos = 0; pos < a.length; pos++ ) {
            arrayToList.add(a[pos]);
            System.out.println("I have added the string: " + a[pos] + " at the index: " + pos);


        }

    }

    public void replace(int idx) {
        // what we are doing here is getting the actual string that is in the arrayToList
        // before we overwrite it in the next line of code
        String value = arrayToList.get(idx);

        // this is how you add to an index in an ArrayList
        // takes 2 args
        // first is position to set
        // second is value to set
        arrayToList.set(idx, "");
        System.out.println("I have replaced the string: " + value + " with a null string" );

        // String x = ""; This is an empty string
        // String y = null; This means there is no string set in memory


    }

    public ArrayList<String> compact() {
        ArrayList<String> result = new ArrayList<>();

        for ( String s : arrayToList ) {
            if ( ! s.equals("")) {
                // makes sure youre adding it to the result
                result.add(s);
            }
        }

        return result;


    }

    public static void main(String[] args) {

        ArrayToList arrayToList = new ArrayToList();

        String[] strArray = {"one","two","three","four","five",};
        arrayToList.convert(strArray);

        arrayToList.replace(1);
        arrayToList.replace(2);

        ArrayList<String> compacted = arrayToList.compact();
        for( String c : compacted ) {
            System.out.println(c);
        }

    }

}
