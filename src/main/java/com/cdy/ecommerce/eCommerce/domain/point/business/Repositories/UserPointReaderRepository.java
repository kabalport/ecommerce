package com.cdy.ecommerce.eCommerce.domain.point.business.Repositories;

import com.cdy.ecommerce.eCommerce.domain.point.business.Models.UserPoint;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserPointReaderRepository {
    @Query("select up from UserPoint up where up.memberId = :memberId")
    Optional<UserPoint> selectUserPoint(Long memberId);
}
