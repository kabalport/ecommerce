package com.cdy.ecommerce.ecommerce.domain.account.business.repository;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;

public interface IAccountManagerRepository {
    Account save(Account account);
}
