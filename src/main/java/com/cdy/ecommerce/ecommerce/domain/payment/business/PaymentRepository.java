package com.cdy.ecommerce.ecommerce.domain.payment.business;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
