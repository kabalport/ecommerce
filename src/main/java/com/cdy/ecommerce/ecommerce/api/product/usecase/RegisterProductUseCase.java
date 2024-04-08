package com.cdy.ecommerce.ecommerce.api.product.usecase;

import com.cdy.ecommerce.ecommerce.api.product.dto.ProductDTO;
import com.cdy.ecommerce.ecommerce.domain.member.business.component.MemberReader;
import com.cdy.ecommerce.ecommerce.domain.product.business.components.ProductAppender;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegisterProductUseCase {
    private final ProductAppender productAppender;
    private final MemberReader memberReader;

    /**
     * 상품 등록기능
     */
    public Long execute(ProductDTO.Request productDTO, Long memberId) {
        // 사용자를 읽어옵니다.
//        Member member = memberReader.read(memberId);
        // 상품을 추가합니다.
        Product product = productAppender.append(productDTO);
        // 추가한 상품번호를 반환합니다.
        return product.getId();
    }
}
