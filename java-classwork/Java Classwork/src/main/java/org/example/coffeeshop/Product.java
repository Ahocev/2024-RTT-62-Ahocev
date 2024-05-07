package org.example.coffeeshop;

// Product is an example of encapsulation
//
public class Product {

    // all these are member variables
    // were taking these 3 things and making them a "Product"
    // grouping a set of properties together so that they can be called upon in one call
    private double price;
    private String name;
    private boolean beverage;
    // private int quantityAvailable;

    // constructor with no args
    // the constructor does not have a return type
    // constructor has to be the name of the class
    // constructor says when I create a new product and I give it some assignments, it will construct for us
    public Product() {

    }

    // constructor with args
    // only if you want to have a custom constructor that you add them
    // getters and setters can use "this"
    public Product(double price, String name, boolean beverage) {
        // calling back to variable types at top above constructor start
        this.price = price;
        this.name = name;
        this.beverage = beverage;

    }

    // public, return type
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // booleans are isVariable rather than getVariable
    public boolean isBeverage() {
        return beverage;
    }

    public void setBeverage(boolean beverage) {
        this.beverage = beverage;
    }
}
