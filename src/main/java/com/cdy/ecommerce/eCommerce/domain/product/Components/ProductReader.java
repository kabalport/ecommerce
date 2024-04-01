package com.cdy.ecommerce.eCommerce.domain.product.Components;

import com.cdy.ecommerce.eCommerce.api.product.ProductDTO;
import com.cdy.ecommerce.eCommerce.domain.product.infrastructure.IProductJpaRepository;
import com.cdy.ecommerce.eCommerce.domain.product.Models.Product;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ProductReader {
    private IProductJpaRepository productRepository;

    public Product read(Long pno) {
        Optional<Product> product = productRepository.selectOne(pno);
//        ProductDTO productDTO = entityToDTO(product);
        return product.orElseThrow(() -> new IllegalArgumentException("Product not found for id: " + pno));
    }

    private ProductDTO entityToDTO(Product product) {
        return null;
    }
}
