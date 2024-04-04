package com.cdy.ecommerce;


import java.util.Arrays;
import java.util.Optional;

import com.cdy.ecommerce.eCommerce.domain.product.business.Repositories.ProductReaderRepository;
import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Product;
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
    ProductReaderRepository productRepository;

    @Test
    public void testInsert() {

        for (int i = 0; i < 10; i++) {

            Product product = Product.builder()
                    .name("상품"+i)
                    .price(100*i)
//                    .stock(100)
                    .build();


            productRepository.save(product);

            log.info("-------------------");
        }
    }

    @Transactional
    @Test
    public void testRead() {

        Long id = 1L;

        Optional<Product> result = productRepository.selectOne(id);

        Product product = result.orElseThrow();

        log.info(product); // --------- 1


    }

    @Test
    public void testRead2() {

        Long id = 1L;

        Optional<Product> result = productRepository.selectOne(id);

        Product product = result.orElseThrow();

        log.info(product);


    }

    @Commit
    @Transactional
    @Test
    public void testDelte() {

        Long id = 2L;

        productRepository.updateToDelete(id, true);

    }

    @Test
    public void testUpdate(){

        Long id = 10L;

        Product product = productRepository.selectOne(id).get();

        product.changeName("10번 상품");
        product.changePrice(5000);


        productRepository.save(product);

    }

    @Test
    public void testList() {

        //org.springframework.data.domain 패키지
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

        Page<Object[]> result = productRepository.selectList(pageable);

        //java.util
        result.getContent().forEach(arr -> log.info(Arrays.toString(arr)));

    }



}
