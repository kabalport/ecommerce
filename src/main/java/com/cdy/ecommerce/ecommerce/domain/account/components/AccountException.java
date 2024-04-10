package com.cdy.ecommerce.ecommerce.domain.account.components;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST) // 필요에 따라 적절한 HTTP 상태 코드 지정
public class AccountException extends RuntimeException {
    public AccountException(String message) {
        super(message);
    }
}
