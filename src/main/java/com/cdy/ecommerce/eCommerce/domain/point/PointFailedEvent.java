package com.cdy.ecommerce.eCommerce.domain.point;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "point_failed_event")
@Getter
@Builder
@NoArgsConstructor
public class PointFailedEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ecommerce_point_failed_event_id")
    private Long id; // 이벤트 ID
    private Long userId; // 사용자 ID
    private String operation; // 수행된 작업 유형 (예: "CHARGE", "USE")
    private Long amount; // 작업에 관련된 포인트 양
    private String errorMessage; // 오류 메시지
    private Long timestamp; // 이벤트가 발생한 시간 (밀리초 단위의 타임스탬프)


    public PointFailedEvent(long id, long userId, String operation, long amount, String errorMessage, long timestamp) {
        this.id = id;
        this.userId = userId;
        this.operation = operation;
        this.amount = amount;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }

}
