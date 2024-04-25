package com.cdy.ecommerce.legacy.springbootTest.product;

import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;

import com.cdy.ecommerce.ecommerce.domain.product.infrastructure.IProductJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;


@SpringBootTest
@Slf4j
public class ProductRepositoryTests {

    @Autowired
    private IProductJpaRepository productReaderRepository;

    @Test
    public void testInsertProduct() {
        Product product = Product.builder()
                .name("Sample Product")
                .price(BigDecimal.valueOf(10000))
                .delFlag(false)
                .build();

        productReaderRepository.save(product);

        log.info("Inserted Product: " + product);
    }

    @Test
    public void testInsertProduct2() {
        Product product = Product.builder()
                .name("Sample Product2")
                .price(BigDecimal.valueOf(10000))
                .delFlag(false)
                .build();

        productReaderRepository.save(product);

        log.info("Inserted Product: " + product);
    }
    public void testInsertHundredProduct() {
        Product product = Product.builder()
                .name("Sample Product")
                .price(BigDecimal.valueOf(10000))
                .delFlag(false)
                .build();

        productReaderRepository.save(product);

        log.info("Inserted Product: " + product);
    }

    @Test
    public void testReadProduct() {
        Long productId = 1L; // 상품 ID가 1인 상품을 가정

        Product product = productReaderRepository.findById(productId).orElse(null);

        log.info("Read Product: " + product);
    }
}
