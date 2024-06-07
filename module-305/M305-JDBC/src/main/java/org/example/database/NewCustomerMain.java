package org.example.database;

import org.example.database.dao.CustomerDAO;
import org.example.database.dao.OrderDAO;
import org.example.database.entity.Customer;
import org.example.database.entity.Order;

import java.util.List;
import java.util.Scanner;

public class NewCustomerMain {

    private CustomerDAO customerDAO = new CustomerDAO();
    private OrderDAO orderDAO = new OrderDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        Customer selectedCustomer = null;
        while (selectedCustomer == null) {
            int customerId = promptForCustomerId();
            selectedCustomer = customerDAO.findById(customerId);
            if (selectedCustomer == null) {
                System.out.println("You have entered an invalid customer ID");
            } else {
                printCustomer(selectedCustomer);
                List<Order> orders = orderDAO.findByCustomerId(customerId);
                printOrders(orders);
            }
        }
    }

    public int promptForCustomerId() {
        while (true) {
            try {
                System.out.print("Enter the customer id: ");
                int id = scanner.nextInt();
                return id;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // clear the buffer
            }
        }
    }

    public void printCustomer(Customer customer) {
        System.out.println("Id | Customer Name");
        System.out.println("===================================================");
        System.out.println(customer.getId() + " | " + customer.getCustomerName());
        System.out.println("\n");
    }

    public void printOrders(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            System.out.println("No orders found for this customer.");
            return;
        }
        System.out.println("Order Id | Order Date");
        System.out.println("===================================================");
        for (Order order : orders) {
            System.out.println(order.getId() + " | " + order.getOrderDate());
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        NewCustomerMain ncm = new NewCustomerMain();
        ncm.run();
    }
}