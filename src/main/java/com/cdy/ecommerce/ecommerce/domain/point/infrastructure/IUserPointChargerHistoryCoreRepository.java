package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPointHistory;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerHistoryRepository;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class IUserPointChargerHistoryCoreRepository  implements IUserPointChargerHistoryRepository {
    private final UserPointHistoryJpaRepository userPointJpaHistoryRepository;

    @Override
    public void save(UserPointHistory userPointHistory) {
        userPointJpaHistoryRepository.save(userPointHistory);
    }
}
