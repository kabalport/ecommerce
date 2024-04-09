package com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductStock;
import com.cdy.ecommerce.ecommerce.domain.product.infrastructure.IProductStockJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProductStockCoreRepository implements IProductStockRepository{

    private final IProductStockJpaRepository productStockJpaRepository;
    @Override
    public Optional<ProductStock> findByProductId(Long productId) {
        return productStockJpaRepository.findByProductId(productId);
    }

    @Override
    public void save(ProductStock productStock) {
        productStockJpaRepository.saveAndFlush(productStock);
    }
}
