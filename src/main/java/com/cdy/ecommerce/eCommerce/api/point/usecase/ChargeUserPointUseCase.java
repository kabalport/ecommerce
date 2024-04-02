package com.cdy.ecommerce.eCommerce.api.point.usecase;

import com.cdy.ecommerce.eCommerce.api.point.dto.PointDTO;
import com.cdy.ecommerce.eCommerce.domain.point.business.Components.UserPointCharger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ChargeUserPointUseCase {
    private final UserPointCharger userPointCharger;

    public PointDTO.Response execute(long memberId, PointDTO.Request request) {
        // 포인트를 충전합니다.
        PointDTO.Response userPoint = userPointCharger.charge(memberId,request);
        // 충전한 포인트를 반환합니다.
        return userPoint;

    }
}
