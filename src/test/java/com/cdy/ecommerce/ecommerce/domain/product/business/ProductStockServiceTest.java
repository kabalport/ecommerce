package com.cdy.ecommerce.ecommerce.domain.product.business;

//import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductStock;
//import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.StockRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductStockServiceTest {
    @Autowired
    private StockService stockService;
    @Autowired
//    private StockRepository stockRepository;

    @BeforeEach
    public void before(){
//        stockRepository.saveAndFlush(new Stock(1L,100L));
    }

//    @AfterEach
//    public void after(){
//        stockRepository.deleteAll();
//    }

    @Test
    public void 재고감소(){
//        stockService.decrease(1L,1L);
//        ProductStock productStock = stockRepository.findById(1L).orElseThrow();
//        assertEquals(99, productStock.getQuantity());
    }

    @Test
    public void 동시에_100개의_요청() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i <threadCount; i++) {
            executorService.submit(()->{
                try{
                    stockService.decrease(1L,1L);
                }finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
//        ProductStock productStock = stockRepository.findById(1L).orElseThrow();
        // 100 - (1*100) = 0;
//        assertEquals(0, productStock.getQuantity());
    }
}