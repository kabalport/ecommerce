package com.cdy.ecommerce.ecommerce.domain.account.business.model;

import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


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

    private int balance;


    public static Account empty(Member member){
        return Account.builder()
                .member(member)
                .balance(0)
                .build();
    }

    public void charge(int amount) {
        this.balance += amount; // amount를 balance에 추가
    }

    public void purchase(int amount) {
        this.balance -= amount; // balance에서 amount를 차감
    }
}