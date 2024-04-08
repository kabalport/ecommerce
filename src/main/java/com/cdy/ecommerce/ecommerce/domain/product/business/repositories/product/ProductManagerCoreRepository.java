package com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product.IProductManagerRepository;
import com.cdy.ecommerce.ecommerce.domain.product.infrastructure.IProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductManagerCoreRepository implements IProductManagerRepository {

    private final IProductJpaRepository productJpaRepository;

    @Override
    public Product save(Product product) {
        return productJpaRepository.save(product);
    }
}
