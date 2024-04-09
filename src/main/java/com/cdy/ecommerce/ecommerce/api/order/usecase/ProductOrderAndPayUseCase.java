package com.cdy.ecommerce.ecommerce.api.order.usecase;

import com.cdy.ecommerce.ecommerce.api.order.dto.ProductOrderDTO;
import com.cdy.ecommerce.ecommerce.domain.member.business.component.MemberReader;
import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import com.cdy.ecommerce.ecommerce.domain.payment.business.PaymentManager;
import com.cdy.ecommerce.ecommerce.domain.product.business.components.ProductStockManager;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductOrder;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductOrderItem;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductOrderStatus;
import com.cdy.ecommerce.ecommerce.domain.product.business.components.ProductOrderManager;
import com.cdy.ecommerce.ecommerce.domain.product.business.components.ProductOrderValidate;
import com.cdy.ecommerce.ecommerce.domain.point.business.components.UserPointReader;
import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.model.exception.PointException;
import com.cdy.ecommerce.ecommerce.domain.product.business.components.ProductReader;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductOrderAndPayUseCase {
    private final ProductOrderValidate productOrderValidate;
    private final MemberReader memberReader;
    private final ProductReader productReader;
    private final UserPointReader userPointReader;

    private final ProductOrderManager productOrderManager;
    private final ProductStockManager productStockManager;
    private final PaymentManager paymentManager;

    public ProductOrder execute(ProductOrderDTO.Request request) {
        // 주문요청 유효성 검증
        productOrderValidate.validate(request);
        // 유저 조회
        Member member = memberReader.read(request.getUserId());

        // 요청된 모든 상품에 대해 총 금액 계산
        long totalAmount = request.getProducts().stream().mapToLong(productOrder -> {
            Product product = productReader.read(productOrder.getProductId());
            return product.getPrice() * productOrder.getQuantity();
        }).sum();

        // 사용자 포인트 정보 조회 및 검증
        UserPoint userPoint = userPointReader.read(member);
        if (userPoint.getPoint() < totalAmount) {
            throw new PointException("잔액이 부족합니다.");
        }

        // 주문 항목 준비
        List<ProductOrderItem> items = request.getProducts().stream().map(detail -> {
            Product product = productReader.read(detail.getProductId());

            productStockManager.decreaseStock(detail.getProductId(), detail.getQuantity());

            // 주문 항목 객체 생성
            return new ProductOrderItem(product, detail.getQuantity(), product.getPrice());
        }).collect(Collectors.toList());

        // 주문 엔티티 생성
        ProductOrder order = ProductOrder.builder()
                .member(member)
                .orderDate(LocalDate.now())
                .status(ProductOrderStatus.PENDING)
                .items(items)
                .build();

        // 주문 저장 로직
        productOrderManager.saveOrder(order);







        // 사용자 잔액 차감
        userPoint.decreasePoints(totalAmount);

        paymentManager.createPayment(order, BigDecimal.valueOf(totalAmount), "결제수단");
        // 데이터 플랫폼으로 주문 정보 전송
        sendDataToDataPlatform(order);

        // 주문 정보 반환
        return order;
    }

    private void sendDataToDataPlatform(ProductOrder order) {
        // 결제 성공 시 데이터 플랫폼으로 주문 정보를 전송하는 로직 구현
        System.out.println("결제성공했고 데이터 플랫폼으로 주문 정보를 전송합니다.");
    }
}
