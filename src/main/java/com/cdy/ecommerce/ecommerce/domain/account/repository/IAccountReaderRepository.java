package com.cdy.ecommerce.ecommerce.domain.account.repository;

import com.cdy.ecommerce.ecommerce.domain.account.Account;

import java.util.Optional;

public interface IAccountReaderRepository {
    Optional<Account> findAccount(String userId);
}
