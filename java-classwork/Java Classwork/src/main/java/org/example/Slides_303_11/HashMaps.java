package org.example.Slides_303_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMaps {

    public static void main(String[] args){

        List<String> stringlist = new ArrayList<>();

        //============================================
        // Know This:

        Map<String, String> stringMap = new HashMap<>();

        stringMap.put("key", "value");
        stringMap.put("key2", "value2");
        stringMap.put(null, "actual value");
        stringMap.put("null value", null);
        stringMap.put("null value 1", null);

        // this will overwrite the first null key (can only be one unique key name identifying a value in the keySet)
        stringMap.put(null, "actual value 1234");

        String value = stringMap.get("key");
        System.out.println(value);

        // common loop that prints out keys and their associated value
        // for each string what is returned is a keySet
        for ( String key : stringMap.keySet()) {
            System.out.println(key + " == " + stringMap.get(key));
        }

        //============================================

        // in this case the key is an int and the value is a string
        Map< Integer, String > intMap = new HashMap<>();
        intMap.put(10, "ten");

        // happens sometimes but usually there other ways of solving this
        // this would be a workaround for allowing duplicate values for a key
        // takes a bit of extra work to implement
        Map<String, List<String>> listMap = new HashMap<>();

        // this happens when working with ad hoc queries
        // this is going to happen far more often than the map of lists
        // when it comes back from the database this way we treat it as a read-only object
        List<Map<String, Object>> queryResult;

    }

}
