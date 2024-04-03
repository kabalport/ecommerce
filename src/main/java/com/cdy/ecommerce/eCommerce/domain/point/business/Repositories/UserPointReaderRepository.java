package com.cdy.ecommerce.eCommerce.domain.point.business.Repositories;

import com.cdy.ecommerce.eCommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.eCommerce.domain.point.infrastructure.UserPointJpaRepository;
import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserPointReaderRepository extends UserPointJpaRepository {
    @Query("select p from UserPoint p where p.id = :id")
    Optional<UserPoint> selectOne(@Param("id") Long id);
    @Query("select up from UserPoint up where up.memberId = :memberId")
    Optional<UserPoint> selectUserPoint(Long memberId);
}
