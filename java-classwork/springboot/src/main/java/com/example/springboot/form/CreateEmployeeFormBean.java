package com.example.springboot.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {

    @Length(max = 100, message="Email must be less than 100 characters.")
    @NotEmpty(message="Email is required.")
    @Email(message = "Must be a valid email.")
    private String email;

    @Pattern(regexp="[a-zA-Z]+", message="First name must have characters only.")
    @Length(max = 50, message="First name must be less than 50 characters.")
    @NotEmpty(message="First name is required.")
    private String firstName;

    @Length(max = 50, message="Last name must be less than 50 characters.")
    @NotEmpty(message="First Name is required.")
    private String lastName;

    private Integer reportsTo;

    private Integer officeId;

    private String extension;

    private String jobTitle;

    private Integer vacationHours;

    private String profileImageUrl;

}
