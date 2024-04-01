package com.cdy.ecommerce.eCommerce.domain.point.infrastructure;

import com.cdy.ecommerce.eCommerce.domain.point.business.Models.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPointJpaRepository extends JpaRepository<UserPoint, Long> {}
