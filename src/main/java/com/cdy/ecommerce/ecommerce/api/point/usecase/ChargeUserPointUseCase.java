package com.cdy.ecommerce.ecommerce.api.point.usecase;

import com.cdy.ecommerce.ecommerce.api.point.dto.PointDTO;
import com.cdy.ecommerce.ecommerce.domain.point.business.Components.UserPointValidator;
import com.cdy.ecommerce.ecommerce.domain.point.exception.PointException;
import com.cdy.ecommerce.ecommerce.domain.point.business.Components.UserPointCharger;
import com.cdy.ecommerce.ecommerce.domain.point.business.Components.UserPointReader;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ChargeUserPointUseCase {
    private final UserPointReader userPointReader;
    private final UserPointCharger userPointCharger;
    private final UserPointValidator userPointValidator;

    public UserPoint execute(PointDTO.Request request) {
        // 유효성검증
        userPointValidator.validate(request.getAmount());
        // 포인트를 조회합니다.
        UserPoint pointInfo = userPointReader.read(request.getMemberId());
        // 요청포인트를 충전합니다.
        return userPointCharger.chargePoint(pointInfo,request.getAmount());
    }
}
