package com.cdy.ecommerce.eCommerce.domain.point.business.Components;

import com.cdy.ecommerce.eCommerce.api.point.dto.PointDTO;
import com.cdy.ecommerce.eCommerce.api.product.dto.ProductDTO;
import com.cdy.ecommerce.eCommerce.domain.point.business.Models.UserPoint;
import com.cdy.ecommerce.eCommerce.domain.point.business.Repositories.UserPointReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PointReader {

    private final UserPointReaderRepository userPointReaderRepository;

    public PointDTO.Response read(Long id) {
        // 포인트존재유무
        Optional<UserPoint> result = userPointReaderRepository.selectOne(id);

        UserPoint userPoint = result.orElseThrow();

        PointDTO.Response pointDTO = entityToDTO(userPoint);


        return pointDTO;
    }

    private PointDTO.Response entityToDTO(UserPoint userPoint) {

        PointDTO.Response pointDTO =
                PointDTO.Response.builder()
                        .id(userPoint.getId())
                        .point(userPoint.getPoint())
                        .build();

        return pointDTO;
    }
}
