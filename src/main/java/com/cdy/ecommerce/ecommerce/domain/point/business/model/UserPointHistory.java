package com.cdy.ecommerce.ecommerce.domain.point.business.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ecommerce_user_point_history")
public class UserPointHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_point_history_id")
    private Long id;

    @Column(name = "change_amount")
    private Long changeAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "change_type")
    private ChangeType changeType;

    @Column(name = "change_time")
    private LocalDateTime changeTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_point_id")
    private UserPoint userPoint;
}
