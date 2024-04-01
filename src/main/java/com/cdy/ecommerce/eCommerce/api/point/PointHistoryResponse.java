package com.cdy.ecommerce.eCommerce.api.point;


import lombok.AllArgsConstructor;
import lombok.Getter;
import net.dodoinfo.sbserver.domain.eCommerce.domain.point.business.TransactionType;
@Getter
public class PointHistoryResponse {
    private long id;
    private long userId;
    private long amount;
    private TransactionType type;
    private long updateMillis;

    // Constructors, Getters, and Setters
    public PointHistoryResponse(long id, long userId, long amount, TransactionType type, long updateMillis) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.updateMillis = updateMillis;
    }

    // Getters and setters...
}