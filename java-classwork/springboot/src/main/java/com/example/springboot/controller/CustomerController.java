package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateCustomerFormBean;
import com.example.springboot.form.CreateEmployeeFormBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    private final CustomerDAO customerDAO;
    private final EmployeeDAO employeeDAO;

    public CustomerController(CustomerDAO customerDAO, EmployeeDAO employeeDAO) {
        this.customerDAO = customerDAO;
        this.employeeDAO = employeeDAO;
    }

    // this URL is going to be localhost:8080/customer/list
    @GetMapping("/search")
    public ModelAndView list() {
        return null;
    }

    @GetMapping("/detail")
    public ModelAndView detail() {
        return null;
    }

    @GetMapping("/createCustomer")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("customer/createCustomer");

        List<Customer> salesRepEmployeeId = customerDAO.findAll();
        response.addObject("salesRepEmployeeId", salesRepEmployeeId);

        List<Customer> customers = customerDAO.findAll();  // Fetch the list of Office entities
        response.addObject("customers", customers);  // Pass it to the model

        return response;
    }

    @GetMapping("/createCustomerSubmit")
    public ModelAndView creatCustomerSubmit(CreateCustomerFormBean form) {
        ModelAndView response = new ModelAndView();

        Customer customer = new Customer();
        customer.setCustomerName(form.getCustomerName());
        customer.setContactFirstname(form.getContactFirstname());
        customer.setContactLastname(form.getContactLastname());
        customer.setPhone(form.getPhone());
        customer.setAddressLine1(form.getAddressLine1());
        customer.setCity(form.getCity());
        customer.setState(form.getState());
        customer.setCountry(form.getCountry());

        Employee employee = employeeDAO.findById(form.getSalesRepEmployeeId());

        customer.setEmployee(employee);

        customer = customerDAO.save(customer);

        response.setViewName("redirect:/customer/detail?customerId=" + customer.getId());

        return response;
    }

}
