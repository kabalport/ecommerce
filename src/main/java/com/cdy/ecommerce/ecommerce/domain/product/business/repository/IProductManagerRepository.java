package com.cdy.ecommerce.ecommerce.domain.product.business.repository;

import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;

public interface IProductManagerRepository {
    Product save(Product product);
}

