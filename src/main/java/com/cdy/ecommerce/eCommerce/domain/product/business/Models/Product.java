package com.cdy.ecommerce.eCommerce.domain.product.business.Models;

import com.cdy.ecommerce.eCommerce.domain.product.application.exception.ProductException;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "tbl_product")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long pno;

  private String pname;

  private int price;

  @Column(name = "stock", nullable = false)
  private int stock;

  private boolean delFlag;

    public void changeName(String name){
        this.pname = name;
    }
    public void changePrice(int price) {
        this.price = price;
    }


  public void decreaseCurrentApplications() {
        if (this.stock > 0) {
            this.stock -= 1;
        } else {
            throw new ProductException("수량이 떨어졌습니다.");
        }
  }

}
