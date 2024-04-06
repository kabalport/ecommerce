package com.cdy.ecommerce.ecommerce.domain.point.business.Models;

import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "ecommerce_user_point", indexes = {@Index(name = "idx_user_point_member_id", columnList = "member_owner")})
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_point_id")
    private Long id;


    private Long point;


    @OneToOne
    @JoinColumn(name = "member_owner")
    private Member member;


    public static UserPoint empty() {
        return UserPoint.builder()
                .point(0L)
                .build();
    }
}
