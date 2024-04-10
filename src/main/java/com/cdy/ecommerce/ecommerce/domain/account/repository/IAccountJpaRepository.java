package com.cdy.ecommerce.ecommerce.domain.account.repository;

import com.cdy.ecommerce.ecommerce.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IAccountJpaRepository extends JpaRepository<Account, Long> {
    @Query("SELECT ac FROM Account ac WHERE ac.member.userId = ?1")
    Optional<Account> findByUserId(String userId);

}
