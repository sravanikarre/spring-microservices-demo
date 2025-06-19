package com.springmircoservies.product_service.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column
    private String productName;

    @Column
    private Double productPrice;
}
