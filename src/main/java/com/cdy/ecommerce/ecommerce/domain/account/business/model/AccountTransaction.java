package com.cdy.ecommerce.ecommerce.domain.account.business.model;

import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 거래정보
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account account;

    private LocalDateTime transactionTime;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private AccountTransactionType accountTransactionType;

    @ManyToOne
    private Product product;

}
