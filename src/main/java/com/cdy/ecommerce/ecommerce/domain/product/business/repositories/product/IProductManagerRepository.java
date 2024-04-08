package com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import com.cdy.ecommerce.ecommerce.domain.product.infrastructure.IProductJpaRepository;

public interface IProductManagerRepository {
    Product save(Product product);
}

