package com.cdy.ecommerce.ecommerce.api.point.usecase;

import com.cdy.ecommerce.ecommerce.api.point.dto.PointDTO;
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

    public UserPoint execute(PointDTO.Request request) {
        // 유효성검증
        if (request.getAmount() < 0) {
            throw new PointException("충전 포인트는 음수가 될 수 없습니다.");
        }
        // 포인트를 조회합니다.
        UserPoint pointInfo = userPointReader.read(request.getMemberId());
        // 요청포인트를 충전합니다.
        UserPoint userPoint = userPointCharger.chargePoint(pointInfo,request.getAmount());
        // 충전한 포인트를 반환합니다.
        return userPoint;
    }


}
