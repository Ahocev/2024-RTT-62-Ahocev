package com.example.springboot.form;

import com.example.springboot.validation.EmployeeEmailUnique;
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

    private Integer employeeId;

    @Length(max = 100, message="Email must be less than 100 characters.")
    @NotEmpty(message = "Email is required.")
    @Email(message = "Must be a valid email.")
    // @EmployeeEmailUnique(message = "This email is already in use.")
    private String email;

    @Pattern(regexp="[a-zA-Z]+", message = "First name must have characters only.")
    @Length(max = 50, message="First name must be less than 50 characters.")
    @NotEmpty(message ="First name is required.")
    private String firstName;

    @Length(max = 50, message = "Last name must be less than 50 characters.")
    @NotEmpty(message = "First Name is required.")
    private String lastName;

    private Integer reportsTo;

    private Integer officeId;

    @Length(max = 10, message="Extension must be less than 10 characters.")
    private String extension;

    @Length(max = 50, message="Job Title must be less than 50 characters.")
    private String jobTitle;

    private Integer vacationHours;

    private String profileImageUrl;

}
