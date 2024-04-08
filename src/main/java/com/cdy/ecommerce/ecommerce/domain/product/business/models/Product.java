package com.cdy.ecommerce.ecommerce.domain.product.business.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ecommerce_product")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * 상품
 * 상품정보
 * 상품옵션
 * 상품재고
 */
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
    private ProductStock productStock;

    private boolean delFlag;

    public void changeName(String name){
        this.name = name;
    }
    public void changePrice(int price) {
        this.price = price;
    }

}
