package com.cdy.ecommerce;

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
    IUserPointChargerRepository IUserPointChargerRepository;
    @Test
    public void testInsert() {

        for (int i = 0; i < 10; i++) {
            UserPoint userPoint = UserPoint.builder()
                    .memberId((long) i)
                    .point(1000L)
                    .build();

            IUserPointChargerRepository.save(userPoint);

            log.info("-------------------");
        }
    }
}
