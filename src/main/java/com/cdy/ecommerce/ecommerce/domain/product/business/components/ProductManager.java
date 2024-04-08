package com.cdy.ecommerce.ecommerce.domain.product.business.components;

import com.cdy.ecommerce.ecommerce.api.product.dto.ProductDTO;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product.IProductManagerRepository;
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

}
