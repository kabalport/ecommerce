package com.cdy.ecommerce.ecommerce.domain.product.business;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.Stock;
import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(Long id, Long quantity){
        // stock조회
        // 재고를 감소한뒤
        // 갱신된 값을 저장하도록
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);
        stockRepository.saveAndFlush(stock);
    }
}