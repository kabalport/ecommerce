package com.cdy.ecommerce.domain.point;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.dodoinfo.sbserver.domain.eCommerce.domain.point.business.TransactionType;
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
