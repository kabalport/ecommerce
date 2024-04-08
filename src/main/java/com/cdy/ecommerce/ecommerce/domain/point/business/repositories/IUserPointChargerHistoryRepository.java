package com.cdy.ecommerce.ecommerce.domain.point.business.repositories;

import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPointHistory;

public interface IUserPointChargerHistoryRepository {
    void save(UserPointHistory userPointHistory);
}
