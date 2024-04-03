package com.cdy.ecommerce.eCommerce.api.point.usecase;

import com.cdy.ecommerce.eCommerce.api.point.dto.PointDTO;
import com.cdy.ecommerce.eCommerce.domain.point.business.Components.UserPointCharger;
import com.cdy.ecommerce.eCommerce.domain.point.business.Models.UserPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ChargeUserPointUseCase {
    private final UserPointCharger userPointCharger;

    public UserPoint execute2(PointDTO.Request request) {
        // 포인트를 충전합니다.
        // 포인트를 조회합니다.
        // 반환된 포인트를 요청포인트와 더합니다.
        UserPoint userPoint = userPointCharger.charge2(request);
        // 충전포인트를 업데이트합니다.

        // 충전한 포인트를 반환합니다.
        return userPoint;

    }

    public PointDTO.Response execute(long memberId, PointDTO.Request request) {
        // 포인트를 충전합니다.
        PointDTO.Response userPoint = userPointCharger.charge(memberId,request);
        // 포인트를 조회합니다.

        // 반환된 포인트를 요청포인트와 더합니다.

        // 충전포인트를 업데이트합니다.

        // 충전한 포인트를 반환합니다.
        return userPoint;

    }
}
