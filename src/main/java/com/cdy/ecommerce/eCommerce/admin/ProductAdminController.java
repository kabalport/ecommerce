package com.cdy.ecommerce.eCommerce.admin;

import com.cdy.ecommerce.eCommerce.api.product.ProductDTO;
import com.cdy.ecommerce.eCommerce.domain.product.business.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/admin/products")
public class ProductAdminController {
    private final ProductService productService; // ProductServcie 주입
    /**
     * 상품 등록 API
     * @param productDTO
     * @return
     */
    @PostMapping("/")
    public Map<String, Long> register(ProductDTO productDTO, Long memberId) {
        // 서비스 호출
        Long pno = productService.register(productDTO,memberId);
        return Map.of("result", pno);
    }
}
