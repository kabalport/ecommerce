package com.cdy.ecommerce.ecommerce.domain.point.business.Repositories;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.infrastructure.UserPointJpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserPointReaderRepository extends UserPointJpaRepository {
    @Query("select up from UserPoint up where up.memberId = :memberId")
    Optional<UserPoint> selectUserPoint(Long memberId);
}
