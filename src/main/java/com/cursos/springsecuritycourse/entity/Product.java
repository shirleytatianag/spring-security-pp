package com.cursos.springsecuritycourse.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column( name = "product_id", nullable = false)
    private UUID productId;


    @NotBlank
    @Column( name = "product_name", nullable = false)
    private String productName;

//    @NotBlank
//    @DecimalMin(value = "0.01")
    @Column( name = "product_price", nullable = false)
    private BigDecimal productPrice;

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
