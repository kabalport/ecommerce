package com.cdy.ecommerce.eCommerce.domain.point.business.repository;

import net.dodoinfo.sbserver.domain.eCommerce.domain.point.business.entity.PointFailedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPointFailedEventRepository extends JpaRepository<PointFailedEvent, Long> { }
