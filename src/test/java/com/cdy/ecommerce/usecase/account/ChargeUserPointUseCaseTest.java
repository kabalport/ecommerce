package com.cdy.ecommerce.usecase.account;


import com.cdy.ecommerce.ecommerce.admin.v1.account.controller.AccountDTO;
import com.cdy.ecommerce.ecommerce.admin.v1.account.usecase.ChargeBalanceUseCase;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountManager;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountReader;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountTransactionManager;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountValidator;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.AccountError;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.AccountException;
import com.cdy.ecommerce.ecommerce.domain.member.business.component.MemberReader;
import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ChargeUserPointUseCaseTest {
    private ChargeBalanceUseCase chargeBalanceUseCase;
    private AccountValidator accountValidator;
    private MemberReader memberReader;
    private AccountReader accountReader;
    private AccountManager accountManager;
    private AccountTransactionManager accountTransactionManager;

    public static class AccountFixture {

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

    @BeforeEach
    void setUp(){
        accountValidator = Mockito.mock(AccountValidator.class);
        memberReader = Mockito.mock(MemberReader.class);
        accountReader = Mockito.mock(AccountReader.class);
        accountManager = Mockito.mock(AccountManager.class);
        accountTransactionManager = Mockito.mock(AccountTransactionManager.class);
        chargeBalanceUseCase = new ChargeBalanceUseCase(accountValidator,memberReader,accountReader,accountManager,accountTransactionManager);
    }
    @Test
    @DisplayName("음수 금액을 충전하려 할 때 예외 발생 확인")
    void chargeNegativeAmount() {
        var expectMember = AccountFixture.givenMember();
        var minusRequest = AccountFixture.addNegativeBalanceRequest();
        var errorMessage = AccountError.CHARGE_AMOUNT_MUST_BE_POSITIVE.getMessage();

        Mockito.when(memberReader.read(expectMember.getUserId())).thenReturn(expectMember);
        Mockito.when(accountReader.read(expectMember)).thenThrow(new AccountException(errorMessage));

        Exception exception = Assertions.assertThrows(AccountException.class, () -> {
            chargeBalanceUseCase.execute(minusRequest);
        });
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    @DisplayName("잔액충전로직검증_충전금_1000원을 충전한경우")
    void success1(){
        // Given
        var expectMember = AccountFixture.givenMember();
        var expectAccount = AccountFixture.expectAccount();
        var expectChargeAccount = AccountFixture.expectChargeAccount();
        var request = AccountFixture.addAccountRequest();

        Mockito.when(memberReader.read(expectMember.getUserId())).thenReturn(expectMember);
        Mockito.when(accountReader.read(expectMember)).thenReturn(expectAccount);
        Mockito.when(accountManager.charge(expectAccount)).thenReturn(expectChargeAccount);

        // When
        Account result = chargeBalanceUseCase.execute(request);

        // then
        assertNotNull(result, "결과 null 확인");
        assertEquals(expectChargeAccount.getBalance(), result.getBalance(), "예상잔고와 결과잔고 동일한지 확인");


        Mockito.verify(accountTransactionManager).add(result, request.getAmount());
    }



}