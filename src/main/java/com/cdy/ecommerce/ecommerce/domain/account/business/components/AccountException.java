package com.cdy.ecommerce.ecommerce.domain.account.business.components;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AccountException extends RuntimeException {
    public AccountException(String message) {
        super(message);
    }
}
