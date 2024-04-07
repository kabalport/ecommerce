package com.cdy.ecommerce;

import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import com.cdy.ecommerce.ecommerce.domain.member.business.Repositories.MemberReaderRepository;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.IUserPointChargerRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class PointRepositoryTests {
    @Autowired
    private IUserPointChargerRepository iUserPointChargerRepository;

    @Autowired
    private MemberReaderRepository memberReaderRepository; // Member 조회를 위한 Repository

    @Test
    public void testInsert() {

        // 가정: Member 객체가 이미 데이터베이스에 존재한다고 가정
        // 여기서는 간단히 첫 번째 Member를 가져오는 것으로 가정합니다.
        // 실제로는 특정 조건에 맞는 Member를 조회하는 로직이 필요할 수 있습니다.
        Member member = memberReaderRepository.selectOne(1L).orElseThrow();

            UserPoint userPoint = UserPoint.builder()
                    .member(member) // UserPoint 생성 시 Member 객체 설정
                    .point(1000L)
                    .build();

//            iUserPointChargerRepository.save(userPoint);
            log.info("-------------------");

    }
}
