package com.cdy.ecommerce.ecommerce.domain.point.business.components;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UserPointCharger {
    private final IUserPointChargerRepository IUserPointChargerRepository;

    public UserPoint chargePoint(UserPoint pointInfo, Long amount) {
        Long updatedPoints = pointInfo.getPoint() + amount;

        UserPoint updatedUserPoint = UserPoint.builder().member(pointInfo.getMember()).point(updatedPoints.longValue()).build();
        IUserPointChargerRepository.save(updatedUserPoint);
        return updatedUserPoint;
    }
}
