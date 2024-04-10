package com.cdy.ecommerce.ecommerce.domain.order.prensatation.usecase;

import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountReader;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountValidator;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.order.prensatation.controller.ProductOrderDTO;
import com.cdy.ecommerce.ecommerce.domain.member.business.component.MemberReader;
import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import com.cdy.ecommerce.ecommerce.domain.payment.business.PaymentManager;
import com.cdy.ecommerce.ecommerce.domain.product.business.component.ProductStockManager;
import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrder;
import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrderItem;
import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrderStatus;
import com.cdy.ecommerce.ecommerce.domain.order.business.component.ProductOrderManager;
import com.cdy.ecommerce.ecommerce.domain.order.business.component.ProductOrderValidate;
import com.cdy.ecommerce.ecommerce.domain.product.business.component.ProductReader;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
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
    private final AccountValidator accountValidator;
    private final MemberReader memberReader;
    private final ProductReader productReader;
    private final AccountReader accountReader;

    private final ProductOrderManager productOrderManager;
    private final ProductStockManager productStockManager;
    private final PaymentManager paymentManager;

    public ProductOrder execute(ProductOrderDTO.Request request) {
        // 주문요청 유효성 검증
        productOrderValidate.validate(request);
        // 유저 조회
        Member member = memberReader.read(request.getUserId());
        // 주문 항목 준비
        List<ProductOrderItem> items = request.getProducts().stream().map(detail -> {
            Product product = productReader.read(detail.getProductId());
            productStockManager.decreaseStock(detail.getProductId(), detail.getQuantity());
            // 주문 항목 객체 생성
            return new ProductOrderItem(product, detail.getQuantity(), product.getPrice());
        }).collect(Collectors.toList());

        // 요청된 모든 상품에 대해 총 금액 계산
        BigDecimal totalAmount = items.stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 사용자 포인트 정보 조회 및 검증
        Account account = accountReader.read(member);
        accountValidator.validatePurchase(account, totalAmount);
        // 사용자 잔액 차감
        account.purchase(totalAmount);
        // 주문 엔티티 생성
        ProductOrder order = ProductOrder.builder()
                .member(member)
                .orderDate(LocalDate.now())
                .status(ProductOrderStatus.PENDING)
                .items(items)
                .build();
        // 주문 저장 로직
        productOrderManager.saveOrder(order);
        paymentManager.createPayment(order, totalAmount, "결제수단");
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
