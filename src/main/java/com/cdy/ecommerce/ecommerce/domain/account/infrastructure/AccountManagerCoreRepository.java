package com.cdy.ecommerce.ecommerce.domain.account.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.account.business.repository.IAccountManagerRepository;
import com.cdy.ecommerce.ecommerce.domain.account.infrastructure.IAccountJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AccountManagerCoreRepository implements IAccountManagerRepository {
    private IAccountJpaRepository accountJpaRepository;

    @Override
    public Account save(Account account) {
        return accountJpaRepository.save(account);
    }
}
