package org.example.Slides_303_4;

public class IfStatements {

    public static void main(String[] args) {

        int x = 9;
        x = test(x); // fucntion is adding 1 to x, making x 10. Now because x is not less than 10, moves to next true if

        if (x < 10) {
            System.out.println("Less than 10 " + (x < 10));
        } else if (x < 20) {
            System.out.println("Less than 20 " + (x < 20));
        } else if (x < 30) {
            System.out.println("Less than 30 ");
        } else if (x < 40) {
            System.out.println("Less than 40 ");
        }

        if (x < 8) {
            System.out.println("Amazing");
        }

        int i = 1;
        int j = 2;
        int k = 3;
        if (i > j) {
            if (i > k) {
                System.out.println("A");
            }
        } else {
            System.out.println("B");
        }

    }

    public static int test(int x) {
        x = x + 1;
        return x;
    }

}
