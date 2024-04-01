package com.cdy.ecommerce.domain.point.business.repository;

import net.dodoinfo.sbserver.domain.eCommerce.domain.point.business.entity.PointHistory;
import net.dodoinfo.sbserver.domain.eCommerce.domain.point.business.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPointHistoryRepository extends JpaRepository<PointHistory, Long> { }
