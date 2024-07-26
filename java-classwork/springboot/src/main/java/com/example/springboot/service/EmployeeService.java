package com.example.springboot.service;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.dao.OfficeDAO;
import com.example.springboot.database.entity.Employee;
import com.example.springboot.database.entity.Office;
import com.example.springboot.form.CreateEmployeeFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDao;

    @Autowired
    private OfficeDAO officeDao;

    public Employee createEmployee (CreateEmployeeFormBean form) {

        log.debug(form.toString());

        Employee employee = employeeDao.findById(form.getEmployeeId());
        if (employee == null) {
            employee = new Employee();
        }

        employee.setEmail(form.getEmail());
        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setReportsTo(form.getReportsTo());
        employee.setExtension(form.getExtension());
        employee.setVacationHours(form.getVacationHours());
        employee.setProfileImageUrl(form.getProfileImageUrl());
        employee.setJobTitle(form.getJobTitle());

        Office office = officeDao.findById((form.getOfficeId()));

        employee.setOffice(office);

        employee = employeeDao.save(employee);

        return employee;

    }

}
