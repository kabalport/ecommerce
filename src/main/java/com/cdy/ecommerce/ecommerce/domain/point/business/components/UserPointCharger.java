package com.cdy.ecommerce.ecommerce.domain.point.business.components;

import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerRepository;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@AllArgsConstructor
public class UserPointCharger {
    private final IUserPointChargerRepository userPointChargerRepository;

    public UserPoint charge(UserPoint userPoint) {
        return userPointChargerRepository.save(userPoint); // 변경된 userPoint 저장 및 반환
    }

}


