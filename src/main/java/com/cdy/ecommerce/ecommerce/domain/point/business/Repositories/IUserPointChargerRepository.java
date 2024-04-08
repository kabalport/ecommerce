package com.cdy.ecommerce.ecommerce.domain.point.business.Repositories;

import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;

public interface IUserPointChargerRepository {
    void save(UserPoint userPoint);
}


