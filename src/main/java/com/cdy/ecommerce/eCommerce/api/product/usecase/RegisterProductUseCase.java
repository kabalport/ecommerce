package com.cdy.ecommerce.eCommerce.api.product.usecase;

import com.cdy.ecommerce.eCommerce.api.product.dto.ProductDTO;
import com.cdy.ecommerce.eCommerce.domain.member.business.Components.MemberReader;
import com.cdy.ecommerce.eCommerce.domain.product.business.Components.ProductAppender;
import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegisterProductUseCase {
    private final ProductAppender productAppeder;
    private final MemberReader memberReader;

    /**
     * 상품 등록기능
     * @param productDTO
     * @param memberId
     * @return
     */
    public Long execute(ProductDTO productDTO, Long memberId) {
        // 사용자를 읽어옵니다.
//        Member member = memberReader.read(memberId);
        // 상품을 추가합니다.
        Product product = productAppeder.append(productDTO);
        // 추가한 상품번호를 반환합니다.
        return product.getPno();
    }
}
