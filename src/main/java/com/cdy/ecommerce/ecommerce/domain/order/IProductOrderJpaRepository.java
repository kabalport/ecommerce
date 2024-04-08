package com.cdy.ecommerce.ecommerce.domain.order;

import com.cdy.ecommerce.ecommerce.domain.order.business.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductOrderJpaRepository extends JpaRepository<ProductOrder, Long> {}
