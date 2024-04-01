package com.cdy.ecommerce;


import java.util.Arrays;
import java.util.Optional;

import com.cdy.ecommerce.eCommerce.domain.product.infrastructure.IProductJpaRepository;
import com.cdy.ecommerce.eCommerce.domain.product.Models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;


import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductRepositoryTests {

    @Autowired
    IProductJpaRepository productRepository;

    @Test
    public void testInsert() {

        for (int i = 0; i < 10; i++) {

            Product product = Product.builder()
                    .pname("상품"+i)
                    .price(100*i)
                    .stock(100)
                    .build();


            productRepository.save(product);

            log.info("-------------------");
        }
    }

    @Transactional
    @Test
    public void testRead() {

        Long pno = 1L;

        Optional<Product> result = productRepository.selectOne(pno);

        Product product = result.orElseThrow();

        log.info(product); // --------- 1


    }

    @Test
    public void testRead2() {

        Long pno = 1L;

        Optional<Product> result = productRepository.selectOne(pno);

        Product product = result.orElseThrow();

        log.info(product);


    }

    @Commit
    @Transactional
    @Test
    public void testDelte() {

        Long pno = 2L;

        productRepository.updateToDelete(pno, true);

    }

    @Test
    public void testUpdate(){

        Long pno = 10L;

        Product product = productRepository.selectOne(pno).get();

        product.changeName("10번 상품");
        product.changePrice(5000);


        productRepository.save(product);

    }

    @Test
    public void testList() {

        //org.springframework.data.domain 패키지
        Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());

        Page<Object[]> result = productRepository.selectList(pageable);

        //java.util
        result.getContent().forEach(arr -> log.info(Arrays.toString(arr)));

    }



}
