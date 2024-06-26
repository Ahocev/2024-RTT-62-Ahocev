package org.example.Slides_303_6;

import java.util.Arrays;

public class ArrayDelete {

    public static int[] delete(int[] source, int deletedPosition) {

        if (deletedPosition < 0 || deletedPosition > source.length-1) {
            System.out.println("Position to delete is invalid");
            System.exit(0);
        }

        // 1) create a new array with size - 1
        int[] deleted = new int[source.length - 1];

        // 2) copy the first elements upto but not including the deleted position
        for (int pos = 0; pos < deletedPosition; pos++) {
            deleted[pos] = source[pos];
        }

        // 3) copy the last elements into a pos-1 in the new array
        for (int pos = deletedPosition + 1; pos < source.length; pos++) {
            deleted[pos - 1] = source[pos];
        }

        return deleted;
    }

    public static void main(String[] args) {
        //             0  1  2  3  4
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));

        //             0  1  2  3  4
        //             1, 2, 3, 4
        array = delete(array, 4);
        System.out.println(Arrays.toString(array));

        //             0  1  2  3  4
        //             1, 2, 3
        array = delete(array, 3);
        System.out.println(Arrays.toString(array));

        // Out of Bounds (there is no position 5)
        array = delete(array, 5);
        System.out.println(Arrays.toString(array));

    }

}
