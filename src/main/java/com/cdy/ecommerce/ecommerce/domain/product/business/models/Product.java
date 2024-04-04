package com.cdy.ecommerce.ecommerce.domain.product.business.models;

import jakarta.persistence.*;
import lombok.*;

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
    private int price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Stock stock;

    private boolean delFlag;

    public void changeName(String name){
        this.name = name;
    }
    public void changePrice(int price) {
        this.price = price;
    }

}
