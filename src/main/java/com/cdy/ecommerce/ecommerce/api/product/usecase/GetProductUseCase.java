package com.cdy.ecommerce.ecommerce.api.product.usecase;

import com.cdy.ecommerce.ecommerce.api.product.dto.ProductDTO;
import com.cdy.ecommerce.ecommerce.domain.product.business.components.ProductReader;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
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
     * @param productId
     * @return
     */
    public Product execute(Long productId){
        // 상품 하나를 조회합니다.
        return productReader.read(productId);
    }
}