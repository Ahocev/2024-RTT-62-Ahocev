package org.example.GLAB_303_11_1;

public class MyRunner {

    public static void main(String[] args){

        // initialize the class with integer data
        DemoClass dObj = new DemoClass();
        dObj.genericsMethod(25); // passing int
        dObj.genericsMethod("Per Scholas"); // passing String
        dObj.genericsMethod(2563.5f); // passing float
        dObj.genericsMethod('H'); // passing Char

    }

}
