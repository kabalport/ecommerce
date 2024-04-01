package com.cdy.ecommerce.eCommerce.domain.product.business.Repositories;

import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Product;
import com.cdy.ecommerce.eCommerce.domain.product.infrastructure.ProductJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductReaderRepository extends ProductJpaRepository {
    @Query("select p from Product p where p.id = :id")
    Optional<Product> selectOne(@Param("id") Long id);
    @Modifying
    @Query("update Product p set p.delFlag = :flag where p.id = :id")
    void updateToDelete(@Param("id") Long id, @Param("flag") boolean flag);
    @Query(
            "select p  from Product p  where p.delFlag = false ")
    Page<Object[]> selectList(Pageable pageable);
}
