package com.cdy.ecommerce.ecommerce.domain.product.api;


import com.cdy.ecommerce.ecommerce.domain.product.business.ProductService;
import com.cdy.ecommerce.ecommerce.domain.product.business.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/admin/products")
public class ProductAdminController {
    private final ProductService productService;

    /**
     * 상품 등록 API
     */
    @PostMapping
    public ProductAdminDTO.Response register(@RequestBody ProductAdminDTO.Request request) {
        // 서비스 호출
        Product response = productService.registerProduct(request);
        return entityToDTO(response);
    }

    private ProductAdminDTO.Response entityToDTO(Product product) {
        // 변환
        return ProductAdminDTO.Response.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).build();
        
    }
}