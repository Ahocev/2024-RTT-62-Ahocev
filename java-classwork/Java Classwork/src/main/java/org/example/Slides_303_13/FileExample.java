package org.example.Slides_303_13;

import java.io.*;

public class FileExample {

    public static void main(String[] args) throws IOException {

        File f = new File(".");
        System.out.println(f.getCanonicalPath());

        File[] files = f.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
            if (file.isDirectory()) {
                System.out.println(" is a directory");
            } else {
                System.out.println(" is a file");
            }

        }

        try {
            File file = new File ("./newfile.txt");
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }
}
