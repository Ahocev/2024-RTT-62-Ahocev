package org.example.database;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;

import java.util.*;

import java.util.List;

public class ProductMain {

    // I want to be able to search for a product and then change the quantity in stock to reflect current inventory levels.
    // I want this program to be tolerant of user error
    // 1) I need to be able to prompt the user for which product to search for
    // 2) I need to be able to show the products and allow the user to select a product to modify
    // 3) I need to prompt the user to enter the new value quantity in stock
    // 4) I need to set the new quantity in stock on the product and save it to the database

    private ProductDAO productDAO = new ProductDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        // #1 prompt user to enter product name
        String productName = inputProductSearch();
        // use productDAO to run query
        List<Product> products = productDAO.findLikeName(productName);
        printProducts(products);
        Product selectedProduct = null;
        while (selectedProduct == null) {
            // #2 print list of products
            int productId = promptForProductId();
            // #2.5
            // 2 problems that can happen
            // 1) user enters non-numeric value
            // 2) user enters a numeric ID not in the database
            selectedProduct = productDAO.findById(productId);
            if (selectedProduct == null) {
                System.out.println("You have entered an invalid product ID");
            }
        }

        // #3
        int quantity = promptQuantityInStock();
        System.out.println(quantity);
        // #4
        updateQuantityInStock(selectedProduct, quantity);
    }

    public void updateQuantityInStock(Product product, int quantity) {
        product.setQuantityInStock(quantity);
        productDAO.update(product);

    }

    public int promptQuantityInStock() {
        while (true) {
            try {
                System.out.println("Enter the new value for quantity in stock: ");
                int quantity = scanner.nextInt();
                return quantity;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                // REMEMBER THIS FOR THE SBA
                // there was a dangling newLine character that was not consumed by nextInt()
                // we want to just read it and throw it away
                scanner.nextLine();
            }
        }
    }

    public void printProducts(List<Product> products) {

        System.out.println("Id | Product Name | Quantity In Stock");
        System.out.println("===================================================");
        for (Product product : products) {
            System.out.println(product.getId() + " | " + product.getProductName() + " | " + product.getQuantityInStock());
        }
        System.out.println("\n");
    }

    public int promptForProductId() {
        while(true) {
            try {
                System.out.print("Enter the product id to modify: ");
                int id = scanner.nextInt();
                return id;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public String inputProductSearch() {
        System.out.print("Enter a product name to search for: ");
        String productName = scanner.nextLine();
        return productName;
    }

    public static void main(String[] args) {
        ProductMain pm = new ProductMain();
        pm.run();

    }
}


