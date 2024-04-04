package com.cdy.ecommerce.ecommerce.domain.point.infrastructure;

import com.cdy.ecommerce.ecommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.ecommerce.domain.point.business.Repositories.UserPointReaderRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPointJpaRepository extends JpaRepository<UserPoint, Long>  {


}
