package com.cdy.ecommerce.product.business;

import com.cdy.ecommerce.ecommerce.api.admin.product.ProductAdminDTO;
import com.cdy.ecommerce.ecommerce.api.v1.product.usecase.ProductException;
import com.cdy.ecommerce.ecommerce.api.v1.product.usecase.ProductService;
import com.cdy.ecommerce.ecommerce.api.v1.product.usecase.ProductValidator;
import com.cdy.ecommerce.ecommerce.domain.product.business.component.ProductManager;
import com.cdy.ecommerce.ecommerce.domain.product.business.component.ProductReader;
import com.cdy.ecommerce.ecommerce.domain.product.business.component.ProductStockManager;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.ProductStock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    private ProductReader productReader;
    private ProductManager productManager;
    private ProductStockManager productStockManager;
    private ProductValidator productValidator;
    private ProductService sut;

    @BeforeEach
    void setUp() {
        // 객체의 초기화: 테스트에 필요한 mock 객체와 서비스 객체를 생성합니다.
        productReader = mock(ProductReader.class);
        productManager = mock(ProductManager.class);
        productStockManager = mock(ProductStockManager.class);
        productValidator = mock(ProductValidator.class);
        sut = new ProductService(productReader,productManager, productStockManager, productValidator);
    }
    /**
     * 테스트케이스
     * 상품조회를 테스트합니다.
     * 검색성공 : 유효한 아이디를 통과하여 제품을 찾았을때는?
     * 실패처리 : 읽기 작업 중에 예외가 발생하면 어떻게 처리하는가?
     */
    @DisplayName("상품 조회 테스트")
    @Test
    void 상품조회() {
        // Given
        // 상품 ID와 가격을 설정하고, 이를 반환하도록 mock 객체를 설정합니다.
        Long productId = 1L;
        BigDecimal productPrice = new BigDecimal("1000");
        Product expectedProduct = Product.builder()
                .id(productId)
                .name("테스트 상품")
                .price(productPrice)
                .delFlag(false)
                .build();
        when(productReader.read(productId)).thenReturn(expectedProduct);

        // When
        // ProductService의 getProduct 메소드를 호출하여 상품을 조회합니다.
        Product result = sut.getProduct(productId);

        // Then
        // mock 객체의 read 메소드가 호출되었는지 검증합니다.
        verify(productReader).read(productId);
        // 조회된 상품이 null이 아니어야 하며, 예상한 상품과 일치해야 합니다.
        assertNotNull(result, "조회된 상품이 null이면 안 됩니다.");
        assertEquals(expectedProduct, result, "조회된 상품이 예상한 상품과 일치해야 합니다.");
    }

    @Test
    @DisplayName("상품등록 - 상품 이름과 가격을 서버에게 등록 요청하면 상품이 등록된다.")
    void 상품등록() {
        // given
        // 테스트에 필요한 초기 데이터 설정
        String userId = "user1"; // 사용자 ID
        String productName = "새 상품"; // 상품 이름
        BigDecimal productPrice = new BigDecimal("1000"); // 상품 가격
        int initialStock = 100; // 초기 재고 수량

        // 상품 등록 요청을 위한 DTO 객체 생성
        ProductAdminDTO.Request request = ProductAdminDTO.Request.builder()
                .userId(userId)
                .name(productName)
                .price(productPrice)
                .initialStock(initialStock)
                .build();

        // 저장될 때 ID가 설정된다고 가정하는 상품 객체 생성
        Product expectedProduct = Product.builder()
                .id(1L) // 상품 ID 설정
                .name(productName)
                .price(productPrice)
                .build();

        // 상품 관리자(mock)가 상품을 저장할 때 expectedProduct를 반환하도록 설정
        when(productManager.save(any(Product.class))).thenReturn(expectedProduct);

        // 재고 관리자(mock)가 save 메소드를 실행할 때 실제 부작용이 없도록 설정
        doNothing().when(productStockManager).save(any(ProductStock.class));

        // when
        // 상품 등록 요청 처리
        Product registeredProduct = sut.registerProduct(request);

        // then
        // 상품 객체가 저장되었는지 확인
        ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productManager).save(productCaptor.capture());
        Product capturedProduct = productCaptor.getValue();

        // 캡처된 상품의 이름과 가격이 요청과 일치하는지 확인
        assertEquals(productName, capturedProduct.getName(), "상품 이름이 요청과 일치해야 합니다");
        assertEquals(productPrice, capturedProduct.getPrice(), "상품 가격이 요청과 일치해야 합니다");

        // 재고 객체가 저장되었는지 확인
        ArgumentCaptor<ProductStock> stockCaptor = ArgumentCaptor.forClass(ProductStock.class);
        verify(productStockManager).save(stockCaptor.capture());
        ProductStock capturedStock = stockCaptor.getValue();

        // 캡처된 재고 수량이 요청과 일치하는지 확인
        assertEquals(initialStock, capturedStock.getQuantity(), "초기 재고 수량이 요청과 일치해야 합니다");
        // 반환된 상품이 예상된 상품과 일치하는지 확인
        assertEquals(expectedProduct, registeredProduct, "반환된 상품이 예상된 상품과 일치해야 합니다");
    }

    @Test
    @DisplayName("상품 수정 - 상품 정보를 수정하면 데이터베이스에 반영된다.")
    void 상품수정() {
        // given
        Long productId = 1L;
        String updatedName = "업데이트 상품";
        BigDecimal updatedPrice = new BigDecimal("1500");
        Product originalProduct = Product.builder()
                .id(productId)
                .name("원래 상품")
                .price(new BigDecimal("1000"))
                .productStock(new ProductStock())
                .delFlag(false)
                .build();

        ProductAdminDTO.Request updateRequest = ProductAdminDTO.Request.builder()
                .userId("user1")
                .name(updatedName)
                .price(updatedPrice)
                .build();

        when(productReader.read(productId)).thenReturn(originalProduct);
        when(productManager.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // when
        Product updatedProduct = sut.updateProduct(productId, updateRequest);

        // then
        verify(productReader).read(productId);
        verify(productManager).save(any(Product.class));
        assertNotNull(updatedProduct, "수정된 상품이 null이면 안 됩니다.");
        assertEquals(updatedName, updatedProduct.getName(), "상품 이름이 업데이트되어야 합니다.");
        assertEquals(updatedPrice, updatedProduct.getPrice(), "상품 가격이 업데이트되어야 합니다.");
    }

    @Test
    @DisplayName("상품 삭제 - 상품 삭제 플래그가 설정되면 데이터베이스에 반영된다.")
    void 상품삭제() {
        // given
        Long productId = 1L;
        Product existingProduct = Product.builder()
                .id(productId)
                .name("테스트 상품")
                .price(new BigDecimal("1000"))
                .delFlag(false)
                .build();

        when(productReader.read(productId)).thenReturn(existingProduct);
        when(productManager.save(any(Product.class))).then(returnsFirstArg());

        // when
        boolean isDeleted = sut.deleteProduct(productId);

        // then
        verify(productReader).read(productId);
        verify(productManager).save(existingProduct);
        assertTrue(isDeleted, "상품이 성공적으로 삭제되어야 합니다.");
        assertTrue(existingProduct.isDelFlag(), "상품의 삭제 플래그가 설정되어야 합니다.");
    }

    @Test
    @DisplayName("삭제된 상품 조회 - 삭제된 상품을 조회할 때 Null이 반환되어야 함")
    void 삭제된_상품_조회() {
        // given
        Long deletedProductId = 2L;
        Product deletedProduct = Product.builder()
                .id(deletedProductId)
                .name("삭제된 상품")
                .price(BigDecimal.TEN)
                .delFlag(true) // 삭제된 상품
                .build();
        when(productReader.read(deletedProductId)).thenReturn(null);

        // when
        Product result = sut.getProduct(deletedProductId);

        // then
        assertNull(result, "삭제된 상품을 조회했을 때 null이어야 합니다.");
    }


    @Test
    @DisplayName("상품 프로덕트 밸리데이션 - 상품 정보가 유효한지 검사해야 함")
    void 상품이름이_null인경우() {
        // given
        ProductAdminDTO.Request requestWithNullName = ProductAdminDTO.Request.builder()
                .userId("user1")
                .name(null) // 상품 이름이 null인 경우
                .price(BigDecimal.TEN)
                .initialStock(100)
                .build();

        var errorMessage = "상품 이름은 비어있을 수 없습니다.";

        // ProductValidator 모의 객체 생성
        // validateProductRequest 메서드가 호출될 때 예외를 던지도록 설정
        doThrow(new ProductException(errorMessage)).when(productValidator).validateProductRequest(any());

        // when & then
        assertThrows(RuntimeException.class, () -> sut.registerProduct(requestWithNullName));
    }



    @Test
    @DisplayName("상품 등록 - 초기 재고가 음수인 경우 예외 발생해야 함")
    void 상품_등록_초기재고음수() {
        // given
        ProductAdminDTO.Request requestWithNegativeStock = ProductAdminDTO.Request.builder()
                .userId("user1")
                .name("상품")
                .price(BigDecimal.TEN)
                .initialStock(-1) // 초기 재고가 음수인 경우
                .build();
        var errorMessage = "초기 재고는 음수가 될 수 없습니다.";

        // ProductValidator 모의 객체 생성
        // validateProductRequest 메서드가 호출될 때 예외를 던지도록 설정
        doThrow(new ProductException(errorMessage)).when(productValidator).validateProductRequest(any());

        // when & then
        assertThrows(ProductException.class, () -> sut.registerProduct(requestWithNegativeStock));
    }

    @Test
    void testConcurrentProductRegistration() throws InterruptedException {
        // 동시에 실행될 스레드 수
        int threadCount = 10;
        // CountDownLatch를 사용하여 모든 스레드가 동시에 시작할 수 있도록 함
        CountDownLatch latch = new CountDownLatch(1);
        // 스레드 풀 생성
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        // 동시에 상품 등록을 수행하는 스레드들을 생성하고 실행
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    // 모든 스레드가 시작될 때까지 대기
                    latch.await();
                    // 상품 등록 요청 생성
                    String userId = Thread.currentThread().getName(); // 스레드 이름을 사용하여 userId 생성
                    String productName = "테스트 상품";
                    BigDecimal productPrice = new BigDecimal("1000");
                    int initialStock = 100;
                    ProductAdminDTO.Request request = ProductAdminDTO.Request.builder()
                            .userId(userId)
                            .name(productName)
                            .price(productPrice)
                            .initialStock(initialStock)
                            .build();
                    // 상품 등록
                    Product registeredProduct = sut.registerProduct(request);
                    // 등록된 상품의 ID 확인
                    System.out.println("Registered Product ID: " + registeredProduct.getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 모든 스레드가 생성되었음을 알리고 실행 시작
        latch.countDown();
        // 모든 스레드가 완료될 때까지 대기
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }
        System.out.println("All threads completed.");

        // 테스트: 모든 상품의 ID가 서로 다른지 확인
        // 여기서는 단순히 출력만 하였으므로, 테스트를 진행하는 방식에 따라서 적절한 검증 방법을 사용해야 합니다.
    }

}

