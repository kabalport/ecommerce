package com.cdy.ecommerce.ecommerce.api.account;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Transaction;

public interface ITransactionHistoryRepository {
    void save(Transaction transaction);
}