package com.cdy.ecommerce.ecommerce.domain.product.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IProductJpaRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.id = :id")
    Optional<Product> selectOne(@Param("id") Long id);
    @Modifying
    @Query("update Product p set p.delFlag = :flag where p.id = :id")
    void updateToDelete(@Param("id") Long id, @Param("flag") boolean flag);
    @Query(
            "select p  from Product p  where p.delFlag = false ")
    Page<Object[]> selectList(Pageable pageable);
}