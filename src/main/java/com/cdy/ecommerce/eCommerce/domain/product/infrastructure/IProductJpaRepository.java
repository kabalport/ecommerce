package com.cdy.ecommerce.eCommerce.domain.product.infrastructure;

import java.util.Optional;

import com.cdy.ecommerce.eCommerce.domain.product.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductJpaRepository extends JpaRepository<Product, Long> {


  @Query("select p from Product p where p.pno = :pno")
  Optional<Product> selectOne(@Param("pno") Long pno);

  @Modifying
  @Query("update Product p set p.delFlag = :flag where p.pno = :pno")
  void updateToDelete(@Param("pno") Long pno, @Param("flag") boolean flag);

  @Query(
      "select p  from Product p  where p.delFlag = false ")
  Page<Object[]> selectList(Pageable pageable);
}
