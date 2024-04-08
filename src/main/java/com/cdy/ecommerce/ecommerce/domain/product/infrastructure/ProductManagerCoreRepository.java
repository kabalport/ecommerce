package com.cdy.ecommerce.ecommerce.domain.product.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product.IProductManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductManagerCoreRepository implements IProductManagerRepository {

    private final IProductJpaRepository productJpaRepository;
}
