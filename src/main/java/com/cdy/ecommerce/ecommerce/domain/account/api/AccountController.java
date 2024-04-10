package com.cdy.ecommerce.ecommerce.domain.account.api;

import com.cdy.ecommerce.ecommerce.domain.account.business.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {
    private final GetBalanceUseCase getBalanceUseCase;
    private final ChargeBalanceUseCase chargeBalanceUseCase;

    /**
     * 잔액 조회 api
     * 사용자 식별자를 통해 해당 사용자의 잔액을 조회합니다.
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public AccountDTO.Response getBalance(@PathVariable String userId){
        // 잔액조회
        Account account = getBalanceUseCase.execute(userId);
        // 기존잔액 반환
        return entityToDTO(account);
    }

    /**
     * 잔액 충전 api
     * 사용자 식별자 및 충전할 금액을 받아 잔액을 충전합니다.
     * @param request
     * @return
     */
    @PatchMapping("/charge")
    public AccountDTO.Response chargeBalance(@RequestBody AccountDTO.Request request){
        // 잔액충전
        Account response = chargeBalanceUseCase.execute(request);
        // 충전잔액 반환
        return entityToDTO(response);
    }

    private AccountDTO.Response entityToDTO(Account account){
        return AccountDTO.Response.builder().balance(account.getBalance()).build();
    }
}
