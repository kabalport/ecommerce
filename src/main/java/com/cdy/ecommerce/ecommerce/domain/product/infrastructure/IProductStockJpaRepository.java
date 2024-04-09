package com.cdy.ecommerce.ecommerce.domain.product.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IProductStockJpaRepository extends JpaRepository<ProductStock, Long> {
    @Query("SELECT ps FROM ProductStock ps WHERE ps.product.id = ?1")
    Optional<ProductStock> findByProductId(Long productId);
}
