package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class IUserPointReaderCoreRepository implements IUserPointReaderRepository {
    private final UserPointJpaRepository userPointJpaRepository;

    @Override
    public Optional<UserPoint> selectUserPoint(String userId) {
        return userPointJpaRepository.findByUserId(userId);
    }
}
