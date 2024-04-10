package com.cdy.ecommerce.ecommerce.domain.account.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionHistoryJpaRepository extends JpaRepository<AccountTransaction,Long> {

}
