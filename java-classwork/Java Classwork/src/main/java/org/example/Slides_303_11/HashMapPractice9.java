package org.example.Slides_303_11;
import java.util.*;

public class HashMapPractice9 {

    // Write a Java program to create a set view of the mappings contained in a map.
    public static void main(String args[]) {
        HashMap < Integer, String > hash_map = new HashMap < Integer, String > ();
        hash_map.put(1, "Red");
        hash_map.put(2, "Green");
        hash_map.put(3, "Black");
        hash_map.put(4, "White");
        hash_map.put(5, "Blue");
        // create set view for the map

        // if just hashmap you get a string
        // printing it as a set allows the ability to loop over the set
        Set set = hash_map.entrySet();
        // check set values
        System.out.println("Set values: " + set);

    }

}
