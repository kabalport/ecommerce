package com.cdy.ecommerce.usecase.account;


import com.cdy.ecommerce.ecommerce.api.v1.account.usecase.ChargeBalanceUseCase;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountManager;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountReader;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountTransactionManager;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountValidator;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.AccountError;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.AccountException;
import com.cdy.ecommerce.ecommerce.domain.member.business.component.MemberReader;
import com.cdy.ecommerce.usecase.account.stub.AccountSteps;
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
        var expectMember = AccountSteps.givenMember();
        var minusRequest = AccountSteps.addNegativeBalanceRequest();
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
        var expectMember = AccountSteps.givenMember();
        var expectAccount = AccountSteps.expectAccount();
        var expectChargeAccount = AccountSteps.expectChargeAccount();
        var request = AccountSteps.addAccountRequest();

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