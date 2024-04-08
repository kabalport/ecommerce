package com.cdy.ecommerce.ecommerce.api.order.usecase;

import com.cdy.ecommerce.ecommerce.api.order.dto.ProductOrderDTO;
import com.cdy.ecommerce.ecommerce.domain.member.business.component.MemberReader;
import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import com.cdy.ecommerce.ecommerce.domain.order.business.ProductOrder;
import com.cdy.ecommerce.ecommerce.domain.order.component.ProductOrderManager;
import com.cdy.ecommerce.ecommerce.domain.point.business.components.UserPointReader;
import com.cdy.ecommerce.ecommerce.domain.point.business.model.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.model.exception.PointException;
import com.cdy.ecommerce.ecommerce.domain.product.business.components.ProductReader;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductOrderAndPayUseCase {
    private final MemberReader memberReader;
    private final ProductReader productReader;
    private final ProductOrderManager productOrderManager;
    private final UserPointReader userPointReader;

    public ProductOrder execute(ProductOrderDTO.Request request) {
        // 유저 조회
        Member member = memberReader.read(request.getUserId());

        // 총 금액 조회를 위한 변수 초기화
        long totalAmount = 0L;

        // 요청된 모든 상품에 대해 처리
        for (ProductOrderDTO.ProductOrderDetail productOrderDetail : request.getProducts()) {
            // 상품 정보 조회
            Product product = productReader.read(productOrderDetail.getProductId());

            // 총 금액 계산
            totalAmount += product.getPrice() * productOrderDetail.getQuantity();
        }

        // 사용자 포인트 정보 조회
        UserPoint userPoint = userPointReader.read(member);

        // 사용자 잔액 확인 및 차감 로직
        if (userPoint.getPoint() < totalAmount) {
            throw new PointException("잔액이 부족합니다.");
        }

        // 사용자 잔액 차감
        userPoint.decreasePoints(totalAmount);

        // 주문 엔티티 생성 및 저장
        ProductOrder order = (ProductOrder) productOrderManager.createOrder(member, request.getProducts(), totalAmount);

        // 데이터 플랫폼으로 주문 정보 전송
        sendDataToDataPlatform(order);

        // 주문 정보 반환
        return order;
    }

    private void sendDataToDataPlatform(ProductOrder order) {
        // 결제 성공 시 데이터 플랫폼으로 주문 정보를 전송하는 로직 구현
    }
}
