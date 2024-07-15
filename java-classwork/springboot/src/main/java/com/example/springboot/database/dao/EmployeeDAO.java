package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springboot.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    Employee findById(Integer id);

    @Query("select e from Employee e where e.firstName like lower(concat('%', :name, '%')) or e.lastName like lower(concat('%', :name, '%')) ")
    List<Employee> findByFirstOrLast(String name);
}
