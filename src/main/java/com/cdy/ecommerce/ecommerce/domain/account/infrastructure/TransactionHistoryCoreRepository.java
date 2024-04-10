package com.cdy.ecommerce.ecommerce.domain.account.infrastructure;


import com.cdy.ecommerce.ecommerce.domain.account.api.ITransactionHistoryRepository;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TransactionHistoryCoreRepository implements ITransactionHistoryRepository {
    private final ITransactionHistoryJpaRepository transactionHistoryJpaRepository;
    @Override
    public void save(Transaction transaction) {
        transactionHistoryJpaRepository.save(transaction);
    }
}
