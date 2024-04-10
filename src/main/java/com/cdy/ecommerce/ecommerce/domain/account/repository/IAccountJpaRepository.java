package com.cdy.ecommerce.ecommerce.domain.account.repository;

import com.cdy.ecommerce.ecommerce.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountJpaRepository extends JpaRepository<Account, Long> {

}
