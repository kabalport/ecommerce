package com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductStock;

import java.util.Optional;

public interface IProductStockRepository {

    Optional<ProductStock> findByProductId(Long productId);

    void save(ProductStock productStock);
}
