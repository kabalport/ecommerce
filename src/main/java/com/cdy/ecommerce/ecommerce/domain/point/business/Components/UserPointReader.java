package com.cdy.ecommerce.ecommerce.domain.point.business.Components;

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
        Optional<UserPoint> result = userPointReaderRepository.selectUserPoint(memberId);
        UserPoint userPoint = result.orElseGet(() -> UserPoint.empty(memberId));
        return userPoint;
    }
}
