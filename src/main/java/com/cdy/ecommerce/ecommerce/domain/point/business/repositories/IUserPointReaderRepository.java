package com.cdy.ecommerce.ecommerce.domain.point.business.repositories;


import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPoint;

import java.util.Optional;

public interface IUserPointReaderRepository {
    Optional<UserPoint> selectUserPoint(String userId);

}
