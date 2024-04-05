package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.UserPointReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserPointReaderCoreRepository implements UserPointReaderRepository {

    private final UserPointJpaRepository userPointJpaRepository;

    @Override
    public Optional<UserPoint> selectUserPoint(Long memberId) {
        // JpaRepository는 findById를 제공합니다. 여기서는 예시로 사용됩니다.
        // 실제 요구 사항에 따라 커스텀 메소드를 구현해야 할 수 있습니다.
        return userPointJpaRepository.findById(memberId);
    }
}
