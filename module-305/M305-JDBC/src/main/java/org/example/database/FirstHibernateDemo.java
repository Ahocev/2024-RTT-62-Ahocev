package org.example.database;

import org.example.database.dao.EmployeeDAO;
import org.example.database.entity.Employee;

import java.util.List;

public class FirstHibernateDemo {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        List<Employee> employees = employeeDAO.findByLastName("Seinfeld");

        if (employees.isEmpty()) {
            // create a new employee
            Employee newEmployee = new Employee();

            newEmployee.setFirstname("Jerry");
            newEmployee.setLastname("Seinfeld");
            newEmployee.setEmail("JSeinfeld@perscholas.org");
            newEmployee.setOfficeID(3);
            newEmployee.setExtension("X12345");
            newEmployee.setJobTitle("Comedian");
            newEmployee.setVacationHours(0);

            EmployeeDAO.insert(newEmployee);
            System.out.println("Jerry Seinfeld added to the database");
        } else {
            System.out.println("Jerry Seinfeld is already in the database");
        }

        employees = employeeDAO.findByLastName("Seinfeld");

        for (Employee employee : employees) {
            System.out.println(employee);

        }

        // this employee id exists in the database and will return a record
        Employee employee = employeeDAO.findById(1715);
        System.out.println(employee);

        // this will return null because there is no employee with id 1
        employee = employeeDAO.findById(1);
        System.out.println(employee);

    }

}
