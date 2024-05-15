package org.example.PA_303_11_1;
import java.util.*;
import java.io.*;

public class Phonebook {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine()); // Read the number of entries
        HashMap<String, String> phoneBook = new HashMap<>();

        // Read the phone book entries
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine().trim();
            String phoneNumber = sc.nextLine().trim();
            phoneBook.put(name, phoneNumber);
        }

        // Read the queries until end-of-file
        while (sc.hasNextLine()) {
            String query = sc.nextLine().trim();
            if (phoneBook.containsKey(query)) {
                System.out.println(query + "=" + phoneBook.get(query));
            } else {
                System.out.println("Not found");
            }
        }

        sc.close();
    }

}
