package com.cdy.ecommerce.ecommerce.domain.product.business.components;

import com.cdy.ecommerce.ecommerce.api.order.dto.ProductOrderDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductOrderValidate {
    public void validate(ProductOrderDTO.Request request) {

    }
}
