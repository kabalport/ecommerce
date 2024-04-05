package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.UserPointReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserPointReaderCoreRepository implements UserPointReaderRepository {
    private final UserPointJpaRepository userPointJpaRepository;

    @Override
    public Optional<UserPoint> selectUserPoint(Long memberId) {
        return userPointJpaRepository.findByMemberId(memberId);
    }
}
