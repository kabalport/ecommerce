package com.cdy.ecommerce.eCommerce.domain.product.Components;

import com.cdy.ecommerce.eCommerce.api.product.ProductDTO;
import com.cdy.ecommerce.eCommerce.domain.member.Models.Member;
import com.cdy.ecommerce.eCommerce.domain.product.Models.Product;
import com.cdy.ecommerce.eCommerce.domain.product.infrastructure.IProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@AllArgsConstructor
public class ProductAppender {
    private final IProductJpaRepository productRepository;

    public Product append(ProductDTO productDTO) {
        // 상품존재유무
        Product product = dtoToEntity(productDTO);
        Product result  = productRepository.save(product);
        return result;
    }

    private Product dtoToEntity(ProductDTO productDTO) {

        Product product =
                Product.builder()
                        .pno(productDTO.getPno())
                        .pname(productDTO.getPname())
                        .stock(productDTO.getStock())
                        .price(productDTO.getPrice())
                        .build();

        return product;
    }
}
