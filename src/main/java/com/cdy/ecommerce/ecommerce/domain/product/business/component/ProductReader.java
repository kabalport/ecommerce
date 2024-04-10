package com.cdy.ecommerce.ecommerce.domain.product.business.component;

import com.cdy.ecommerce.ecommerce.domain.product.business.model.ProductException;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.repository.IProductReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@AllArgsConstructor
public class ProductReader {
    private final IProductReaderRepository productReaderRepository;

    public Product read(Long productId) {
        // 상품유무조회
        Optional<Product> result = productReaderRepository.selectOne(productId);
        // 상품유무결과
        return result.orElseThrow(()->new ProductException("상품정보가 없습니다. 요청상품아이디: "+ productId));
    }
}
