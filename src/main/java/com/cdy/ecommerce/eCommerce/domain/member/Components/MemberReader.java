package com.cdy.ecommerce.eCommerce.domain.member.Components;

import com.cdy.ecommerce.eCommerce.domain.member.Models.Member;
import com.cdy.ecommerce.eCommerce.domain.member.infrastructure.MemberJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MemberReader {
    private MemberJpaRepository memberJpaRepository;
    public Member read(Long memberId) {
        Optional<Member> member = memberJpaRepository.selectOne(memberId);
        return member.orElseThrow(() -> new IllegalArgumentException("Member not found for id: " + memberId));
    }

}
