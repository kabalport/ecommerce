package com.cdy.ecommerce.ecommerce.domain.product;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductStock;
import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product.IProductManagerRepository;

import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product.IProductStockManagerRepository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductStockRepositoryTests {

    @Autowired
    private IProductStockManagerRepository productStockRepository;

    @Autowired
    private IProductManagerRepository productRepository;

    @Test
    public void testInsertProductStock() {
//        Product product = productRepository.findById(1L).orElseThrow(); // 상품 ID가 1인 상품을 먼저 조회

//        ProductStock productStock = new ProductStock(product, 100L); // 100개의 재고를 가정

//        productStockRepository.save(productStock);

//        log.info("Inserted ProductStock: " + productStock);
    }

    @Test
    public void testDecreaseProductStock() {
        Long productStockId = 1L; // 상품 재고 ID가 1인 상품 재고를 가정

        ProductStock productStock = productStockRepository.findById(productStockId).orElseThrow();
        productStock.decrease(10L); // 재고 10개 감소

        productStockRepository.save(productStock);

        log.info("Decreased ProductStock: " + productStock);
    }
}