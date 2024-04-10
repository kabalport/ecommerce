package com.cdy.ecommerce.ecommerce.domain.product.business.component;

import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.repository.IProductManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductManager {
    private final IProductManagerRepository productRepository;

    public Product append(Product product) {
        // 상품존재유무
        Product result  = productRepository.save(product);
        return result;
    }

    public Product save(Product product) {
        Product result  = productRepository.save(product);
        return result;
    }
}
