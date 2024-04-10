package com.cdy.ecommerce.ecommerce.api.point.usecase;


import com.cdy.ecommerce.ecommerce.api.v1.account.usecase.ChargeBalanceUseCase;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountManager;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountReader;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountTransactionManager;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountValidator;
import com.cdy.ecommerce.ecommerce.domain.member.business.component.MemberReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ChargeUserPointUseCaseTest {
    ChargeBalanceUseCase chargeBalanceUseCase;
    AccountValidator accountValidator;
    MemberReader memberReader;
    AccountReader accountReader;
    AccountManager accountManager;
    AccountTransactionManager accountTransactionManager;

    @BeforeEach
    void setUp(){
        chargeBalanceUseCase = Mockito.mock(ChargeBalanceUseCase.class);
        accountValidator = Mockito.mock(AccountValidator.class);
        memberReader = Mockito.mock(MemberReader.class);
        accountReader = Mockito.mock(AccountReader.class);
        accountManager = Mockito.mock(AccountManager.class);
        accountTransactionManager = Mockito.mock(AccountTransactionManager.class);
    }

    @Test
    @DisplayName("잔액충전로직검증_충전금이_1이상인경우")
    void 잔액충전로직검증_충전금이_1이상인경우(){
        // given
        String userId = "user0";
        Long ChargeAmount = 1L;

        // when

        // then
    }

}