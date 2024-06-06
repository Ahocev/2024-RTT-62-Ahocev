package org.example.database;

import org.example.database.dao.CustomerDAO;
import org.example.database.entity.Customer;

import java.util.List;

public class CustomerMain {

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.removeDuplicates("Tigerbelly");

        List<Customer> customers = customerDAO.findByCustomerName("Tigerbelly");

        if (customers.isEmpty()) {
            Customer newCustomer = new Customer();

            newCustomer.setCustomerName("Tigerbelly");
            newCustomer.setContactFirstName("Bobby");
            newCustomer.setContactLastname("Lee");
            newCustomer.setPhone("12345678");
            newCustomer.setAddressLine1("1234 Hollywood Blvd");
            newCustomer.setCity("Los Angeles");
            newCustomer.setPostalCode("90210");
            newCustomer.setCountry("USA");

            CustomerDAO.insert(newCustomer);
            System.out.println("Bobby Lee added to the database");
        } else {
            System.out.println("Bobby Lee is already in the database");
        }

        Customer customer = customerDAO.findById(520);
        System.out.println(customer);


    }


}


