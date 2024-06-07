package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdetails")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id", insertable = false, updatable = false)
    private Integer orderId;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Integer productId;

    @Column(name = "quantity_ordered")
    private Integer quantityOrdered;

    @Column(name = "price_each", columnDefinition = "DECIMAL")
    private Double priceEach;

    @Column(name = "order_line_number", columnDefinition = "SMALLINT")
    private Integer orderLineNumber;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;
}