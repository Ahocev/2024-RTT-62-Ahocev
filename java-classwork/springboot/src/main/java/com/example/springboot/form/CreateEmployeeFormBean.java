package com.example.springboot.form;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {

    private String email;
    private String firstName;
    private String lastName;

    private Integer reportsTo;

}
