package com.cdy.ecommerce.eCommerce.domain.point.business.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ecommerce_user_point")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_point_id")
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "user_point_point")
    private Long point;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_point_pointAction")
    private PointAction pointAction;

    public static UserPoint empty(Long memberId) {
        return UserPoint.builder()
                .memberId(memberId)
                .point(0L)
                .build();
    }
}
