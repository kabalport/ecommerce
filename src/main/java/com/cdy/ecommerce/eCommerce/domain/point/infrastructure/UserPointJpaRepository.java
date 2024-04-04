package com.cdy.ecommerce.eCommerce.domain.point.infrastructure;

import com.cdy.ecommerce.eCommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.eCommerce.domain.point.business.Repositories.UserPointReaderRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPointJpaRepository extends UserPointReaderRepository, JpaRepository<UserPoint, Long>  {
    @Override
    Optional<UserPoint> selectUserPoint(Long memberId);
}
