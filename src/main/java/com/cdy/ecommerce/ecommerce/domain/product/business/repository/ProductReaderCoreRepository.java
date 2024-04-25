package com.cdy.ecommerce.ecommerce.domain.product.business.repository;

import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import com.cdy.ecommerce.ecommerce.domain.product.infrastructure.IProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@AllArgsConstructor
public class ProductReaderCoreRepository implements IProductReaderRepository {
    private final IProductJpaRepository productJpaRepository;

    @Override
    public Optional<Product> selectOne(Long productId) {
        return productJpaRepository.selectOne(productId);
    }


}
