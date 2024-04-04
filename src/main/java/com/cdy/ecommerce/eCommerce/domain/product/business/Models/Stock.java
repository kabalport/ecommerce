package com.cdy.ecommerce.eCommerce.domain.product.business.Models;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "ecommerce_stock")
@Getter
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "stock_quantity")
    private Long quantity;

    public Stock(){}

    public Stock(Product product, Long quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public void decrease(Long quantity){
        if(this.quantity - quantity < 0){
            throw new RuntimeException("재고는 0개 미만이 될 수 없습니다.");
        }
        this.quantity -= quantity;
    }
}
