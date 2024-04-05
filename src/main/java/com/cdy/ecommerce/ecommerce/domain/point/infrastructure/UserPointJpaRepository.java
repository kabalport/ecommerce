package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPointJpaRepository extends JpaRepository<UserPoint, Long> {
    // 예시: 특정 사용자 ID를 기준으로 사용자 포인트 조회
    @Query("SELECT up FROM UserPoint up WHERE up.memberId = ?1")
    Optional<UserPoint> findByMemberId(Long memberId);
}
