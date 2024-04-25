package com.cdy.ecommerce.ecommerce.admin.v1.analysis;

import com.cdy.ecommerce.ecommerce.admin.v1.analysis.usecase.GetTrendProductsUseCase;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trend")
public class TrendController {
    private final GetTrendProductsUseCase getTrendProductsUseCase;

    @GetMapping("/products")
    public List<TrendDTO> getTrendProducts(){
        return getTrendProductsUseCase.execute();
    }

    public class TrendDTO {
        private Long productId;
        private String productName;
        private Long totalQuantity;

        public TrendDTO(Long productId, String productName, Long totalQuantity) {
            this.productId = productId;
            this.productName = productName;
            this.totalQuantity = totalQuantity;
        }
    }
}
