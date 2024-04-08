package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.repositories.IUserPointReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserPointReaderCoreRepository implements IUserPointReaderRepository {
    private final IUserPointJpaRepository IUserPointJpaRepository;

    @Override
    public Optional<UserPoint> selectUserPoint(String userId) {
        return IUserPointJpaRepository.findByUserId(userId);
    }
}
