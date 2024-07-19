package com.example.springboot.form;

import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.OrderDetail;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString

public class CreateOrderFormBean {

    private int id;

    private Customer customer;

    private List<OrderDetail> orderDetails;

    private int customerId;

    private Date orderDate;

    private Date requiredDate;

    private String status;

    private String comment;

}

