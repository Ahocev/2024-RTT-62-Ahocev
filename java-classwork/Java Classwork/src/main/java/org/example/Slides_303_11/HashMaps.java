package org.example.Slides_303_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMaps {

    public static void main(String[] args){

        List<String> stringlist = new ArrayList<>();

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

        for ( String key : stringMap.keySet()) {
            System.out.println(key + " == " + stringMap.get(key));
        }

    }

}
