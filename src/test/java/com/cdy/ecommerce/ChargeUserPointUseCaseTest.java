package com.cdy.ecommerce;


import com.cdy.ecommerce.ecommerce.api.v1.account.usecase.ChargeBalanceUseCase;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountManager;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountReader;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountTransactionManager;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountValidator;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.member.business.component.MemberReader;
import com.cdy.ecommerce.ecommerce.domain.member.business.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
    @DisplayName("잔액충전로직검증_충전금이_1이상인경우")
    void 잔액충전로직검증_충전금이_1이상인경우(){
        // Given
        final String userId = "user0";
        final long chargeAmount = 100L;
        final Account existingAccount = Account.builder().build();
        final Account expectedAccountAfterCharge = Account.builder().build();
        final Member member = Member.builder().build();


        Mockito.when(accountReader.read(member)).thenReturn(existingAccount);
        // Then


    }



}