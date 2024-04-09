package com.cdy.ecommerce.ecommerce.domain.payment.business;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PaymentManager {
    private final PaymentRepository paymentRepository;

    public Payment createPayment(ProductOrder order, BigDecimal amount, String paymentMethod) {
        Payment payment = Payment.builder()
                .order(order)
                .amount(amount)
                .paymentDateTime(LocalDateTime.now())
                .paymentMethod(paymentMethod)
                .status(PaymentStatus.SUCCESS) // 예시로 SUCCESS를 사용했습니다.
                .build();
        return paymentRepository.save(payment);
    }
}
