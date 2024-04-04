package com.cdy.ecommerce.ecommerce.domain.product.business.models;

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

    private Long quantity;

    public Stock(){}

    public Stock(Product product, Long quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public void decrease(Long quantity){
        if(this.quantity - quantity < 0){
            throw new StockException("재고는 0개 미만이 될 수 없습니다.");
        }
        this.quantity -= quantity;
    }
}
