package com.cdy.ecommerce;

import com.cdy.ecommerce.eCommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.eCommerce.domain.point.business.Repositories.UserPointChargerRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class PointRepositoryTests {
    @Autowired
    UserPointChargerRepository userPointChargerRepository;
    @Test
    public void testInsert() {

        for (int i = 0; i < 10; i++) {
            UserPoint userPoint = UserPoint.builder()
                    .memberId((long) i)
                    .point(1000L)
                    .build();

            userPointChargerRepository.save(userPoint);

            log.info("-------------------");
        }
    }
}
