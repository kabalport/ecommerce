package com.cdy.ecommerce.ecommerce.api.v1.product.usecase;

import com.cdy.ecommerce.ecommerce.api.admin.product.ProductAdminDTO;
import com.cdy.ecommerce.ecommerce.domain.product.business.component.ProductManager;
import com.cdy.ecommerce.ecommerce.domain.product.business.component.ProductReader;
import com.cdy.ecommerce.ecommerce.domain.product.business.component.ProductStockManager;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.ProductStock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class ProductService {
    private final ProductReader productReader;
    private final ProductManager productManager;
    private final ProductStockManager productStockManager;
    private final ProductValidator productValidator;

    public ProductService(ProductReader productReader, ProductManager productManager, ProductStockManager productStockManager, ProductValidator productValidator) {
        this.productReader = productReader;
        this.productManager = productManager;
        this.productStockManager = productStockManager;
        this.productValidator = productValidator;
    }
    /**
     * 상품 조회기능
     * @param productId
     * @return
     */
    public Product getProduct(Long productId){
        // 상품 하나를 조회합니다.
        try {
            return productReader.read(productId);
        } catch (Exception e) {
            log.error("상품 조회 중 오류 발생: {}", e.getMessage());
            throw new ProductException("상품 조회 중 오류 발생", e);
        }
    }

    /**
     * 상품 등록 및 초기 재고 설정 기능
     */
    public Product registerProduct(ProductAdminDTO.Request request) {

        // 입력 데이터 유효성 검사
        productValidator.validateProductRequest(request);

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

    /**
     * 상품수정
     * @param productId
     * @param request
     * @return
     */
    public Product updateProduct(Long productId, ProductAdminDTO.Request request) {
        try {
            Product product = productReader.read(productId);
            if (product == null) {
                throw new ProductException("상품을 찾을 수 없습니다.");
            }

            // 입력 데이터 유효성 검사
            productValidator.validateProductRequest(request);

            product.changeName(request.getName());
            product.changePrice(request.getPrice());
            productManager.save(product);
            return product;
        } catch (Exception e) {
            log.error("상품 업데이트 중 오류 발생: {}", e.getMessage());
            throw new ProductException("상품 업데이트 중 오류 발생", e);
        }
    }
    /**
     * 상품삭제
     * @param productId
     * @return
     */
    public boolean deleteProduct(Long productId) {
        try {
            Optional<Product> optionalProduct = Optional.ofNullable(productReader.read(productId));
            if (optionalProduct.isPresent() && !optionalProduct.get().isDelFlag()) {
                Product product = optionalProduct.get();
                product.setDelFlag(true);
                productManager.save(product);
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("상품 삭제 중 오류 발생: {}", e.getMessage());
            throw new ProductException("상품 삭제 중 오류 발생", e);
        }
    }
}