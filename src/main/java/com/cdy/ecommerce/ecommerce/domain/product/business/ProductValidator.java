package com.cdy.ecommerce.ecommerce.domain.product.business;

import com.cdy.ecommerce.ecommerce.domain.product.api.ProductAdminDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class ProductValidator {

    public void validateProductRequest(ProductAdminDTO.Request request) {
        if (request.getPrice() == null || request.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductException("가격은 null이 될 수 없고 0보다 커야 합니다.");
        }
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new ProductException("상품 이름은 비어있을 수 없습니다.");
        }
        if (request.getInitialStock() < 0) {
            throw new ProductException("초기 재고는 음수가 될 수 없습니다.");
        }
        if (request.getPrice().scale() > 2) {
            throw new ProductException("가격은 소수점 이하 두 자리까지만 입력할 수 있습니다.");
        }
    }
}

