package com.cdy.ecommerce.ecommerce.api.order.usecase;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductStock;

import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product.IProductStockManagerRepository;
import com.cdy.ecommerce.ecommerce.domain.product.infrastructure.IProductStockJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final IProductStockJpaRepository stockRepository;

    public StockService(IProductStockJpaRepository stockRepository) {
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