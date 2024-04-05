package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.UserPointChargerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserPointChargerCoreRepository implements UserPointChargerRepository {
    private final UserPointJpaRepository userPointJpaRepository;

    @Override
    public void save(UserPoint updatedUserPoint) {
        userPointJpaRepository.save(updatedUserPoint);
    }
}
