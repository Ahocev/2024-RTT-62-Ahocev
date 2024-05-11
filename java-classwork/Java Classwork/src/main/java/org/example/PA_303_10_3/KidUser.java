package org.example.PA_303_10_3;

public class KidUser implements LibraryUser {

    int age;
    String bookType;

    public void registerAccount() {
        if (age <= 11) {
            System.out.println("You have successfully registered under a Kids Account.");
        } else if (age > 11) {
            System.out.println("Sorry, age must be less than 12 to register as a kid.");
        }
    }

    public void requestBook() {
        if (bookType.equals("Kids")) {
            System.out.println("Book issued successfully, please return the book within 10 days.");
        } else {
            System.out.println("Oops, you are allowed to take only kids books.");
        }
    }

}
