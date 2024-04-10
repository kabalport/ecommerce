package com.cdy.ecommerce.ecommerce.domain.account.business.components;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.AccountTransaction;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.AccountTransactionType;
import com.cdy.ecommerce.ecommerce.domain.account.business.repository.ITransactionHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class AccountTransactionManager {
    private final ITransactionHistoryRepository transactionHistoryRepository;

    public void add(Account account, BigDecimal amount){
        AccountTransaction transaction = AccountTransaction
                .builder()
                .account(account)
                .amount(amount)
                .accountTransactionType(AccountTransactionType.CHARGE)
                .transactionTime(LocalDateTime.now())
                .build();
        transactionHistoryRepository.save(transaction);

    }
}
