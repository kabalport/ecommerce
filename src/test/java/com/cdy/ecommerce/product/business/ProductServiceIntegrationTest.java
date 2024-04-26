package com.cdy.ecommerce.product.business;

import com.cdy.ecommerce.IntegrationTest;
import com.cdy.ecommerce.ecommerce.domain.product.api.ProductAdminDTO;
import com.cdy.ecommerce.ecommerce.domain.product.business.ProductException;
import com.cdy.ecommerce.ecommerce.domain.product.business.ProductService;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.ProductStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class ProductServiceIntegrationTest extends IntegrationTest {

    @Autowired
    private ProductService productService;
    @Test
    @DisplayName("상품 조회 통합 테스트")
    public void testGetProduct() {
        // 상품 등록
        ProductAdminDTO.Request request = new ProductAdminDTO.Request("userid","Test Product", new BigDecimal("25000"), 100);
        Product registeredProduct = productService.registerProduct(request);
        assertNotNull(registeredProduct.getId(), "Registered product should have an ID.");

        // 상품 조회
        Product foundProduct = productService.getProduct(registeredProduct.getId());
        assertNotNull(foundProduct, "Retrieved product should not be null.");
        assertEquals(registeredProduct.getId(), foundProduct.getId(), "Retrieved product ID should match the registered product.");
        assertEquals("Test Product", foundProduct.getName(), "Product name should match the registered product.");
        assertEquals(new BigDecimal("25000"), foundProduct.getPrice(), "Product price should match the registered product.");
    }

    @Test
    @DisplayName("상품 등록 통합 테스트")
    public void testRegisterProduct() {
        // 상품 등록 요청 데이터 준비
        ProductAdminDTO.Request request = new ProductAdminDTO.Request();
        request.setName("새로운 상품");
        request.setPrice(new BigDecimal("29900"));
        request.setInitialStock(50);

        // 상품 등록 실행
        Product registeredProduct = productService.registerProduct(request);

        // 검증: 상품 정보 확인
        assertNotNull(registeredProduct.getId());
        assertEquals("새로운 상품", registeredProduct.getName());
        assertEquals(new BigDecimal("29900"), registeredProduct.getPrice());

        // 검증: 재고 정보 확인
        ProductStock stock = productService.findStockByProductId(registeredProduct.getId());
        assertEquals(50, stock.getQuantity());
    }

    @Test
    @DisplayName("상품 수정 통합 테스트")
    public void testUpdateProduct() {
        // 테스트를 위한 상품 등록
        Product originalProduct = productService.registerProduct(new ProductAdminDTO.Request("userid","원본 상품", new BigDecimal("20000"), 30));
        Long productId = originalProduct.getId();

        // 수정할 상품 정보 설정
        ProductAdminDTO.Request updateRequest = new ProductAdminDTO.Request("userid","수정된 상품", new BigDecimal("21000"), 30);

        // 상품 수정 실행
        Product updatedProduct = productService.updateProduct(productId, updateRequest);

        // 검증
        assertEquals("수정된 상품", updatedProduct.getName());
        assertEquals(new BigDecimal("21000"), updatedProduct.getPrice());
    }

    @Test
    @DisplayName("상품 삭제 통합 테스트")
    public void testDeleteProduct() {
        // 테스트를 위한 상품 등록
        Product product = productService.registerProduct(new ProductAdminDTO.Request("userid","삭제 테스트 상품", new BigDecimal("10000"), 20));
        Long productId = product.getId();

        // 상품 삭제 실행
        assertTrue(productService.deleteProduct(productId));

        // 검증: 삭제된 상품 조회 시 예외 발생
        assertThrows(ProductException.class, () -> productService.getProduct(productId));
    }

    @Test
    @DisplayName("특정 상품의 재고 조회 테스트")
    public void testFindStockByProductId() {
        // 상품 등록
        ProductAdminDTO.Request request = new ProductAdminDTO.Request("userid","Test Product", new BigDecimal("25000"), 100);
        Product product = productService.registerProduct(request);
        assertNotNull(product);

        // 재고 조회
        ProductStock stock = productService.findStockByProductId(product.getId());
        assertNotNull(stock);
        assertEquals(100, stock.getQuantity());
    }

}
