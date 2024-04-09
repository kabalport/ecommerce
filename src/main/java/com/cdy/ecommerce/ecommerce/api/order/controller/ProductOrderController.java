package com.cdy.ecommerce.ecommerce.api.order.controller;

import com.cdy.ecommerce.ecommerce.api.order.dto.ProductOrderDTO;
import com.cdy.ecommerce.ecommerce.api.order.dto.ProductOrderDTO.Response;
import com.cdy.ecommerce.ecommerce.api.order.dto.ProductOrderDTO.OrderItem;
import com.cdy.ecommerce.ecommerce.api.order.usecase.ProductOrderAndPayUseCase;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/order")
public class ProductOrderController {
    private final ProductOrderAndPayUseCase productOrderAndPayUseCase;

    @PostMapping
    public Response order(@RequestBody ProductOrderDTO.Request request) {
        ProductOrder response = productOrderAndPayUseCase.execute(request);

        return entityToDTO(response);
    }

    private Response entityToDTO(ProductOrder productOrder) {
        List<OrderItem> items = productOrder.getItems().stream()
                .map(item -> OrderItem.builder()
                        .productId(item.getProduct().getId())
                        .quantity(item.getQuantity())
                        .price(BigDecimal.valueOf(item.getPrice()))
                        .build())
                .collect(Collectors.toList());

        return Response.builder()
                .orderId(productOrder.getId())
                .status(productOrder.getStatus().name())
                .items(items)
                .totalAmount(calculateTotalAmount(items))
                .build();
    }

    private BigDecimal calculateTotalAmount(List<OrderItem> items) {
        return items.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
