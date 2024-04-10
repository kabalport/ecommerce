package com.cdy.ecommerce.ecommerce.domain.product.business.component;


import com.cdy.ecommerce.ecommerce.domain.product.business.model.ProductStock;
import com.cdy.ecommerce.ecommerce.domain.product.business.repository.IProductStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductStockManager {
    private final IProductStockRepository productStockRepository;

    public void decreaseStock(Long productId, int quantity) {
        ProductStock productStock = productStockRepository.findByProductId(productId)
                .orElseThrow(() -> new IllegalStateException("Stock not found for product: " + productId));

        productStock.decrease(quantity);
        productStockRepository.save(productStock);
    }

    public void save(ProductStock stock) {
        productStockRepository.save(stock);
    }
}
