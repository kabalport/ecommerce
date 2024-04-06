package com.cdy.ecommerce.ecommerce.domain.member.business.Components;

import com.cdy.ecommerce.ecommerce.domain.member.business.Repositories.MemberReaderRepository;
import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MemberReader {
    private final MemberReaderRepository memberReaderRepository;

    public Member read2(Long memberId) {
        Optional<Member> member = memberReaderRepository.selectOne(memberId);
        return member.orElseThrow(() -> new IllegalArgumentException("Member not found for id: " + memberId));
    }

    public Member read(String userId) {
        Optional<Member> member = memberReaderRepository.selectUserId(userId);
        return member.orElseThrow(() -> new IllegalArgumentException("Member not found for id: " + userId));
    }

}
