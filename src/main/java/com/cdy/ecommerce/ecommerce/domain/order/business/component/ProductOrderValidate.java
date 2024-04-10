package com.cdy.ecommerce.ecommerce.domain.order.business.component;

import com.cdy.ecommerce.ecommerce.api.v1.order.controller.ProductOrderDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductOrderValidate {
    public void validate(ProductOrderDTO.Request request) {

    }
}
