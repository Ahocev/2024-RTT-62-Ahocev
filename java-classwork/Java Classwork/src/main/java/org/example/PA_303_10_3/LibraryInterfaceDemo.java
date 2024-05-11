package org.example.PA_303_10_3;

public class LibraryInterfaceDemo {

    public static void main(String[] args) {

        KidUser kid1 = new KidUser();
        kid1.age = 10; // Kid scenario
        kid1.registerAccount();

        kid1.bookType = "Kids"; // Kid book scenario
        kid1.requestBook();

        KidUser kid2 = new KidUser();
        kid2.age = 18; // Adult scenario for kid
        kid2.registerAccount();

        kid2.bookType = "Fiction"; // Incorrect book type for kid
        kid2.requestBook();

        // Test case #2: AdultUser scenarios
        AdultUser adult1 = new AdultUser();
        adult1.age = 5; // Kid scenario for adult
        adult1.registerAccount();

        adult1.bookType = "Kids"; // Incorrect book type for adult
        adult1.requestBook();

        AdultUser adult2 = new AdultUser();
        adult2.age = 23; // Proper adult scenario
        adult2.registerAccount();

        adult2.bookType = "Fiction"; // Correct book type for adult
        adult2.requestBook();


    }

}
