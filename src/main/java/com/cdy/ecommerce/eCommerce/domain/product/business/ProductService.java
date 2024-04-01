package com.cdy.ecommerce.eCommerce.domain.product.business;

import java.util.Optional;
import com.cdy.ecommerce.eCommerce.api.product.ProductDTO;
import com.cdy.ecommerce.eCommerce.domain.member.Member;
import com.cdy.ecommerce.eCommerce.domain.product.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ProductService{
  private final IProductJpaRepository IProductJpaRepository;
  private final ProductReader productReader;

  private final MemberReader memberReader;

  /**
   * 상품 조회기능
   * @param pno
   * @return
   */
  public Product getOne(Long pno) {
    // 상품존재유무
    Product product = productReader.read(pno);
    return product;
  }




  public Long register(ProductDTO productDTO) {
// 사용자테이블에서 사용자 읽어오기-아직구현안됨.아직무시하기.
//    Member member = memberReader.read()
    Product product = dtoToEntity(productDTO);

    Product result = IProductJpaRepository.save(product);

    return result.getPno();
  }

  private Product dtoToEntity(ProductDTO productDTO) {
    return null;
  }


  public void remove(Long pno) {

    IProductJpaRepository.updateToDelete(pno, true);
  }
}
