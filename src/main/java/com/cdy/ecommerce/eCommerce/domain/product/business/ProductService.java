package com.cdy.ecommerce.eCommerce.domain.product.business;

import java.util.List;
import java.util.Optional;
import com.cdy.ecommerce.eCommerce.api.product.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

  private final IProductJpaRepository IProductJpaRepository;

  @Override
  public Product getOne(Long pno) {
    Optional<Product> result = IProductJpaRepository.selectOne(pno);

    Product product = result.orElseThrow();

    return product;
  }

  @Override
  public ProductDTO get(Long pno) {

    Optional<Product> result = IProductJpaRepository.selectOne(pno);

    Product product = result.orElseThrow();

    ProductDTO productDTO = entityToDTO(product);

    return productDTO;
  }
  private ProductDTO entityToDTO(Product product) {

    ProductDTO productDTO =
            ProductDTO.builder()
                    .pno(product.getPno())
                    .pname(product.getPname())
                    .pdesc(product.getPdesc())
                    .price(product.getPrice())
                    .build();

    List<ProductImage> imageList = product.getImageList();

    if (imageList == null || imageList.size() == 0) {
      return productDTO;
    }

    List<String> fileNameList =
            imageList.stream().map(productImage -> productImage.getFileName()).toList();

    productDTO.setUploadFileNames(fileNameList);

    return productDTO;
  }



  @Override
  public Long register(ProductDTO productDTO) {

    Product product = dtoToEntity(productDTO);

    Product result = IProductJpaRepository.save(product);

    return result.getPno();
  }

  private Product dtoToEntity(ProductDTO productDTO) {

    Product product =
        Product.builder()
            .pno(productDTO.getPno())
            .pname(productDTO.getPname())
            .pdesc(productDTO.getPdesc())
            .price(productDTO.getPrice())
            .build();

    // 업로드 처리가 끝난 파일들의 이름 리스트
    List<String> uploadFileNames = productDTO.getUploadFileNames();

    if (uploadFileNames == null) {
      return product;
    }

    uploadFileNames.stream()
        .forEach(
            uploadName -> {
              product.addImageString(uploadName);
            });

    return product;
  }






  @Override
  public void modify(ProductDTO productDTO) {

    // step1 read
    Optional<Product> result = IProductJpaRepository.findById(productDTO.getPno());

    Product product = result.orElseThrow();

    // change pname, pdesc, price
    product.changeName(productDTO.getPname());
    product.changeDesc(productDTO.getPdesc());
    product.changePrice(productDTO.getPrice());

    // upload File -- clear first
    product.clearList();

    List<String> uploadFileNames = productDTO.getUploadFileNames();

    if (uploadFileNames != null && uploadFileNames.size() > 0) {
      uploadFileNames.stream()
          .forEach(
              uploadName -> {
                product.addImageString(uploadName);
              });
    }
    IProductJpaRepository.save(product);
  }

  @Override
  public void remove(Long pno) {

    IProductJpaRepository.updateToDelete(pno, true);
  }
}
