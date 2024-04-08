package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.repositories.IUserPointChargerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserPointChargerCoreRepository implements IUserPointChargerRepository {
    private final IUserPointJpaRepository IUserPointJpaRepository;

    @Override
    public UserPoint save(UserPoint userPoint) {
        return IUserPointJpaRepository.save(userPoint);
    }

}
