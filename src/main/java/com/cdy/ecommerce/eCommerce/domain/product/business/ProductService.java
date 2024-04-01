package com.cdy.ecommerce.eCommerce.domain.product.business;

import com.cdy.ecommerce.eCommerce.api.product.ProductDTO;
import com.cdy.ecommerce.eCommerce.domain.member.Components.MemberReader;
import com.cdy.ecommerce.eCommerce.domain.member.Models.Member;
import com.cdy.ecommerce.eCommerce.domain.product.Components.ProductAppender;
import com.cdy.ecommerce.eCommerce.domain.product.Components.ProductReader;
import com.cdy.ecommerce.eCommerce.domain.product.Models.Product;
import com.cdy.ecommerce.eCommerce.domain.product.infrastructure.IProductJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ProductService{
  private final IProductJpaRepository productJpaRepository;
  private final ProductReader productReader;

  private final ProductAppender productAppeder;

  private final MemberReader memberReader;

  /**
   * 상품 조회기능
   * @param pno
   * @return
   */
  public ProductDTO getOne(Long pno){
    // 상품 하나를 조회합니다.
    ProductDTO product = productReader.read(pno);
    // 조회한 상품을 반환합니다.
    return product;
  }

  /**
   * 상품 등록기능
   * @param productDTO
   * @param memberId
   * @return
   */
  public Long register(ProductDTO productDTO, Long memberId) {
    // 사용자를 읽어옵니다.
    Member member = memberReader.read(memberId);
    // 상품을 추가합니다.
    Product product = productAppeder.append(productDTO);
    // 추가한 상품번호를 반환합니다.
    return product.getPno();
  }

}
