package com.cdy.ecommerce.ecommerce.domain.payment;

import com.cdy.ecommerce.ecommerce.domain.payment.business.Payment;

public class ConsolePaymentGateWay implements PaymentGateway{
    @Override
    public void execute(Payment payment) {
        System.out.println("결제완료");
    }
}
