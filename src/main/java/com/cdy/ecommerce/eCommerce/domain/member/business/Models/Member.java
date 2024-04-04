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
//@Table(name = "member_info")
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long memberId;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "pw")
  private String pw;

  @Column(name = "nickName")
  private String nickname;

  @ElementCollection(fetch = FetchType.LAZY)
  @Builder.Default
  @Column(name = "member_role")
  private List<MemberRole> memberRoleList = new ArrayList<>();

  public void addRole(MemberRole memberRole) {

    memberRoleList.add(memberRole);
  }

}
