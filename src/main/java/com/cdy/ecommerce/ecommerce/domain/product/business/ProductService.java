package com.cdy.ecommerce.ecommerce.domain.product.business;

import com.cdy.ecommerce.ecommerce.domain.product.api.ProductAdminDTO;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.ProductStock;
import com.cdy.ecommerce.ecommerce.domain.product.business.repository.IProductManagerRepository;
import com.cdy.ecommerce.ecommerce.domain.product.business.repository.IProductReaderRepository;
import com.cdy.ecommerce.ecommerce.domain.product.business.repository.IProductStockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional
public class ProductService {
    private final ProductValidator productValidator;

    private final IProductStockRepository productStockRepository;
    private final IProductReaderRepository productReaderRepository;
    private final IProductManagerRepository productManagerRepository;


    public ProductService(ProductValidator productValidator, IProductStockRepository productStockRepository, IProductReaderRepository productReaderRepository, IProductManagerRepository productManagerRepository) {
        this.productStockRepository = productStockRepository;
        this.productValidator = productValidator;
        this.productReaderRepository = productReaderRepository;
        this.productManagerRepository = productManagerRepository;
    }

    public void decreaseStock(Long productId, int quantity) {
        ProductStock productStock = productStockRepository.findByProductId(productId)
                .orElseThrow(() -> new IllegalStateException("Stock not found for product: " + productId));

        productStock.decrease(quantity);
        productStockRepository.save(productStock);
    }

    public void stocksave(ProductStock stock) {
        productStockRepository.save(stock);
    }
    /**
     * 상품 조회기능
     * @param productId
     * @return
     */
    public Product getProduct(Long productId){
        // 상품 하나를 조회합니다.
        try {
            // 상품유무조회
            Optional<Product> result = productReaderRepository.selectOne(productId);
            // 상품유무결과
            return result.orElseThrow(()->new ProductException("상품정보가 없습니다. 요청상품아이디: "+ productId));
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
        Product result  = productManagerRepository.save(product);

        // 요청된 초기 재고 수량으로 재고 객체 생성
        ProductStock stock = new ProductStock(result, request.getInitialStock());
        // 초기 재고를 데이터베이스에 저장
        productStockRepository.save(stock);

        // 추가된 상품 정보 반환
        return result;
    }

    /**
     * 상품수정
     * @param productId
     * @param request
     * @return
     */
    public Product updateProduct(Long productId, ProductAdminDTO.Request request) {
            // 입력 데이터 유효성 검사
            productValidator.validateProductRequest(request);
        try {
            Optional<Product> product = productReaderRepository.selectOne(productId);
            Product changeProduct = product.orElseThrow(()->new ProductException("상품정보가 없습니다. 요청상품아이디: "+ productId));

            changeProduct.changeName(request.getName());
            changeProduct.changePrice(request.getPrice());
            productManagerRepository.save(changeProduct);
            return changeProduct;
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
            Optional<Product> optionalProduct = productReaderRepository.selectOne(productId);
            if (optionalProduct.isPresent() && !optionalProduct.get().isDelFlag()) {
                Product product = optionalProduct.get();
                product.setDelFlag(true);
                productManagerRepository.save(product);
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("상품 삭제 중 오류 발생: {}", e.getMessage());
            throw new ProductException("상품 삭제 중 오류 발생", e);
        }
    }
}