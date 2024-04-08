package com.cdy.ecommerce.ecommerce.domain.point.business.components;

import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UserPointCharger {
    private final IUserPointChargerRepository userPointChargerRepository;

    public UserPoint charge(Member member, Long amount) {
        System.out.println("---");
        System.out.println(member.getUserId());
        System.out.println("---");
        System.out.println(amount);
        System.out.println("000");
        UserPoint userPoint = UserPoint.builder()
                .member(member)
                .point(amount)
                .build();

        userPointChargerRepository.save(userPoint);
        return UserPoint.builder().point(amount).build();
    }
}
