package com.cdy.ecommerce.ecommerce.domain.point.business.repositories;

import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.infrastructure.IUserPointJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserPointChargerCoreRepository implements IUserPointChargerRepository {
    private final IUserPointJpaRepository userPointJpaRepository;

    @Override
    public UserPoint save(UserPoint userPoint) {
        return userPointJpaRepository.save(userPoint);
    }

}
