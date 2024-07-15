package com.example.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/emplolyee")
public class EmployeeController {

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam Integer employeeId) {
        ModelAndView response = new ModelAndView("employee/detail");
        return response;
    }

}
