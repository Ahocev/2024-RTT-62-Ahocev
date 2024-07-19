package com.example.springboot.validation;

import com.example.springboot.database.dao.EmployeeDAO;
import com.example.springboot.database.entity.Employee;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class EmployeeEmailUniqueImpl implements ConstraintValidator<EmployeeEmailUnique, String> {
    public static final Logger LOG = LoggerFactory.getLogger(EmployeeEmailUniqueImpl.class);

    @Autowired
    private EmployeeDAO employeeDao;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (StringUtils.isEmpty(value)) {

            return true;
        }

        Employee employee = employeeDao.findByEmailIgnoreCase(value);
        return (employee == null);

    }
}
