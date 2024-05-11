package org.example.GLAB_303_11_2;

import java.util.ArrayList;
import java.util.List;

public class CreateArrayListExample {

    public static void main(String[] args){
        // creating an ArrayList of String
        List<String> animals = new ArrayList<>();

        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Bear");
        animals.add("Oh My");

        System.out.println(animals);

        // add an element at a particular index in an ArrayList
        animals.add(2, "Elephant");

        System.out.println(animals);

    }

}
