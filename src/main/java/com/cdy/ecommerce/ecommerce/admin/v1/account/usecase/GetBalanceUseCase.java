package com.cdy.ecommerce.ecommerce.admin.v1.account.usecase;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountReader;
import com.cdy.ecommerce.ecommerce.domain.member.business.component.MemberReader;
import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetBalanceUseCase {
    private final AccountReader accountReader;
    private final MemberReader memberReader;

    /**
     * 잔액 조회기능
     * @param userId
     * @return
     */
    public Account execute(String userId) {
        // 유저 검증
        Member member = memberReader.read(userId);
        // 기존포인트를 조회합니다.
        return accountReader.read(member);
    }
}
