package com.cdy.ecommerce.ecommerce.domain.product.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductOrderJpaRepository extends JpaRepository<ProductOrder, Long> {}
