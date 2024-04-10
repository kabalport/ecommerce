package com.cdy.ecommerce.ecommerce.domain.account.business.repository;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;

import java.util.Optional;

public interface IAccountReaderRepository {
    Optional<Account> findAccount(String userId);
}
