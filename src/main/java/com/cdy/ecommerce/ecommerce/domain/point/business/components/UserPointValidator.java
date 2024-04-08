package com.cdy.ecommerce.ecommerce.domain.point.business.components;

import com.cdy.ecommerce.ecommerce.domain.point.business.model.exception.PointException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserPointValidator {
    public void validate(Long amount) {
        if (amount < 0) {
            throw new PointException("충전 포인트는 음수가 될 수 없습니다.");
        }
    }
}
