package com.cdy.ecommerce.eCommerce.api.point;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChargePointRequest {
    private long amount;

    // Getters and setters
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
