package com.cdy.ecommerce.ecommerce.domain.order.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductOrderJpaRepository extends JpaRepository<ProductOrder, Long> {}
