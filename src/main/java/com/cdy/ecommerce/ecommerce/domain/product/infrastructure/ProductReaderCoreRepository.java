package com.cdy.ecommerce.ecommerce.domain.product.infrastructure;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor
public class ProductReaderCoreRepository {
    private final IProductJpaRepository productJpaRepository;


}
