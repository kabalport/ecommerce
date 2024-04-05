package com.cdy.ecommerce.ecommerce.domain.point.business.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "ecommerce_user_point")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_point_id")
    private Long id;

    private Long memberId;

    private Long point;

    @Enumerated(EnumType.STRING)
    private PointAction pointAction;



    public static UserPoint empty(Long memberId) {
        return UserPoint.builder()
                .memberId(memberId)
                .point(0L)
                .build();
    }
}
