package com.cdy.ecommerce.eCommerce.domain.product.Components;

import com.cdy.ecommerce.eCommerce.api.product.ProductDTO;
import com.cdy.ecommerce.eCommerce.domain.product.infrastructure.IProductJpaRepository;
import com.cdy.ecommerce.eCommerce.domain.product.Models.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@AllArgsConstructor
public class ProductReader {
    private final IProductJpaRepository productRepository;



    public ProductDTO read(Long pno) {
        // 상품존재유무
        Optional<Product> result = productRepository.selectOne(pno);

        Product product = result.orElseThrow();

        ProductDTO productDTO = entityToDTO(product);

        return productDTO;
    }

    private ProductDTO entityToDTO(Product product) {

        ProductDTO productDTO =
                ProductDTO.builder()
                        .pno(product.getPno())
                        .pname(product.getPname())
                        .price(product.getPrice())
                        .stock(product.getStock())
                        .build();

        return productDTO;
    }


}
