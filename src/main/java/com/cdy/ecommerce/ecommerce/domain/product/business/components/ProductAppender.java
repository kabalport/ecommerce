package com.cdy.ecommerce.ecommerce.domain.product.business.components;

import com.cdy.ecommerce.ecommerce.api.product.dto.ProductDTO;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;

import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product.IProductManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ProductAppender {
    private final IProductManagerRepository productRepository;

    public Product append(ProductDTO.Request productDTO) {
        // 상품존재유무
        Product product = dtoToEntity(productDTO);
//        Product result  = productRepository.save(product);
//        return result;
        return null;
    }

    private Product dtoToEntity(ProductDTO.Request productDTO) {

        Product product =
                Product.builder()
                        .name(productDTO.getPname())
//                        .stock(productDTO.getStock())
                        .price(productDTO.getPrice())
                        .build();

        return product;
    }
}
