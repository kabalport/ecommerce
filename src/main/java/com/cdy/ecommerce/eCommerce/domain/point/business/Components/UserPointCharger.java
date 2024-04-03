package com.cdy.ecommerce.eCommerce.domain.point.business.Components;

import com.cdy.ecommerce.eCommerce.api.point.dto.PointDTO;
import com.cdy.ecommerce.eCommerce.domain.common.exception.PointException;
import com.cdy.ecommerce.eCommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.eCommerce.domain.point.business.Repositories.UserPointChargerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
@AllArgsConstructor
public class UserPointCharger {
    private final ConcurrentHashMap<Long, Lock> locks = new ConcurrentHashMap<>();
    private final UserPointChargerRepository userPointChargerRepository;

    public UserPoint charge2(PointDTO.Request request) {

//        Optional<UserPoint> currentPointOptional = userPointChargerRepository.findById(memberId);

        return null;
    }


    public PointDTO.Response charge(Long memberId, PointDTO.Request request) {
        Lock lock = locks.computeIfAbsent(memberId, k -> new ReentrantLock());
        boolean lockAcquired = lock.tryLock();
        if (!lockAcquired) {
            throw new PointException("현재 처리 중입니다. 잠시 후 다시 시도해주세요.");
        }
        try {
            Optional<UserPoint> currentPointOptional = userPointChargerRepository.findById(memberId);

            if (!currentPointOptional.isPresent()) {
                throw new PointException("아이디가 없습니다.");
            }
            UserPoint currentPoint = currentPointOptional.get();

            if (request.getAmount() < 0) {
                throw new PointException("충전 포인트는 음수가 될 수 없습니다.");
            }

            long updatedPoints = currentPoint.getPoint() + request.getAmount();
            UserPoint updatedUserPoint = UserPoint.builder()
                    .id(memberId) // 사용자 ID 설정
                    .point(updatedPoints)
                    .build();

            userPointChargerRepository.save(updatedUserPoint);

            // 반환 타입을 PointDTO.Response로 맞춰주기 위한 변환
            return PointDTO.Response.builder()
                    .point(updatedUserPoint.getPoint())
                    .build();
        } finally {
            if (lockAcquired) {
                lock.unlock();
                locks.remove(memberId); // 작업 완료 후 lock 객체 제거
            }
        }
    }
}
