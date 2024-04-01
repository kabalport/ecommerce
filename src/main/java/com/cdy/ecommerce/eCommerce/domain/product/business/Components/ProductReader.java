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
//    private final IProductJpaRepository productRepository;
    private final ProductReaderRepository productReaderRepository;

    public ProductDTO read(Long pno) {
        // 상품존재유무
        Optional<Product> result = productReaderRepository.selectOne(pno);

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
