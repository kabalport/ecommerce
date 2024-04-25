package com.cdy.ecommerce.account.stub;

import com.cdy.ecommerce.ecommerce.admin.v1.account.controller.AccountDTO;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;


public class AccountFixture {

    public static Member givenMember(){
        return Member.builder().userId("user0").build();
    }
    public static Account expectAccount(){
        return Account.empty(givenMember());
    }
    public static Account expectChargeAccount(){
        return Account.builder().member(givenMember()).balance(1000).build();
    }

    public static AccountDTO.Request addAccountRequest() {
        final String userId = "user0";
        final int balance = 1000;
        return new AccountDTO.Request(userId,balance);
    }


    public static AccountDTO.Request addNegativeBalanceRequest() {
        final String userId = "user0";
        final int amount = -900000;
        return new AccountDTO.Request(userId,amount);
    }
}
