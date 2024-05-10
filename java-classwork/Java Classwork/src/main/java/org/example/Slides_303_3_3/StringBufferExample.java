package org.example.Slides_303_3_3;

public class StringBufferExample {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("filename.txt");

        // NOTE: the 2nd argument is not inclusive of the position (0, 4) = (0, 1, 2, 3)
        // run through the debugger to see how it works
        // for the kba use a piece of blank scratch paper to write the string down after each operation

        // 012345678901
        // filename.txt
        sb.insert(0, "new_");

        // 0123456789012345
        // new_filename.txt
        System.out.println(sb);

        // 0123456789012345
        // old_filename.txt
        // replace up to, but not including (replaces 0, 1, 2, 3), not inclusive of end argument
        sb.replace(0, 4, "old_");

        System.out.println(sb);

        // the thing to memorize for the KBA is that replace is going to first delete the items from 0 to 4
        // then insert the item at position 0
        sb.replace(0, 4, "very_old_");

        // 012345678901234567890
        // very_old_filename.txt
        System.out.println(sb);

        // 012345678901234567890
        // txt.emanelif_dlo_yrev
        sb.reverse();
        System.out.println(sb);

        // 012345678901234567890
        //     emanelif_dlo_yrev
        sb.delete(0, 4);
        System.out.println(sb);

    }
}
