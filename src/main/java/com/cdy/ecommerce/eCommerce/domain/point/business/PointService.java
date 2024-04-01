package com.cdy.ecommerce.eCommerce.domain.point.business;



import net.dodoinfo.sbserver.domain.eCommerce.api.point.UserPointResponse;
import net.dodoinfo.sbserver.domain.eCommerce.domain.point.business.entity.PointHistory;
import net.dodoinfo.sbserver.domain.eCommerce.domain.point.business.entity.UserPoint;

import java.util.List;
import java.util.Optional;

public interface PointService {
    Optional<UserPoint> getPointById(long userId);
    List<PointHistory> getHistoriesByUserId(long userId);
    UserPoint chargePoint(long userId, long amount);
    UserPoint usePoint(long id, long amount);

    UserPointResponse getUserPointInfo(long userId);
}