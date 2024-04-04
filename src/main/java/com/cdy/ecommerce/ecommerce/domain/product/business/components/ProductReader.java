package com.cdy.ecommerce.ecommerce.domain.product.business.components;

import com.cdy.ecommerce.ecommerce.api.product.dto.ProductDTO;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.ProductReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@AllArgsConstructor
public class ProductReader {
    private final ProductReaderRepository productReaderRepository;

    public ProductDTO.Response read(Long id) {
        // 상품존재유무
        Optional<Product> result = productReaderRepository.selectOne(id);

        Product product = result.orElseThrow();

        ProductDTO.Response productDTO = entityToDTO(product);

        return productDTO;
    }

    private ProductDTO.Response entityToDTO(Product product) {

        ProductDTO.Response productDTO =
                ProductDTO.Response.builder()
                        .id(product.getId())
                        .pname(product.getName())
                        .price(product.getPrice())
//                        .stock(product.getStock())
                        .build();

        return productDTO;
    }


}
