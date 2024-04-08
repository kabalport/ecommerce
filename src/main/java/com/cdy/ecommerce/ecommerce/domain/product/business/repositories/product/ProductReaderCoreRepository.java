package com.cdy.ecommerce.ecommerce.domain.product.business.repositories.product;

import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import com.cdy.ecommerce.ecommerce.domain.product.infrastructure.IProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@AllArgsConstructor
public class ProductReaderCoreRepository implements IProductReaderRepository {
    private final IProductJpaRepository productJpaRepository;

    //selectOne
    //updateToDelete
    //selectList

    //상품조회

    @Override
    public Optional<Product> selectOne(Long productId) {
        return productJpaRepository.selectOne(productId);
    }
//    //상품수정
//    public void 상품수정(Long productId){
//        productJpaRepository.updateToDelete(productId,false);
//    }
//    //상품목록
//    public void 상품목록(Long productId){
//        productJpaRepository.selectList(null);
//    }
//




}
