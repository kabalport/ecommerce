package com.cdy.ecommerce.ecommerce.domain.account.repository;

import com.cdy.ecommerce.ecommerce.domain.account.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AccountReaderCoreRepository implements IAccountReaderRepository{
    @Override
    public Optional<Account> findAccount(String userId) {
        return Optional.empty();
    }
}
