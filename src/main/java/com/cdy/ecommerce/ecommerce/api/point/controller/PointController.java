package com.cdy.ecommerce.ecommerce.api.point.controller;

import com.cdy.ecommerce.ecommerce.api.point.dto.PointDTO;
import com.cdy.ecommerce.ecommerce.api.point.usecase.ChargeUserPointUseCase;
import com.cdy.ecommerce.ecommerce.api.point.usecase.GetUserPointUseCase;
import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/point")
public class PointController {
    private final GetUserPointUseCase getUserPointUseCase;
    private final ChargeUserPointUseCase chargeUserPointUseCase;

    /**
     * 잔액 조회 API
     * 사용자 식별자를 통해 해당 사용자의 잔액을 조회합니다.
     */
    @GetMapping("/{memberId}")
    public PointDTO.Response getPoint(@PathVariable Long memberId){
        // 포인트조회
        UserPoint userPoint = getUserPointUseCase.execute(memberId);
        // 기존포인트 반환
        return entityToDTO(userPoint);
    }
    /**
     * 잔액 충전 API
     * 사용자 식별자 및 충전할 금액을 받아 잔액을 충전합니다.
     */
    @PatchMapping("/charge")
    public PointDTO.Response chargePoint(@RequestBody PointDTO.Request request) {
        // 포인트 충전
        UserPoint response = chargeUserPointUseCase.execute(request);
        // 충전포인트 반환
        return entityToDTO(response);
    }

    private PointDTO.Response entityToDTO(UserPoint userPoint) {
        // 변환
        return PointDTO.Response.builder().point(userPoint.getPoint()).build();
    }
}