package com.cdy.ecommerce.ecommerce.domain.point.business.components;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.UserPointChargerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UserPointCharger {
    private final UserPointChargerRepository userPointChargerRepository;

    public UserPoint chargePoint(UserPoint pointInfo, Long amount) {
        Long updatedPoints = pointInfo.getPoint() + amount;
        UserPoint updatedUserPoint = UserPoint.builder().memberId(pointInfo.getMemberId()).point(updatedPoints).build();
        userPointChargerRepository.save(updatedUserPoint);
        return updatedUserPoint;
    }
}
