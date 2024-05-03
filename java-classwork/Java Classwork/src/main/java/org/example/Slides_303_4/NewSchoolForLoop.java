package org.example.Slides_303_4;

import java.util.ArrayList;
import java.util.List;

public class NewSchoolForLoop {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("First");
        stringList.add("sec");
        stringList.add("thir");
        stringList.add("fourtht");

        // old school for loop - usually only used if you need to know the position of an item within the list (rare)
        for (int pos = 0; pos < stringList.size(); pos++) {
            System.out.println(stringList.get(pos));
        }

        System.out.println("-----------------------");

        // newschool for loop (cannot reverse without collections)
        for (String element : stringList) { // for the string element in the string list
            if (element.equals("sec")) {
                continue;
            }
            System.out.println(element);
        }

    }

}

