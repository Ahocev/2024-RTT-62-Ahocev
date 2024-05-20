package org.example.Slides_303_14;

public class MainFunctionalKBA {

    public static void main(String[] args) {

        MyFunctionalInterfaceKBA fi = n -> {
            return n * n;

        };

        System.out.println(fi.sqr(5));

    }

}
