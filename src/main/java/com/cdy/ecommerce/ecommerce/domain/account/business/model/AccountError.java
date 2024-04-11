package com.cdy.ecommerce.ecommerce.domain.account.business.model;

public enum AccountError {
    CHARGE_AMOUNT_MUST_BE_POSITIVE("충전 금액은 0보다 커야 합니다."),
    BALANCE_CANNOT_BE_NEGATIVE("잔액은 음수가 될 수 없습니다.");
    // 여기에 필요한 다른 에러 메시지를 계속 추가할 수 있습니다.

    private final String message;

    AccountError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
