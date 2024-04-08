package com.cdy.ecommerce.ecommerce.domain.point.business.components;

import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.repositories.IUserPointChargerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UserPointCharger {
    private final IUserPointChargerRepository userPointChargerRepository;

    public UserPoint charge(UserPoint userPoint) {
        return userPointChargerRepository.save(userPoint); // 변경된 userPoint 저장 및 반환
    }

}


