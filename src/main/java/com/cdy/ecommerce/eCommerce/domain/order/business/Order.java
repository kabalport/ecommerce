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
    @Column(name = "user_point_id")
    private Long id;

    // 고객 Id
    private Long memberId;

    // 주문날짜
    private LocalDate orderDate;

    // 제품과의 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    // 수량
    private Long quantity;

    // 주문상태를 Enum으로 관리하고 데이터베이스에는 String으로 저장
    @Enumerated(EnumType.STRING)
    @Column(length = 255) // 선택적으로 길이 제한 설정
    private OrderStatus status;
}
