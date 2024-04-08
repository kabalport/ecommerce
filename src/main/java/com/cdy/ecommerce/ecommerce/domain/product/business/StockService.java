package com.cdy.ecommerce.ecommerce.domain.product.business;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductStock;

import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product.IProductStockManagerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final IProductStockManagerRepository stockRepository;

    public StockService(IProductStockManagerRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(Long id, Long quantity){
        // stock조회
        // 재고를 감소한뒤
        // 갱신된 값을 저장하도록
        ProductStock productStock = stockRepository.findById(id).orElseThrow();
        productStock.decrease(quantity);
        stockRepository.saveAndFlush(productStock);
    }
}
