package com.cdy.ecommerce.ecommerce.domain.point.business.Repositories;

import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;

public interface IUserPointChargerRepository {

    void updatePoint(String userId, long newPointsBalance);

//    void insertPoint(Member member, Long amount);
}


