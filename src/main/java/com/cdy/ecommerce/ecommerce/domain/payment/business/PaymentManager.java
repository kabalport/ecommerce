package com.cdy.ecommerce.ecommerce.domain.payment.business;

import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrder;
import com.cdy.ecommerce.ecommerce.domain.payment.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PaymentManager {
    private final PaymentRepository paymentRepository;

    public Payment createPayment(ProductOrder order, int amount, String paymentMethod) {
        Payment payment = Payment.builder()
                .order(order)
                .amount(amount)
                .paymentDateTime(LocalDateTime.now())
                .paymentMethod(paymentMethod)
                .status(PaymentStatus.SUCCESS)
                .build();
        return paymentRepository.save(payment);
    }
}