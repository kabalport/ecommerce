package com.cdy.ecommerce.ecommerce.domain.member;

import com.cdy.ecommerce.ecommerce.domain.member.business.Repositories.MemberReaderRepository;
import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import com.cdy.ecommerce.ecommerce.domain.member.business.Models.MemberRole;
import lombok.extern.log4j.Log4j2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Log4j2
public class MemberJpaRepositoryTests {

  @Autowired
  private MemberReaderRepository memberReaderRepository;


  @Test
  public void testInsertMember() {

    for (int i = 0; i < 10; i++) {

      Member member =
          Member.builder()
              .userId("user" + i)
              .pw("1111")
                  .nickname("nickname" + i)
              .build();

      member.addRole(MemberRole.USER);

      if (i >= 5) {
        member.addRole(MemberRole.MANAGER);
      }

      if (i >= 8) {
        member.addRole(MemberRole.ADMIN);
      }
      memberReaderRepository.save(member);
    }
  }

  @Test
  public void testRead() {

    Long firstUser = 1L;

    Member member = memberReaderRepository.getWithRoles(firstUser);

    log.info("-----------------");
    log.info(member);
  }
}
