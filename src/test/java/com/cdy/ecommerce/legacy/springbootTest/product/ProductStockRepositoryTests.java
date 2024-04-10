package com.cdy.ecommerce.legacy.springbootTest.product;

import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.ProductStock;

import com.cdy.ecommerce.ecommerce.domain.product.infrastructure.IProductJpaRepository;
import com.cdy.ecommerce.ecommerce.domain.product.infrastructure.IProductStockJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductStockRepositoryTests {

    @Autowired
    private IProductJpaRepository productRepository;

    @Autowired
    private IProductStockJpaRepository productStockRepository;


    @Test
    public void testInsertProductStock() {
        Product product = productRepository.findById(1L).orElseThrow(); // 상품 ID가 1인 상품을 먼저 조회

        ProductStock productStock = new ProductStock(product, 100); // 100개의 재고를 가정

        productStockRepository.save(productStock);

        log.info("Inserted ProductStock: " + productStock);
    }
    @Test
    public void testInsertProductStock2() {
        Product product = productRepository.findById(2L).orElseThrow(); // 상품 ID가 1인 상품을 먼저 조회

        ProductStock productStock = new ProductStock(product, 100); // 100개의 재고를 가정

        productStockRepository.save(productStock);

        log.info("Inserted ProductStock: " + productStock);
    }

    @Test
    public void testDecreaseProductStock() {
        Long productStockId = 1L; // 상품 재고 ID가 1인 상품 재고를 가정

        ProductStock productStock = productStockRepository.findById(productStockId).orElseThrow();
        productStock.decrease(10); // 재고 10개 감소

        productStockRepository.save(productStock);

        log.info("Decreased ProductStock: " + productStock);
    }
}
