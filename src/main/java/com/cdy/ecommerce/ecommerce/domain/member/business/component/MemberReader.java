package com.cdy.ecommerce.ecommerce.domain.member.business.component;

import com.cdy.ecommerce.ecommerce.domain.member.business.model.exception.MemberException;
import com.cdy.ecommerce.ecommerce.domain.member.business.repository.MemberReaderRepository;
import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MemberReader {
    private final MemberReaderRepository memberReaderRepository;

    public Member read(String userId) {
        Optional<Member> member = memberReaderRepository.selectUserId(userId);
        return member.orElseThrow(() -> new MemberException("회원정보가 없습니다. 요청한아이디: " + userId));
    }

}
