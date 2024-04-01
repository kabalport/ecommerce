package com.cdy.ecommerce.eCommerce.api.point.usecase;

import com.cdy.ecommerce.eCommerce.api.point.dto.PointDTO;
import com.cdy.ecommerce.eCommerce.domain.point.business.Components.PointReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GetUserPointUseCase {
    private final PointReader pointReader;

    /**
     * 포인트 조회기능
     * @param memberId
     * @return
     */
    public PointDTO.Response execute(long memberId) {
        // 포인트를 조회합니다.
        PointDTO.Response userPoint = pointReader.read(memberId);
        // 조회한 포인트를 반환합니다.
        return userPoint;
    }
}
