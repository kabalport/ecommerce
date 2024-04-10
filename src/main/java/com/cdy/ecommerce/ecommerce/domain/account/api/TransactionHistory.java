package com.cdy.ecommerce.ecommerce.domain.account.api;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.Transaction;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class TransactionHistory {
    private final ITransactionHistoryRepository transactionHistoryRepository;

    public void add(Account account, BigDecimal amount){
        Transaction transaction = Transaction
                .builder()
                .account(account)
                .amount(amount)
                .transactionType(TransactionType.CHARGE)
                .transactionTime(LocalDateTime.now())
                .build();
        transactionHistoryRepository.save(transaction);

    }
}
