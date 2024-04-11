package com.cdy.ecommerce.ecommerce.domain.account.business.components;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.AccountError;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.AccountException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class AccountValidator {

    /**
     * 계좌 충전 시 유효성 검사를 수행합니다.
     * @param amount 충전 금액
     */
    public void validateChargeAmount(int amount) {
        if (amount > 0) {
            throw new AccountException(AccountError.CHARGE_AMOUNT_MUST_BE_POSITIVE.getMessage());

        }
    }

    /**
     * 계좌에서 상품 구매 시 유효성 검사를 수행합니다.
     * @param account 계좌
     * @param purchaseAmount 구매 금액
     */
    public void validatePurchase(Account account, int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new AccountException("구매 금액은 0보다 커야 합니다.");
        }
        if (account.getBalance() < 0) {
            throw new AccountException("잔액이 부족합니다.");
        }
    }
}
