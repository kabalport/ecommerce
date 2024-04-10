package com.cdy.ecommerce.ecommerce.domain.account.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.account.business.repository.IAccountReaderRepository;
import com.cdy.ecommerce.ecommerce.domain.account.infrastructure.IAccountJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AccountReaderCoreRepository implements IAccountReaderRepository {
    private IAccountJpaRepository accountJpaRepository;
    @Override
    public Optional<Account> findAccount(String userId) {
        return accountJpaRepository.findByUserId(userId);
    }
}
