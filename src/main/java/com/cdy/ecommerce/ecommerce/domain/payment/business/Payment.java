package com.cdy.ecommerce.ecommerce.domain.payment.business;

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
    @Column(name = "ecommerce_payment_id")
    private Long id;

    // 사용자 Id
    @Column(name = "member_id")
    private Long memberId;

    // 결제 금액
    @Column(name = "ecommerce_payment_paymentMoney")
    private Long paymentMoney;

    // 결제 날짜와 시간
    @Column(name = "ecommerce_payment_date_time")
    private LocalDateTime paymentDateTime;

    // 결제 상태
    @Enumerated(EnumType.STRING)
    @Column(name = "ecommerce_payment_status")
    private PaymentStatus status;
}

