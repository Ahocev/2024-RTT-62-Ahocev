package org.example.PA_303_11_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        String[][] students = new String[n][3];

        for (int i = 0; i < n; i++) {
            students[i][0] = scanner.next(); // ID
            students[i][1] = scanner.next(); // FirstName
            students[i][2] = scanner.next(); // CGPA
            scanner.nextLine(); // Consume the newline
        }

        // Sort the students using Arrays.sort with a custom comparator
        Arrays.sort(students, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                double cgpa1 = Double.parseDouble(s1[2]);
                double cgpa2 = Double.parseDouble(s2[2]);
                if (Double.compare(cgpa2, cgpa1) != 0) {
                    return Double.compare(cgpa2, cgpa1);
                } else if (!s1[1].equals(s2[1])) {
                    return s1[1].compareTo(s2[1]);
                } else {
                    int id1 = Integer.parseInt(s1[0]);
                    int id2 = Integer.parseInt(s2[0]);
                    return Integer.compare(id1, id2);
                }
            }
        });

        // Print the sorted student names
        for (int i = 0; i < n; i++) {
            System.out.println(students[i][1]);
        }

        scanner.close();
    }
}