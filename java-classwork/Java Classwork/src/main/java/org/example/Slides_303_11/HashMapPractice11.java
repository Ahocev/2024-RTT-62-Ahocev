package org.example.Slides_303_11;
import java.util.*;

public class HashMapPractice11 {

    // Write a Java program to get a set view of the keys contained in this map.
    public static void main(String args[]){

        HashMap<Integer,String> hash_map= new HashMap<Integer,String>();

        hash_map.put(1,"Red");
        hash_map.put(2,"Green");
        hash_map.put(3,"Black");
        hash_map.put(4,"White");
        hash_map.put(5,"Blue");

        // get keyset value from map
        // retrieves the keys of a hashmap as a set
        Set keyset = hash_map.keySet();
        // for each key in keyset do something with the key

        // check key set values
        System.out.println("Key set values are: " + keyset);
    }

}
