package com.cdy.ecommerce.ecommerce.domain.account.business.components;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.account.business.repository.IAccountReaderRepository;
import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AccountReader {
    private final IAccountReaderRepository accountReaderRepository;

    public Account read(Member member){
        // 유저 잔금 조회
        Optional<Account> result = accountReaderRepository.findAccount(member.getUserId());
        // 유저의 잔금 결과 가져오기. 없으면 잔금을 0으로 반환하기
        return result.orElseGet(() -> Account.empty(member));
    }
}
