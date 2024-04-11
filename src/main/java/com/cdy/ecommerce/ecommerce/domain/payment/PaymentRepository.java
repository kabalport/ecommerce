package com.cdy.ecommerce.ecommerce.domain.payment;

import com.cdy.ecommerce.ecommerce.domain.payment.business.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
