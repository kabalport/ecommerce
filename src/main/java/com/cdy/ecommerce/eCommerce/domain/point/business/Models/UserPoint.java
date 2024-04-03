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
public class UserPoint{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_point_id")
    private Long id;

    private Long memberId;

    private Long point;

    private Long updateMillis;

    // UserPoint 클래스 내에 추가
    public static UserPoint empty(Long memberId) {
        return UserPoint.builder()
                .memberId(memberId)
                .point(0L)
                .updateMillis(System.currentTimeMillis()) // 현재 시간으로 설정
                .build();
    }


}
