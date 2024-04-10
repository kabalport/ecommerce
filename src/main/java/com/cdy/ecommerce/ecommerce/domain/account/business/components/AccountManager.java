package com.cdy.ecommerce.ecommerce.domain.account.business.components;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.account.business.repository.IAccountManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountManager {
    private final IAccountManagerRepository accountManagerRepository;

    public Account charge(Account account){
        return accountManagerRepository.save(account);
    }
}