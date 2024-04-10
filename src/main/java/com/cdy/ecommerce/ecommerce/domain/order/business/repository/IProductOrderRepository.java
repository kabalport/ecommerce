package com.cdy.ecommerce.ecommerce.domain.order.business.repository;

import com.cdy.ecommerce.ecommerce.domain.order.business.model.ProductOrder;

public interface IProductOrderRepository {

    ProductOrder save(ProductOrder productOrder);
}
