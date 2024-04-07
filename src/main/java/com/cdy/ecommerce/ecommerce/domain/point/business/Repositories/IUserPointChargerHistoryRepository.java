package com.cdy.ecommerce.ecommerce.domain.point.business.Repositories;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPointHistory;

public interface IUserPointChargerHistoryRepository {
    void save(UserPointHistory userPointHistory);
}
