package org.example.database.dao;

import org.example.database.entity.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomerDAOTest {

    private static CustomerDAO customerDAO = new CustomerDAO();

    @AfterAll
    @BeforeAll
    public static void beforeAll() {
        // one use is to prepare or to clean up data either before or after test cases run
        // we could delete any customer form the database that has "Test Customer" as the name
        List<Customer> customers = customerDAO.findByCustomerName("Test Customer");
        for (Customer customer : customers) {
            customerDAO.delete(customer);
        }
        // if we were doing an old school JDBC connection, could create it here so the methods below are connected
        // then in an @AfterAll you can close the database connection and release resources
        }

    @Test
    public void findByIdTest() {

        // given
        Integer userid = 103;

        // when
        Customer customer = customerDAO.findById(userid);

        // then
        Assertions.assertNotNull(customer);
        Assertions.assertEquals(userid, customer.getId());
        Assertions.assertEquals("Atelier graphique", customer.getCustomerName());
        Assertions.assertEquals("Schmitt", customer.getContactLastname());

    }

    @Test
    public void findByInvalidIdTest() {

        // given
        Integer userid = 103033;

        // when
        Customer customer = customerDAO.findById(userid);

        // then
        Assertions.assertNull(customer);

    }

    @Test
    public void createNewCustomer() {

        // given
        Customer given = new Customer();

        given.setCustomerName("Test Customer");
        given.setContactFirstName("First Name");
        given.setContactLastname("Lastname");
        given.setAddressLine1("address 1");
        given. setCity("Somewhere");
        given. setCountry ("USA");
        given. setPhone ("2342342344");

        // when
        customerDAO.insert(given);

        // then
        Customer actual = customerDAO.findById(given.getId());

        Assertions.assertEquals(given.getCustomerName(), actual.getCustomerName());
        Assertions.assertEquals(given.getContactFirstName(), actual.getContactFirstName());
        Assertions.assertEquals(given.getContactLastname(), actual.getContactLastname());

    }
}
