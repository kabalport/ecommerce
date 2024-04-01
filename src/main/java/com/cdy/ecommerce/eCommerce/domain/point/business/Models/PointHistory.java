package com.cdy.ecommerce.eCommerce.domain.point.business.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "ecommerce_point_history")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PointHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_history_id")
    private Long id;
    private Long userId;
    private Long amount;
    private TransactionType type;
    private Long updateMillis;
}
