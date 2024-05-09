package org.example.Classwork_303_6_Arrays;

import java.util.Arrays;

public class ArrayInsertFunction {

    public static int[] insert(int[] source, int insertPosition, int valueToInsert) {

        int[] result = new int[source.length + 1];

        // 2) copy the first part of the array (before position 2) from old to new
        for (int pos = 0; pos < insertPosition; pos++) {
            result[pos] = source[pos];
        }

        // 3) insert the value you want in pos 2

        result[insertPosition] = valueToInsert;

        // 4) copy over the rest of the array

        for (int pos = insertPosition; pos < source.length; pos++) {
            result[pos + 1] = source[pos];
        }

        return result;

    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));

        // original array
        // pos   01234
        // value 12345

        // array after inserting
        // pos   012345
        // value 129345

        array = insert(array, 2, 9);
        System.out.println(Arrays.toString(array));

        array = insert(array, 0, 0);
        System.out.println(Arrays.toString(array));
    }
}


