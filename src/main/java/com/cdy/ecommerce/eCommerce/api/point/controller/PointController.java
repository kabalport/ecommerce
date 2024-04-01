package com.cdy.ecommerce.eCommerce.api.point.controller;


import com.cdy.ecommerce.eCommerce.api.point.dto.PointDTO;

import com.cdy.ecommerce.eCommerce.api.point.usecase.GetUserPointUseCase;
import com.cdy.ecommerce.eCommerce.api.point.usecase.PointService;
import com.cdy.ecommerce.eCommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/point")
public class PointController {
    private final GetUserPointUseCase getUserPointUseCase;
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
//        UserPoint updatedUserPoint = pointService.chargePoint(memberId, request.getAmount());
//        return new PointDTO.Response(updatedUserPoint.getId(), updatedUserPoint.getPoint());
        return null;
    }
}
