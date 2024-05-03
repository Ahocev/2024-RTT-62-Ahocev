package org.example.Slides_303_4;

public class ForLoopExample {
    public static void main(String[] args) {
        while (true) {
            for (int count = 0; count <= 10; count++) {
                System.out.println("The count = " + count);
            }

            for (int count = 10; count >= 0; count--) {
                System.out.println("The count = " + count);
            }
        }
    }
}
