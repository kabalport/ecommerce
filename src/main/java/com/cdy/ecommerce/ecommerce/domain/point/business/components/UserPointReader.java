package com.cdy.ecommerce.ecommerce.domain.point.business.components;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.UserPointReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserPointReader {
    private final UserPointReaderRepository userPointReaderRepository;

    public UserPoint read(Long memberId) {
        // 유저포인트 조회
        Optional<UserPoint> result = userPointReaderRepository.selectUserPoint(memberId);
        // 유저포인트 결과가져오기. 없으면 유저포인트 0원 가져오기
        return result.orElseGet(() -> UserPoint.empty(memberId));
    }
}
