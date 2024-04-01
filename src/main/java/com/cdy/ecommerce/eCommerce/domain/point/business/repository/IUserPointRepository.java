package com.cdy.ecommerce.eCommerce.domain.point.business.repository;

import net.dodoinfo.sbserver.domain.eCommerce.domain.point.business.entity.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserPointRepository extends JpaRepository<UserPoint, Long> {
}
