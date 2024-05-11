package org.example.PA_303_10_1;

public abstract class Monster {
    protected String name; // name of the monster

    public Monster(String name) {
        this.name = name;
    }

    // Abstract method to be implemented by subclasses
    public abstract String attack();
}
