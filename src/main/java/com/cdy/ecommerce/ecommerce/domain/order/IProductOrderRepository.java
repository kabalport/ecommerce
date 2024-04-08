package com.cdy.ecommerce.ecommerce.domain.order;

import com.cdy.ecommerce.ecommerce.domain.order.business.ProductOrder;

public interface IProductOrderRepository {

    ProductOrder save(ProductOrder productOrder);
}
