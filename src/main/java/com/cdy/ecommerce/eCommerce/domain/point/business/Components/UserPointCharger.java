package com.cdy.ecommerce.eCommerce.domain.point.business.Components;

import com.cdy.ecommerce.eCommerce.api.point.dto.PointDTO;
import com.cdy.ecommerce.eCommerce.api.product.dto.ProductDTO;
import com.cdy.ecommerce.eCommerce.domain.point.application.exception.PointException;
import com.cdy.ecommerce.eCommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.eCommerce.domain.point.business.Repositories.UserPointChargerRepository;
import com.cdy.ecommerce.eCommerce.domain.point.business.Repositories.UserPointReaderRepository;
import com.cdy.ecommerce.eCommerce.domain.point.infrastructure.UserPointJpaRepository;
import com.cdy.ecommerce.eCommerce.domain.product.business.Models.Product;
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

    public PointDTO.Response charge(Long memberId,PointDTO.Request request) {

        Lock lock = locks.computeIfAbsent(memberId, k -> new ReentrantLock());
        boolean lockAcquired = lock.tryLock();
        if (!lockAcquired) {
            throw new PointException("현재 처리 중입니다. 잠시 후 다시 시도해주세요.");
        }
        try {
            Optional<UserPoint> currentPoint = userPointChargerRepository.findById(memberId);
            if (currentPoint == null) {
                throw new PointException("아이디가 없습니다.");
            }
            if (request.getAmount() < 0) {
                throw new PointException("충전포인트는 음수가 될수 없습니다.");
            }
            long updatedPoints = currentPoint.get().getPoint() + request.getAmount();
            UserPoint updatedUserPoint = new UserPoint(memberId, updatedPoints, System.currentTimeMillis());
            userPointChargerRepository.save(updatedUserPoint);

       return null;
        } catch (PointException ex) {
            throw ex;
        } finally {
            if (lockAcquired) {
                lock.unlock();
            }
        }
    }

    private UserPoint dtoToEntity(PointDTO.Request PointDTO) {

        UserPoint userPoint = UserPoint.builder().point(PointDTO.getAmount()).build();

        return userPoint;
    }
}
