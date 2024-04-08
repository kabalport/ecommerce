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
     * 포인트 충전 기능
     * @param request 충전 요청 정보
     * @return 충전된 사용자 포인트 정보
     */
    public UserPoint execute(PointDTO.Request request) {
        // 유효성 검증 - 요청 포인트를 확인합니다.
        userPointValidator.validate(request.getAmount());

        // 유저 조회
        Member member = memberReader.read(request.getUserId());
        // 기존 포인트 조회
        UserPoint userPoint = userPointReader.read(member);

        // 충전 포인트 계산: 기존 포인트와 요청 포인트를 더합니다.
        userPoint.addPoints(request.getAmount());
        // 충전 처리: 새로 계산된 충전 포인트를 반영합니다.
        UserPoint chargedUserPoint = userPointCharger.charge(userPoint);

        // 포인트 충전 로그를 남깁니다.
        userPointChargerHistory.add(chargedUserPoint, request.getAmount());

        // 충전된 포인트 정보를 반환합니다.
        return chargedUserPoint;
    }
}

