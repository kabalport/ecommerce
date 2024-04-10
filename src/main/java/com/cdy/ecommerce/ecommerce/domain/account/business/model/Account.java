package com.cdy.ecommerce.ecommerce.domain.account.business.model;

import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 계좌
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Member member;

    private BigDecimal balance;


    public static Account empty(Member member){
        return Account.builder()
                .member(member)
                .balance(BigDecimal.valueOf(0))
                .build();
    }

    public void charge(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void purchase(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }
}