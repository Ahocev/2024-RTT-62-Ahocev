package org.example.GLAB_303_13_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyRunner {

    public static void main(String[] args) throws FileNotFoundException {

        try {

            String location = "/Users/phaeded/Development/2024-RTT-62/java-classwork/Java Classwork/CourseData.csv";
            File file = new File(location);
            Scanner input = new Scanner(file);
            ArrayList<course> data = new ArrayList<>();

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] splitLine = line.split(",");

                course cObj = new course();
                cObj.setCode(splitLine[0]);
                cObj.setCourse_name(splitLine[1]);
                cObj.setInstructor_name(splitLine[2]);

                data.add(cObj);

            }

            for (course c : data) {

                System.out.println(c.getCode() + " | " + c.getCourse_name() + "|" + c.getInstructor_name());
                System.out.println("===============================");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found! ");
            e.printStackTrace();


        }

    }

}
