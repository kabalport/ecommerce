package com.cdy.ecommerce.ecommerce.domain.account.business.components;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class AccountValidator {

    /**
     * 계좌 충전 시 유효성 검사를 수행합니다.
     * @param amount 충전 금액
     */
    public void validateChargeAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new AccountException("충전 금액은 0보다 커야 합니다.");
        }
    }

    /**
     * 계좌에서 상품 구매 시 유효성 검사를 수행합니다.
     * @param account 계좌
     * @param purchaseAmount 구매 금액
     */
    public void validatePurchase(Account account, BigDecimal purchaseAmount) {
        if (purchaseAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new AccountException("구매 금액은 0보다 커야 합니다.");
        }
        if (account.getBalance().compareTo(purchaseAmount) < 0) {
            throw new AccountException("잔액이 부족합니다.");
        }
    }
}
