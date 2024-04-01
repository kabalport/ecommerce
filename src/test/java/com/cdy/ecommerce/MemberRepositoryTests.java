package com.cdy.ecommerce;

import com.cdy.ecommerce.eCommerce.domain.member.Member;
import com.cdy.ecommerce.eCommerce.domain.member.MemberRepository;
import com.cdy.ecommerce.eCommerce.domain.member.MemberRole;
import lombok.extern.log4j.Log4j2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Log4j2
public class MemberRepositoryTests {

  @Autowired private MemberRepository memberRepository;


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
      memberRepository.save(member);
    }
  }

  @Test
  public void testRead() {

    String email = "user9@aaa.com";

    Member member = memberRepository.getWithRoles(email);

    log.info("-----------------");
    log.info(member);
  }
}
