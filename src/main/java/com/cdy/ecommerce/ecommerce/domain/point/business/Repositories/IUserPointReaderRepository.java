package com.cdy.ecommerce.ecommerce.domain.point.business.Repositories;


import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;

import java.util.Optional;

public interface IUserPointReaderRepository {
    Optional<UserPoint> selectUserPoint(String userId);

}