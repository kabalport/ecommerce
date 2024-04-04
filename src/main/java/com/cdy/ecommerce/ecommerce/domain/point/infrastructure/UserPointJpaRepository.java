package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.UserPointReaderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPointJpaRepository extends JpaRepository<UserPoint, Long> {
    // selectUserPoint 메서드는 UserPointReaderRepository에서 정의되므로 여기서는 생략 가능
}
