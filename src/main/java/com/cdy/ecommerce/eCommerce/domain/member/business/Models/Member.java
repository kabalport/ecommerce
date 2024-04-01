package com.cdy.ecommerce.eCommerce.domain.member.business.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "memberRoleList")
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberId;

  private String userId;

  private String pw;

  private String nickname;

  @ElementCollection(fetch = FetchType.LAZY)
  @Builder.Default
  private List<MemberRole> memberRoleList = new ArrayList<>();

  public void addRole(MemberRole memberRole) {

    memberRoleList.add(memberRole);
  }

}
