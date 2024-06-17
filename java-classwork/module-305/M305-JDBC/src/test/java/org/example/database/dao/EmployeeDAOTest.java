package org.example.database.dao;

import org.example.database.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class EmployeeDAOTest {

    // Write a basic test case for findById that uses a known value from the database
    // Write another test case for findById that uses a known bad value and check for null
    // Write a test case for findByFirstName ( same 2 cases for this known good and known not good )  -
    // experiment with assertions on values inside the list
    // Write a test case that will insert a record to the employee table, query back the record,
    // then delete the record that was created all inside the same test

    private static EmployeeDAO employeeDAO = new EmployeeDAO();

    @BeforeAll
    public static void beforeAll(){
        List<Employee> employees = employeeDAO.findByFirstName("Test Employee");
        for (Employee employee : employees) {
            employeeDAO.delete(employee);
        }

    }

    @Test
    public void findByIdTest() {

        // given
        Integer employeeId = 1002;

        // when
        Employee employee = employeeDAO.findById(employeeId);

        // then
        Assertions.assertEquals(employeeId, employee.getId());
        Assertions.assertNotNull(employee);
        Assertions.assertEquals("Diane", employee.getFirstname());
        Assertions.assertEquals("Murphy", employee.getLastname());

    }

    @Test
    public void findByInvalidIdTest() {

        // given
        Integer employeeId = 1000;

        // when
        Employee employee = employeeDAO.findById(employeeId);

        // then
        Assertions.assertNull(employee);

    }

    @ParameterizedTest
    @CsvSource(
            {
                    "Leslie",
                    "Tom",
            }
    )
    public void findByFirstNameTest(String firstName) {

        // given/when
        List<Employee> employees = employeeDAO.findByFirstName(firstName);

        // then
        Assertions.assertNotNull(employees);
        Assertions.assertFalse(employees.isEmpty());
        for ( Employee e : employees ) {
            Assertions.assertEquals(firstName, e.getFirstname());
        }
    }

    @Test
    public void findByInvalidFirstNameTest() {
        // given/when
        List<Employee> employees = employeeDAO.findByFirstName("Igor");

        // then
        Assertions.assertTrue(employees.isEmpty());

    }

    @Test
    public void createNewEmployeeTest() {

        // given
        Employee given = new Employee();
        given.setFirstname("Test Employee");
        given.setLastname("Lastname");
        given.setJobTitle("Job Title");
        given.setEmail("employee@employee.com");
        given.setOfficeID(1);
        given.setExtension("24");
        given.setReportsTo(1088);
        given.setVacationHours(10);
        given.setProfileImageUrl("http://example.com/profile/testemployee");

        // when
        employeeDAO.insert(given);

        // then
        Employee actual = employeeDAO.findById(given.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(given.getFirstname(), actual.getFirstname());
        Assertions.assertEquals(given.getLastname(), actual.getLastname());
        Assertions.assertEquals(given.getEmail(), actual.getEmail());

        employeeDAO.delete(given);

        Employee delete = employeeDAO.findById(given.getId());
        Assertions.assertNull(delete);

//        List<Employee> employees = employeeDAO.findByFirstName("Test Employee");
//        for (Employee employee : employees) {
//            employeeDAO.delete(employee);
//        }

    }

}

