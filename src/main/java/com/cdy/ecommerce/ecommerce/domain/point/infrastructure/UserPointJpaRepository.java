package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserPointJpaRepository extends JpaRepository<UserPoint, Long> {

    @Query("SELECT up FROM UserPoint up WHERE up.member.userId = ?1")
    Optional<UserPoint> findByUserId(@Param("userId") String userId);

    @Transactional
    @Modifying
    @Query("UPDATE UserPoint up SET up.point = :newPointsBalance WHERE up.member.userId = :userId")
    void updatePoint(@Param("userId") String userId, @Param("newPointsBalance") long newPointsBalance);

}

