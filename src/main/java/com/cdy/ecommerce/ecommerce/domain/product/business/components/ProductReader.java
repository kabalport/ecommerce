package com.cdy.ecommerce.ecommerce.domain.product.business.components;


import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product.IProductReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@AllArgsConstructor
public class ProductReader {
    private final IProductReaderRepository productReaderRepository;

    public Product read(Long id) {
        // 상품유무조회
//        Optional<Product> result = productReaderRepository.selectOne(id);
        // 상품유무결과
//        return result.orElseThrow();
        return null;
    }
}
