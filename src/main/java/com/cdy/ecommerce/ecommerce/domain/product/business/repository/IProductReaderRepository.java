package com.cdy.ecommerce.ecommerce.domain.product.business.repository;

import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;

import java.util.Optional;

public interface IProductReaderRepository  {


    Optional<Product> selectOne(Long productId);

}
