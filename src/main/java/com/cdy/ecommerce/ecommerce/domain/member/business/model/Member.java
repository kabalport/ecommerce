package com.cdy.ecommerce.ecommerce.domain.member.business.model;

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
@Table(name = "member_info")
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long memberId;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "nick_name")
  private String nickName;

  @Column(name = "email")
  private String email;

  @Column(name = "pw")
  private String pw;

  @ElementCollection(fetch = FetchType.LAZY)
  @Builder.Default
  @Column(name = "member_role")
  private List<MemberRole> memberRoleList = new ArrayList<>();

  public void addRole(MemberRole memberRole) {
    memberRoleList.add(memberRole);
  }
}