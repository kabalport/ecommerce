package com.cdy.ecommerce.ecommerce.domain.point.business.repositories;

import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPointHistory;
import com.cdy.ecommerce.ecommerce.domain.point.business.repositories.IUserPointChargerHistoryRepository;
import com.cdy.ecommerce.ecommerce.domain.point.infrastructure.IUserPointHistoryJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserPointChargerHistoryCoreRepository implements IUserPointChargerHistoryRepository {
    private final IUserPointHistoryJpaRepository userPointJpaHistoryRepository;

    @Override
    public void save(UserPointHistory userPointHistory) {
        userPointJpaHistoryRepository.save(userPointHistory);
    }
}
