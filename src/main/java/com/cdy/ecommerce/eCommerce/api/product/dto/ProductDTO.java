package com.cdy.ecommerce.eCommerce.api.product.dto;

import java.util.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

  private Long pno;

  private String pname;

  private int price;

  private int stock;

}
