package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPoint;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserPointJpaRepository extends JpaRepository<UserPoint, Long> {

    @Query("SELECT up FROM UserPoint up WHERE up.member.userId = ?1")
    Optional<UserPoint> findByUserId(@Param("userId") String userId);

}

