package com.cdy.ecommerce.ecommerce.api.order.usecase;

import com.cdy.ecommerce.ecommerce.api.order.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderAndPayUseCase {

    public Long execute(OrderDTO.Request orderRequest, Long memberId) {
        return null;
    }
}
