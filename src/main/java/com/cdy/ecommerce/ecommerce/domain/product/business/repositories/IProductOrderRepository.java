package com.cdy.ecommerce.ecommerce.domain.product.business.repositories;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductOrder;

public interface IProductOrderRepository {

    ProductOrder save(ProductOrder productOrder);
}
