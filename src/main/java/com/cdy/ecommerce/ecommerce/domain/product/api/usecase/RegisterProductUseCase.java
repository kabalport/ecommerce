package com.cdy.ecommerce.ecommerce.domain.product.api.usecase;

import com.cdy.ecommerce.ecommerce.admin.ProductAdminDTO;
import com.cdy.ecommerce.ecommerce.domain.product.business.components.ProductManager;
import com.cdy.ecommerce.ecommerce.domain.product.business.components.ProductStockManager;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.models.ProductStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegisterProductUseCase {
    private final ProductManager productManager;
    private final ProductStockManager productStockManager;

    /**
     * 상품 등록 및 초기 재고 설정 기능
     */
    public Product execute(ProductAdminDTO.Request request) {
        // 상품 정보를 바탕으로 상품 객체 생성
        Product product = Product.builder().price(request.getPrice()).name(request.getName()).build();

        // 상품을 데이터베이스에 저장
        product = productManager.save(product);

        // 요청된 초기 재고 수량으로 재고 객체 생성
        ProductStock stock = new ProductStock(product, request.getInitialStock());
        // 초기 재고를 데이터베이스에 저장
        productStockManager.save(stock);

        // 추가된 상품 정보 반환
        return product;
    }
}
