package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OrderDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Order;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateCustomerFormBean;
import com.example.springboot.form.CreateEmployeeFormBean;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private EmployeeDAO employeeDao;

     @Autowired
     private OrderDAO orderDao;


    // this URL is going to be localhost:8080/customer/list
    @GetMapping("/search")
    public ModelAndView list() {
        return null;
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam Integer customerId) {
        ModelAndView response = new ModelAndView("customer/detail");

        List<Order> orders = orderDao.findByCustomerId(customerId);
        response.addObject("orders", orders);

        Customer customer = customerDao.findById(customerId);
        response.addObject("customer", customer);

        return response;
    }



    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("customer/create");

        List<Employee> employees = employeeDao.findAll();
        response.addObject("employees", employees);

        return response;
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer customerId) {
        ModelAndView response = new ModelAndView("customer/create");

        List<Employee> employees = employeeDao.findAll();
        response.addObject("employees", employees);

        if (customerId != null) {
            Customer customer = customerDao.findById(customerId);

            if (customer != null) {

                CreateCustomerFormBean form = new CreateCustomerFormBean();
                form.setCustomerId(customer.getId());
                form.setContactFirstname(customer.getContactFirstname());
                form.setContactLastname(customer.getContactLastname());
                form.setCity(customer.getCity());
                form.setCountry(customer.getCountry());
                form.setPhone(customer.getPhone());
                form.setAddressLine1(customer.getAddressLine1());
                form.setPostalCode(customer.getPostalCode());
                form.setSalesRepEmployeeId(customer.getSalesRepEmployeeId());
                form.setCreditLimit(customer.getCreditLimit());

                response.addObject("form", form);

            }
        }

        return response;

    }

    @GetMapping("/createSubmit")
    public ModelAndView creatSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);

            List<Employee> employees = employeeDao.findAll();
            response.addObject("employees", employees);


            response.setViewName("customer/edit");

            response.addObject("form", form);

            return response;

        } else {

            log.debug(form.toString());

            Customer customer = customerDao.findById(form.getCustomerId());
            if (customer == null) {
                customer = new Customer();
            }

            customer.setCustomerName(form.getCustomerName());
            customer.setContactFirstname(form.getContactFirstname());
            customer.setContactLastname(form.getContactLastname());
            customer.setPhone(form.getPhone());
            customer.setAddressLine1(form.getAddressLine1());
            customer.setCity(form.getCity());
            customer.setState(form.getState());
            customer.setCountry(form.getCountry());

            Employee employee = employeeDao.findById(form.getSalesRepEmployeeId());

            customer.setEmployee(employee);

            customer = customerDao.save(customer);

            response.setViewName("redirect:/customer/detail?customerId=" + customer.getId());

            return response;
        }
    }

}
