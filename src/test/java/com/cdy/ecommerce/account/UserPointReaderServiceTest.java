package com.cdy.ecommerce.account;

import com.cdy.ecommerce.ecommerce.admin.v1.account.usecase.GetBalanceUseCase;
import com.cdy.ecommerce.ecommerce.domain.account.business.components.AccountReader;
import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import com.cdy.ecommerce.ecommerce.domain.member.business.component.MemberReader;
import com.cdy.ecommerce.account.stub.AccountFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 잔고조회
 */
class UserPointReaderServiceTest {
    private GetBalanceUseCase getBalanceUseCase;
    private AccountReader accountReader;
    private MemberReader memberReader;

    @BeforeEach
    void setUp(){
        memberReader = Mockito.mock(MemberReader.class);
        accountReader = Mockito.mock(AccountReader.class);
        getBalanceUseCase = new GetBalanceUseCase(accountReader,memberReader);
    }

    @Test
    @DisplayName("잔고를조회합니다.")
    void 잔고조회(){
        //given
        var expectMember = AccountFixture.givenMember();
        var expectAccount = AccountFixture.expectAccount();
        Mockito.when(memberReader.read(expectMember.getUserId())).thenReturn(expectMember);
        Mockito.when(accountReader.read(expectMember)).thenReturn(expectAccount);
        //when
        Account result = getBalanceUseCase.execute(expectMember.getUserId());
        //then
        assertNotNull(result, "결과 null 확인");
        assertEquals(expectAccount.getBalance(), result.getBalance(), "예상잔고와 결과잔고 동일한지 확인");
    }

}
