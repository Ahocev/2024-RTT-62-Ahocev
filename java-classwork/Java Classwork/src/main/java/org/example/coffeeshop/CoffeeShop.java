package org.example.coffeeshop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


// abstracting the functionality of the main
public class CoffeeShop {

    private List<Product> products = new ArrayList<>();

    // building the menu of products for sale at the coffee shop
    public void initProducts() {
        Product p1 = new Product();
        p1.setPrice(5.46);
        p1.setName("Small Coffee");
        p1.setBeverage(true);
        products.add(p1);

        Product largeCoffee = new Product();
        largeCoffee.setPrice(9.46);
        largeCoffee.setName("Large Coffee");
        largeCoffee.setBeverage(true);
        products.add(largeCoffee);

        Product cakePop = new Product();
        cakePop.setPrice(4.89);
        cakePop.setName("Cake Pop");
        cakePop.setBeverage(false);
        products.add(cakePop);

        Product eggSandwich = new Product(7.89, "Egg Sandwich", false, 50);
        products.add(eggSandwich);

        ProductReader pr = new ProductReader();
        List<Product> productFromFile = pr.readProducts();
        products.addAll(productFromFile);

    }

    public void printCheapProducts() {

        // code filters and prints all products less than $5
        List<Product> cheapProducts = products.stream().filter(product -> product.getPrice() < 5).collect(Collectors.toList());
        cheapProducts.forEach(product -> System.out.println(product.getName() +"\t" + product.getPrice()));

        // same function but using old style for loop
        for ( Product product : products ) {
            if ( product.getPrice() < 5 ) {
                System.out.println(product.getName() + "\t" + product.getPrice());
            }
        }

    }

    // print the list of products available for sale
    public void printProducts() {
        for ( int pos = 0 ; pos < products.size() ; pos++ ) {
            Product product = products.get(pos);
            System.out.println((pos+1) + ") " + product.getName() + "\t" + product.getPrice() );
        }

        // products.forEach( (product) -> {System.out.println(product.getName() + "\t" + product.getPrice() );});
    }
}

