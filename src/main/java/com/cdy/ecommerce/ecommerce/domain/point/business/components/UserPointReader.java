package com.cdy.ecommerce.ecommerce.domain.point.business.components;

import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.repositories.IUserPointReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserPointReader {
    private final IUserPointReaderRepository IUserPointReaderRepository;

    public UserPoint read(Member member) {
        // 유저포인트 조회
        Optional<UserPoint> result = IUserPointReaderRepository.selectUserPoint(member.getUserId());
        // 유저포인트 결과가져오기. 없으면 유저포인트 0원 가져오기
        return result.orElseGet(() -> new UserPoint(member,0L));
    }
}
