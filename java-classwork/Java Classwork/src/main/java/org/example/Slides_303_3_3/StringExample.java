package org.example.Slides_303_3_3;

public class StringExample {

    public static void main(String[] args){

        String str = "blahdy blah blah blah";

        System.out.println("the length of the string = " + str.length());

        // will not modify str, will create a new string and then return the new string
        String str2 = str.toUpperCase();

        String str3 = str.toLowerCase();

        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);

        String filename = "Hello.Java";
        System.out.println("The file name is " + filename);

        System.out.println("file name is " + filename + " and the length is " + filename.length());

        System.out.println("period is at index " + filename.indexOf('.'));

        System.out.println("file extension is " + filename.substring(filename.indexOf('.') + 1));

        System.out.println("name of file is " + filename.substring(0, filename.indexOf('.')));

        System.out.println("unhappy".substring(2));


    }

}
