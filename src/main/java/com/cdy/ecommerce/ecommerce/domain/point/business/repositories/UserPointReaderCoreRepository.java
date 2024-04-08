package com.cdy.ecommerce.ecommerce.domain.point.business.repositories;

import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.repositories.IUserPointReaderRepository;
import com.cdy.ecommerce.ecommerce.domain.point.infrastructure.IUserPointJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserPointReaderCoreRepository implements IUserPointReaderRepository {
    private final com.cdy.ecommerce.ecommerce.domain.point.infrastructure.IUserPointJpaRepository IUserPointJpaRepository;

    @Override
    public Optional<UserPoint> selectUserPoint(String userId) {
        return IUserPointJpaRepository.findByUserId(userId);
    }
}
