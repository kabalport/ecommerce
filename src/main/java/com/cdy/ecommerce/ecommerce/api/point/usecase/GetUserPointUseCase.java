package com.cdy.ecommerce.ecommerce.api.point.usecase;

import com.cdy.ecommerce.ecommerce.domain.point.business.Components.UserPointReader;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GetUserPointUseCase {
    private final UserPointReader userPointReader;

    /**
     * 포인트 조회기능
     * @param memberId
     * @return
     */
    public UserPoint execute(Long memberId) {
        // 포인트를 조회합니다.
        return userPointReader.read(memberId);
    }
}
