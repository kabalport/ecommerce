package com.cdy.ecommerce.ecommerce.domain.product.business.components;


import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductStock;
import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product.IProductStockManagerRepository;
import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product.IProductStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductStockManager {
    private final IProductStockRepository productStockRepository;

    public void decreaseStock(Long productId, Long quantity) {
        ProductStock productStock = productStockRepository.findByProductId(productId)
                .orElseThrow(() -> new IllegalStateException("Stock not found for product: " + productId));

        productStock.decrease(quantity);
        productStockRepository.save(productStock);
    }

    public void save(ProductStock stock) {
        productStockRepository.save(stock);
    }
}
