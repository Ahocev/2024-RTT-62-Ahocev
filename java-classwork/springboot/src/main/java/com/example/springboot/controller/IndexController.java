package com.example.springboot.controller;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/index/{id}")
    public ModelAndView indexPathVar(@PathVariable Integer id) {
        // this function is for the home page of the website which is express as just a plain slash "/"
        ModelAndView response = new ModelAndView("index");

        Product product = productDAO.findById(id);
        response.addObject("productKey", product);

        // by default the logging level is set to info so the debug message will not be printed in the terminal
        log.debug("Debug level");
        log.info("Info level");
        log.warn("Warn level");
        log.error("Error level");

        response.addObject("message", "Hello World!");

        return response;
    }

    @GetMapping("/")
    public ModelAndView index(@RequestParam(required = false) Integer id) {
        // this function is for the home page of the website which is express as just a plain slash "/"
        ModelAndView response = new ModelAndView("index");

        Product product = productDAO.findById(id);
        response.addObject("productKey", product);

        response.addObject("message", "Hello World!");

        return response;
    }

    @GetMapping("/page-url")
    public ModelAndView canBeAnyFunctionNameYouWant() {
        // this page is for another page of the website which is express as "/page-url"
        ModelAndView response = new ModelAndView("another-page");

        return response;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {
        // this page is for another page of the website which is express as "/page-url"
        ModelAndView response = new ModelAndView("search");

        log.debug("The user searched for the term: " + search);


        response.addObject("search", search);

        List<Product> products = productDAO.findByNameOrCode(search);
        response.addObject("products", products);

        return response;
    }

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/esearch")
    public ModelAndView esearch(@RequestParam(required = false) String esearch) {
        ModelAndView response = new ModelAndView("esearch");

        log.debug("The user searched for the term: " + esearch);

        response.addObject("esearch", esearch);

        List<Employee> employees = employeeDAO.findByFirstOrLast(esearch);
        response.addObject("employees", employees);

        return response;

    }

}
