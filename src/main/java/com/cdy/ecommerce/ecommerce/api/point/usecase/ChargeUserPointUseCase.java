package com.cdy.ecommerce.ecommerce.api.point.usecase;

import com.cdy.ecommerce.ecommerce.api.point.dto.PointDTO;
import com.cdy.ecommerce.ecommerce.domain.member.business.Components.MemberReader;
import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.ChangeType;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPointHistory;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerRepository;
import com.cdy.ecommerce.ecommerce.domain.point.business.components.UserPointChargerHistory;
import com.cdy.ecommerce.ecommerce.domain.point.business.components.UserPointValidator;
import com.cdy.ecommerce.ecommerce.domain.point.business.components.UserPointCharger;
import com.cdy.ecommerce.ecommerce.domain.point.business.components.UserPointReader;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ChargeUserPointUseCase {
    private final MemberReader memberReader;
    private final UserPointValidator userPointValidator;
    private final UserPointReader userPointReader;
    private final UserPointCharger userPointCharger;

    private final UserPointChargerHistory userPointChargerHistory;

    /**
     * 포인트 충전기능
     * @param request
     * @return
     */
    public UserPoint execute(PointDTO.Request request) {
        // 유효성검증 - 요청포인트를 확인합니다.
        userPointValidator.validate(request.getAmount());
        // 유저 검증
        Member member = memberReader.read(request.getUserId());
        // 기존포인트를 조회합니다.
        UserPoint userPoint = userPointReader.read(request.getUserId());
        // 충전포인트계산 : 기존포인트와 요청포인트 더하기
        long chargePoint = userPoint.getPoint() + request.getAmount();
        // 요청포인트를 충전합니다.
        UserPoint chargeInfo = userPointCharger.charge(member,chargePoint);
        // 포인트 요청충전로그를 남깁니다.
        userPointChargerHistory.add(userPoint,request.getAmount());
        // 충전포인트 반환
        return chargeInfo;
    }
}
