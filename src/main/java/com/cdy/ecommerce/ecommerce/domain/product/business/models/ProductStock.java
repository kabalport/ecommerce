package com.cdy.ecommerce.ecommerce.domain.product.business.models;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.exception.StockException;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "ecommerce_product_stock")
@Getter
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_stock_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Long quantity;

    public ProductStock(){}

    public ProductStock(Product product, Long quantity){
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
