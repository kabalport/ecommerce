package com.cdy.ecommerce.ecommerce.domain.product.business.repository;

import com.cdy.ecommerce.ecommerce.domain.product.business.model.ProductStock;

import java.util.Optional;

public interface IProductStockRepository {

    Optional<ProductStock> findByProductId(Long productId);

    void save(ProductStock productStock);
}
