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
    private Long point;
    private Long updateMillis;

    public static UserPoint empty(long id) {
        return new UserPoint(id, 0L, System.currentTimeMillis());
    }

}
