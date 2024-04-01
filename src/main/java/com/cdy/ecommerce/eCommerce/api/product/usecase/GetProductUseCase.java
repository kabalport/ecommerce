package com.cdy.ecommerce.eCommerce.api.product.usecase;

import com.cdy.ecommerce.eCommerce.api.product.dto.ProductDTO;
import com.cdy.ecommerce.eCommerce.domain.product.business.Components.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GetProductUseCase {
    private final ProductReader productReader;

    /**
     * 상품 조회기능
     * @param id
     * @return
     */
    public ProductDTO.Response execute(Long id){
        // 상품 하나를 조회합니다.
        ProductDTO.Response product = productReader.read(id);
        // 조회한 상품을 반환합니다.
        return product;
    }
}