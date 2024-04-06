package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class IUserPointChargerCoreRepository implements IUserPointChargerRepository {
    private final UserPointJpaRepository userPointJpaRepository;

    @Override
    public void save(UserPoint updatedUserPoint) {
        userPointJpaRepository.save(updatedUserPoint);
    }
}
