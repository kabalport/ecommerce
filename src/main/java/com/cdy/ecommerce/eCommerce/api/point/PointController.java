package com.cdy.ecommerce.eCommerce.api.point;


import lombok.RequiredArgsConstructor;
import net.dodoinfo.sbserver.domain.eCommerce.domain.point.business.PointService;
import net.dodoinfo.sbserver.domain.eCommerce.domain.point.business.entity.PointHistory;
import net.dodoinfo.sbserver.domain.eCommerce.domain.point.business.entity.UserPoint;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/point")
public class PointController {
    private final PointService pointService;

    /**
     * 잔액 조회 API
     * 사용자 식별자를 통해 해당 사용자의 잔액을 조회합니다.
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public UserPointResponse point(@PathVariable long userId){
        UserPointResponse userPoint = pointService.getUserPointInfo(userId);
        return userPoint;
    }

    /**
     * 잔액 충전 API
     * 사용자 식별자 및 충전할 금액을 받아 잔액을 충전합니다.
     * @param userId
     * @param request
     * @return
     */
    @PatchMapping("{userid}/charge")
    public UserPointResponse charge(@PathVariable long userId, @RequestBody ChargePointRequest request) {
        UserPoint updatedUserPoint = pointService.chargePoint(userId, request.getAmount());
        return new UserPointResponse(updatedUserPoint.getId(), updatedUserPoint.getPoint());
    }



//
//    @GetMapping("{id}")
//    public UserPointResponse point(
//            @PathVariable long id
//    ) {
//        UserPoint userPoint = pointService.getPointById(id);
//        return new UserPointResponse(userPoint.getId(), userPoint.getPoint());
//    }
//
//    @GetMapping("{id}/histories")
//    public List<PointHistory> history(
//            @PathVariable long id
//    ) {
//        List<PointHistory> historyList = pointService.getHistoriesByUserId(id);
//        return historyList;
//    }
//

//
//    @PatchMapping("{id}/use")
//    public UserPointResponse use(
//            @PathVariable long id, @RequestBody ChargePointRequest request) {
//        UserPoint updatedUserPoint = pointService.usePoint(id, request.getAmount());
//        return new UserPointResponse(updatedUserPoint.getId(), updatedUserPoint.getPoint());
//    }
}
