package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;


import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPointHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPointHistoryJpaRepository extends JpaRepository<UserPointHistory, Long> {
}
