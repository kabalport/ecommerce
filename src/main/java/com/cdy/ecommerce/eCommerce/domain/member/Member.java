package com.cdy.ecommerce.eCommerce.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Member {
  @Id
  private String email;

  private String pw;

  private String nickname;

  public void changeNickname(String nickname) {
    this.nickname = nickname;
  }

  public void changePw(String pw) {
    this.pw = pw;
  }

}
