package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class IUserPointChargerCoreRepository implements IUserPointChargerRepository {
    private final UserPointJpaRepository userPointJpaRepository;


    @Override
    public void updatePoint(String userId, long newPointsBalance) {
        userPointJpaRepository.updatePoint(userId, newPointsBalance);
    }

//    @Override
//    public void insertPoint(Member member, Long amount) {
//        UserPoint userPoint = UserPoint.builder().build();
//        userPointJpaRepository.save(userPoint);
//    }
}
