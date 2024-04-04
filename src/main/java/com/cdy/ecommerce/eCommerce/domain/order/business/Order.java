package com.cdy.ecommerce.eCommerce.domain.order.business;

import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "ecommerce_order")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ecommerce_order_id")
    private Long id;

    // 고객 Id
    @Column(name = "member_id")
    private Long memberId;

    // 주문날짜
    @Column(name = "ecommerce_order_date")
    private LocalDate orderDate;

    // 제품과의 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    // 수량
    @Column(name = "ecommerce_quantity")
    private int quantity;


    @Enumerated(EnumType.STRING)
    @Column(length = 255)
    private OrderStatus status;
}
