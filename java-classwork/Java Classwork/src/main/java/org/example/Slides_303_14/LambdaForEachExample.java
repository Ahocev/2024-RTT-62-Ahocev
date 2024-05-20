package org.example.Slides_303_14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaForEachExample {

    public static void main (String[] args) {
        List<String> names = new ArrayList<String>();

        names.add("Larry");
        names.add ("Steve") ;
        names.add ("James") ;
        names.add ("Jessica") ;
        names.add ( "Conan") ;
        names.add ( "Ellen") ;

        System.out.println("====================================================");
        // printing all the names in a list
        names.forEach (name -> {     System.out.println (name);    } );

        System.out.println("====================================================");
        // new style for loop for printing names in a list
        for ( String name : names ) {
            System.out.println(name);
        }

        System.out.println("====================================================");
        // using lambda to remove items from the list
        names = names.stream().filter(name -> !name.startsWith("E")).collect(Collectors.toList());
        // print the list after items removed
        for ( String name : names ) {
            System.out.println(name);
        }

        System.out.println("====================================================");

        // using lambda to count items in a list
        long count = names.stream().filter(name -> name.startsWith("J")).count();
        // print the count
        System.out.println(count);

        System.out.println("====================================================");


    }
}

