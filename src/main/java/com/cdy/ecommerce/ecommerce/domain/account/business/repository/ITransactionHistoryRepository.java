package com.cdy.ecommerce.ecommerce.domain.account.business.repository;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.AccountTransaction;

public interface ITransactionHistoryRepository {
    void save(AccountTransaction accountTransaction);
}
