package com.cdy.ecommerce.eCommerce.domain.product.business.Components;

import com.cdy.ecommerce.eCommerce.api.product.dto.ProductDTO;
import com.cdy.ecommerce.eCommerce.domain.product.business.Repositories.ProductReaderRepository;
import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Product;
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
