package com.cdy.ecommerce.usecase.legacy.springbootTest.point;

import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import com.cdy.ecommerce.ecommerce.domain.member.business.repository.MemberReaderRepository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class PointRepositoryTests {

    @Autowired
    private MemberReaderRepository memberReaderRepository; // Member 조회를 위한 Repository

    @Test
    public void testInsert() {

        Member member = memberReaderRepository.selectOne(1L).orElseThrow();
            log.info("-------------------");

    }
}
