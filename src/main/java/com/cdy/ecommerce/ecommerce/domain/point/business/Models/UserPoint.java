package com.cdy.ecommerce.ecommerce.domain.point.business.Models;

import com.cdy.ecommerce.ecommerce.domain.member.business.Models.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "ecommerce_user_point", indexes = {@Index(name = "idx_user_point_member_id", columnList = "member")})
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
    @JoinColumn(name = "member")
    private Member member;

    public UserPoint(Member member, Long point) {
        this.member = member;
        this.point = point;
    }

    public static UserPoint empty(Member member) {
        return new UserPoint(member, 0L);
    }

    public void addPoints(Long amount) {
        this.point += amount;
    }
}
