package com.cdy.ecommerce.eCommerce.domain.payment.business;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ecommerce_payment")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사용자 Id
    private Long memberId;

    // 결제 금액
    private Long amount;

    // 결제 날짜와 시간
    private LocalDateTime paymentDateTime;

    // 결제 상태
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
}

