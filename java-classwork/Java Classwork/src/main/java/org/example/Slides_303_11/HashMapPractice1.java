package org.example.Slides_303_11;

import java.util.HashMap;
import java.util.Map;

public class HashMapPractice1 {

    // Write a Java program to associate the specified value with the specified key in a HashMap.
    public static void main(String[] args){

        Map<Integer, String> hash_map = new HashMap<>();
        hash_map.put(1, "Red");
        hash_map.put(2, "Green");
        hash_map.put(3, "Black");
        hash_map.put(4, "White");
        hash_map.put(5, "Blue");

        // for each Map.Entry x that exists within the entry set method called on our hash_map object
        // print the x.getKey and associated x.getValue
        for(Map.Entry x : hash_map.entrySet()){
            System.out.println(x.getKey()+" "+x.getValue());
        }
    }
}
