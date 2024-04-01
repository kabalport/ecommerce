package com.cdy.ecommerce.eCommerce.domain.product.business.Repositories;

import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Product;
import com.cdy.ecommerce.eCommerce.domain.product.infrastructure.IProductJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductReaderRepository extends IProductJpaRepository {
    @Query("select p from Product p where p.pno = :pno")
    Optional<Product> selectOne(@Param("pno") Long pno);
    @Modifying
    @Query("update Product p set p.delFlag = :flag where p.pno = :pno")
    void updateToDelete(@Param("pno") Long pno, @Param("flag") boolean flag);
    @Query(
            "select p  from Product p  where p.delFlag = false ")
    Page<Object[]> selectList(Pageable pageable);
}
