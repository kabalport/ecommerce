package com.cdy.ecommerce.ecommerce.api.account;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountManager;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountReader;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountValidator;
import com.cdy.ecommerce.ecommerce.domain.member.business.component.MemberReader;
import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChargeBalanceUseCase {
    private final AccountValidator accountValidator;
    private final MemberReader memberReader;
    private final AccountReader accountReader;
    private final AccountManager accountManager;

    private final TransactionHistory transactionHistory;

    /**
     * 잔액 충전 기능
     * @param request 충전 요청 정보
     * @return 충전된 사용자 잔액 정보
     */
    public Account execute(AccountDTO.Request request) {
        // 유효성 검증 - 충전금액를 확인합니다.
        accountValidator.validateChargeAmount(request.getBalance());
        // 유저 조회
        Member member = memberReader.read(request.getUserId());
        // 잔액 조회
        Account account = accountReader.read(member);

        // 충전 잔액 계산 : 기존 잔액에 충전금을 더합니다.
        account.charge(request.getBalance());
        // 충전 처리 : 새로 계산된 충전금을 반영합니다.
        Account chargedBalance = accountManager.charge(account);
        // 잔액 충전 로그를 남깁니다.
        transactionHistory.add(chargedBalance,request.getBalance());
        // 충전된 잔액 정보를 반환합니다.
        return null;
    }
}
