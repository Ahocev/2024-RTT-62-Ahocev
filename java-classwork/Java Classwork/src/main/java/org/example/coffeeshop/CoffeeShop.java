package org.example.coffeeshop;

import java.util.ArrayList;
import java.util.List;


// abstracting the functionality of the main
public class CoffeeShop {

    //
    private List<Product> products = new ArrayList<>();

    // building the menu of products for sale at the coffee shop
    public void initProducts() {

        Product coffee = new Product();
        coffee.setPrice(5.46);
        coffee.setName("Small Coffee");
        coffee.setBeverage(true);
        products.add(coffee);

        Product largeCoffee = new Product();
        largeCoffee.setPrice(9.46);
        largeCoffee.setName("Large Coffee");
        largeCoffee.setBeverage(false);
        products.add(largeCoffee);

        Product cakePop = new Product();
        cakePop.setPrice(3.89);
        cakePop.setName("Cake Pop");
        cakePop.setBeverage(false);
        products.add(cakePop);

        Product eggSandwich = new Product(7.89, "Egg Sandwich", false);
        products.add(eggSandwich);

    }

    // print the list of products available for sale
    public void printProducts() {
        for ( int pos = 0 ; pos < products.size() ; pos++ ) {
            Product product = products.get(pos);
            System.out.println( (pos +1) + ") " +products.get(pos).getName() + "\t" + product.getPrice() );
        }
    }
}
