package com.cdy.ecommerce.eCommerce.domain.product.infrastructure;

import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {}
