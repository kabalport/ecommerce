package com.cdy.ecommerce.ecommerce.domain.order.component;

import com.cdy.ecommerce.ecommerce.api.order.dto.ProductOrderDTO;
import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import com.cdy.ecommerce.ecommerce.domain.order.IProductOrderRepository;
import com.cdy.ecommerce.ecommerce.domain.order.business.ProductOrder;
import com.cdy.ecommerce.ecommerce.domain.order.business.ProductOrderStatus;
import com.cdy.ecommerce.ecommerce.domain.point.business.repositories.IUserPointChargerRepository;
import com.cdy.ecommerce.ecommerce.domain.product.business.components.ProductReader;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ProductOrderManager {

    private final IProductOrderRepository productOrderRepository;
    private final ProductReader productReader; // 상품 정보 조회를 위한 컴포넌트

    public List<ProductOrder> createOrder(Member member, List<ProductOrderDTO.ProductOrderDetail> products, long totalAmount) {
        // 주문을 담을 리스트 생성
        List<ProductOrder> createdOrders = new ArrayList<>();

        // 각 상품에 대해 주문 엔티티 생성
        for (ProductOrderDTO.ProductOrderDetail detail : products) {
            // 상품 조회
            Product product = productReader.read(detail.getProductId());

            // 주문 엔티티 생성 및 초기화
            ProductOrder order = ProductOrder.builder()
                    .memberId(member.getMemberId()) // Member 엔티티 설계에 따라 변경 필요
                    .product(product)
                    .quantity(detail.getQuantity())
                    .orderDate(LocalDate.now())
                    .status(ProductOrderStatus.PENDING) // 예: 주문 상태 초기값 설정
                    .build();

            // 주문 저장
            createdOrders.add(productOrderRepository.save(order));
        }

        return createdOrders;
    }
}
