package com.example.springboot.controller;

import com.example.springboot.database.dao.CustomerDAO;
import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateEmployeeFormBean;
import com.example.springboot.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private EmployeeDAO employeeDao;

    @Autowired
    private OfficeDAO officeDao;  // Add this line to include OfficeDAO

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam Integer employeeId) {
        ModelAndView response = new ModelAndView("employee/detail");

        List<Customer> customers = customerDao.findBySalesRepEmployeeId(employeeId);
        response.addObject("customers", customers);

        Employee employee = employeeDao.findById(employeeId);
        response.addObject("employee", employee);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView("employee/create");

        loadDropdowns(response); // Pass it to the model

        return response;
    }

    private void loadDropdowns(ModelAndView response) {

        List<Employee> reportsToEmployees = employeeDao.findAll();
        response.addObject("reportsToEmployees", reportsToEmployees);

        List<Office> offices = officeDao.findAll();  // Fetch the list of Office entities
        response.addObject("offices", offices);
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(required = false) Integer employeeId) {
        ModelAndView response = new ModelAndView("employee/create");

        loadDropdowns(response);

        if (employeeId != null) {
            Employee employee = employeeDao.findById(employeeId);

            if (employee != null) {

                CreateEmployeeFormBean form = new CreateEmployeeFormBean();
                form.setEmployeeId(employee.getId());
                form.setEmail(employee.getEmail());
                form.setFirstName(employee.getFirstName());
                form.setLastName(employee.getLastName());
                form.setReportsTo(employee.getReportsTo());
                form.setOfficeId(employee.getOffice().getId());
                form.setExtension(employee.getExtension());
                form.setVacationHours(employee.getVacationHours());
                form.setProfileImageUrl(employee.getProfileImageUrl());
                form.setJobTitle(employee.getJobTitle());

                response.addObject("form", form);

            }
        }

        return response;

    }

// repo commit test

    @GetMapping("/createSubmit")
    public ModelAndView creatSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();

        if (form.getEmployeeId() == null ){
            Employee e = employeeDao.findByEmailIgnoreCase(form.getEmail());
            if ( e != null ) {
                bindingResult.rejectValue("email", "email", "This email is already in use.");
            }
        }

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            response.addObject("bindingResult", bindingResult);

            loadDropdowns(response);

            response.setViewName("employee/create");

            response.addObject("form", form);

            return response;

        } else {

            Employee employee = employeeService.createEmployee(form);

            response.setViewName("redirect:/employee/detail?employeeId=" + employee.getId());

            return response;

        }

    }

}
