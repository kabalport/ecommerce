package com.cdy.ecommerce.ecommerce.domain.point.business.Repositories;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.infrastructure.UserPointJpaRepository;

public interface UserPointChargerRepository {
    void save(UserPoint updatedUserPoint);
}
