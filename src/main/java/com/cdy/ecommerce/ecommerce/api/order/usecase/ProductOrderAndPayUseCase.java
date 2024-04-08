package com.cdy.ecommerce.ecommerce.api.order.usecase;


import com.cdy.ecommerce.ecommerce.api.order.dto.ProductOrderDTO;
import com.cdy.ecommerce.ecommerce.domain.member.business.component.MemberReader;
import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import com.cdy.ecommerce.ecommerce.domain.order.business.ProductOrder;
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

    /**
     * 주문하기
     * @param request
     * @return
     */
    public ProductOrder execute(ProductOrderDTO.Request request) {
        // 유저 조회
        Member member = memberReader.read(request.getUserId());
        // 상품 조회
//        Product product = productReader.read(request.getProducts().stream().map(null).sum();
        //


        // 2. 상품 정보 및 가용성 검증
//        var totalAmount = orderRequest.getProducts().stream()
//                .mapToLong(productOrder -> {
//                    var product = productRepository.findById(productOrder.getProductId()).orElseThrow();
//                    return product.getPrice() * productOrder.getQuantity();
//                }).sum();

        // 3. 사용자 잔액 확인 및 차감 로직
//        if (!paymentProcessor.checkAndDeductBalance(member, totalAmount)) {
//            throw new RuntimeException("Insufficient balance for the transaction.");
//        }

        // 4. 주문 엔티티 생성 및 저장
//        var order = new ProductOrder(1L, totalAmount,null,null,0,null);
//        orderRepository.save(order);

        // 5. 결제 성공 시, 데이터 플랫폼으로 주문 정보 전송
//        sendDataToDataPlatform(order);

        // 6. 결제 및 주문 정보 반환
//        return order;
        return null;
    }

    private void sendDataToDataPlatform(ProductOrder order) {
        // 결제 성공 시 데이터 플랫폼으로 주문 정보를 전송하는 로직 구현
    }
}
