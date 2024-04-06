package com.cdy.ecommerce.ecommerce.api.point.usecase;

import com.cdy.ecommerce.ecommerce.api.point.dto.PointDTO;
import com.cdy.ecommerce.ecommerce.domain.member.business.Components.MemberReader;
import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerRepository;
import com.cdy.ecommerce.ecommerce.domain.point.business.components.UserPointValidator;
import com.cdy.ecommerce.ecommerce.domain.point.business.components.UserPointCharger;
import com.cdy.ecommerce.ecommerce.domain.point.business.components.UserPointReader;
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

    private final com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerRepository IUserPointChargerRepository;
    private final MemberReader memberReader;
    public UserPoint execute(PointDTO.Request request) {
        // 유저 검증
        Member member = memberReader.read(request.getUserId());
        // 유효성검증
        userPointValidator.validate(request.getAmount());

        // 포인트를 조회합니다.
        UserPoint pointInfo = userPointReader.read(request.getUserId());

        // 요청포인트를 충전합니다.
        Long updatedPoints = pointInfo.getPoint() + request.getAmount();

        UserPoint updatedUserPoint = UserPoint.builder().member(member).point(updatedPoints.longValue()).build();
        System.out.println(updatedUserPoint);
        System.out.println(updatedUserPoint.getMember());
        System.out.println(updatedUserPoint.getPoint());

        IUserPointChargerRepository.save(updatedUserPoint);

//        return updatedUserPoint;

        return UserPoint.empty();
    }
}
