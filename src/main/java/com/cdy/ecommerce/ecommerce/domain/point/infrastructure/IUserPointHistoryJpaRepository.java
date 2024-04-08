package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;


import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPointHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserPointHistoryJpaRepository extends JpaRepository<UserPointHistory, Long> {
}
