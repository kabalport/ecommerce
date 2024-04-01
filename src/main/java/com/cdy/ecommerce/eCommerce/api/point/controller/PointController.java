package com.cdy.ecommerce.eCommerce.api.point.controller;

import com.cdy.ecommerce.eCommerce.api.point.dto.PointDTO;
import com.cdy.ecommerce.eCommerce.api.point.usecase.ChargeUserPointUseCase;
import com.cdy.ecommerce.eCommerce.api.point.usecase.GetUserPointUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/point")
public class PointController {
    private final GetUserPointUseCase getUserPointUseCase;

    private final ChargeUserPointUseCase chargeUserPointUseCase;
    /**
     * 잔액 조회 API
     * 사용자 식별자를 통해 해당 사용자의 잔액을 조회합니다.
     * @param memberId
     * @return
     */
    @GetMapping("/{memberId}")
    public PointDTO.Response point(@PathVariable long memberId){
        return getUserPointUseCase.execute(memberId);
    }
    /**
     * 잔액 충전 API
     * 사용자 식별자 및 충전할 금액을 받아 잔액을 충전합니다.
     * @param memberId
     * @param request
     * @return
     */
    @PatchMapping("{memberId}/charge")
    public PointDTO.Response charge(@PathVariable long memberId, @RequestBody PointDTO.Request request) {
       PointDTO.Response response = chargeUserPointUseCase.execute(memberId,request);
       return response;
    }
}