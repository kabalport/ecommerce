package com.cdy.ecommerce.eCommerce.domain.product.business.Components;

import com.cdy.ecommerce.eCommerce.api.product.dto.ProductDTO;
import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Product;
import com.cdy.ecommerce.eCommerce.domain.product.business.Repositories.ProductAppendRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ProductAppender {
    private final ProductAppendRepository productRepository;

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
