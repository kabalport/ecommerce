package com.cdy.ecommerce.ecommerce.domain.point.business.components;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.ChangeType;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPointHistory;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerHistoryRepository;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
@AllArgsConstructor
public class UserPointChargerHistory {

    private final IUserPointChargerHistoryRepository iUserPointChargerHistoryRepository;

    public void add(UserPoint userPoint, Long point) {
        UserPointHistory userPointHistory = UserPointHistory
                .builder()
                .userPoint(userPoint)
                .changeAmount(point)
                .changeType(ChangeType.CHARGE)
                .changeTime(LocalDateTime.now())
                .build();
        iUserPointChargerHistoryRepository.save(userPointHistory);
    }
}
