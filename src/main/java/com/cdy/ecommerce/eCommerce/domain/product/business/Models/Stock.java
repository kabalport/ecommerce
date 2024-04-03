package com.cdy.ecommerce.eCommerce.domain.product.business.Models;


import jakarta.persistence.*;
@Table(name = "ecommerce_stock")

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Long id;

    private Long productId;

    private Long quantity;

    public Stock(){
    }

    public Stock(Long productId, Long quantity){
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getQuantity(){
        return quantity;
    }

    public void decrease(Long quantity){
        if(this.quantity - quantity < 0){
            throw new RuntimeException("재고는 0개 미만이 될 수 없습니다.");
        }
        this.quantity -= quantity;
    }

}
