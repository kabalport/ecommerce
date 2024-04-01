package com.cdy.ecommerce.eCommerce.domain.product.business;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "tbl_product")
@Getter
@ToString(exclude = "imageList")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long pno;

  private String pname;

  private int price;

  private String pdesc;

  @ColumnDefault("0")
  @Column(name = "stock", nullable = false)
  private int stock;

  @ColumnDefault("N")
  @Column(name = "del_flag", nullable = false)
  private boolean delFlag;
  public void changeDel(boolean delFlag) {
    this.delFlag = delFlag;
  }


  public void decreaseCurrentApplications() {
        if (this.stock > 0) {
            this.stock -= 1;
        } else {
            throw new ProductException("수량이 떨어졌습니다.");
        }
  }
  
  public void changePrice(int price) {
    this.price = price;
  }

  public void changeDesc(String desc) {
    this.pdesc = desc;
  }

  public void changeName(String name) {
    this.pname = name;
  }



}
