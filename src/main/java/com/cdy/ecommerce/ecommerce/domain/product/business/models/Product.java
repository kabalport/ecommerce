package com.cdy.ecommerce.ecommerce.domain.product.business.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ecommerce_product")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private BigDecimal price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductStock productStock;

    private boolean delFlag;

    public void changeName(String name){
        this.name = name;
    }
    public void changePrice(BigDecimal price) {
        this.price = price;
    }

}
