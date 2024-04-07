package com.cdy.ecommerce.ecommerce.api.point.usecase;

import com.cdy.ecommerce.ecommerce.domain.member.business.Components.MemberReader;
import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import com.cdy.ecommerce.ecommerce.domain.point.business.components.UserPointReader;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GetUserPointUseCase {
    private final UserPointReader userPointReader;

    private final MemberReader memberReader;

    /**
     * 포인트 조회기능
     * @param userId
     * @return
     */
    public UserPoint execute(String userId) {
        // 유저 검증
        Member member = memberReader.read(userId);
        // 기존포인트를 조회합니다.
        return userPointReader.read(member.getUserId());
    }
}
