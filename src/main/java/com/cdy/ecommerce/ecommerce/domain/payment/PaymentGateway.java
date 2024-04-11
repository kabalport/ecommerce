package com.cdy.ecommerce.ecommerce.domain.payment;

import com.cdy.ecommerce.ecommerce.domain.payment.business.Payment;

public interface PaymentGateway {
    void execute(Payment payment);
}