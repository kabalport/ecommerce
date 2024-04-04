package com.cdy.ecommerce.eCommerce.domain.point.business.Models;

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
    private String id;

    private Long memberId;

    private Long point;

    @Enumerated(EnumType.STRING)
    private PointAction pointAction;

    // 커스텀 UUID 생성
    private static String generateCustomUUID(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString();
    }

    public static UserPoint empty(Long memberId) {
        return UserPoint.builder()
                .id(generateCustomUUID("CUST")) // 예시 prefix "CUST" 사용
                .memberId(memberId)
                .point(0L)
                .build();
    }
}
