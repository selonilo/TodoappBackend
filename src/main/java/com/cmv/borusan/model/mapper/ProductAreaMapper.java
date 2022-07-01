package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.ProductAreaDto;
import com.cmv.borusan.model.entity.ProductArea;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProductAreaMapper {

    public static ProductAreaDto mapTo(ProductArea productArea){
        ProductAreaDto productAreaDto = new ProductAreaDto();
        productAreaDto.setId(productArea.getId());
        productAreaDto.setName(productArea.getName().toString());
        return productAreaDto;
    }

    public static ProductArea mapTo(ProductAreaDto productAreaDto){
        ProductArea productArea = new ProductArea();
        productArea.setId(productAreaDto.getId());
        productArea.setName(productAreaDto.getName());
        return productArea;
    }

    public static ProductArea updateProductArea(ProductArea entity, ProductAreaDto dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public static List<ProductAreaDto> mapToList(List<ProductArea> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(ProductAreaMapper::mapTo).collect(Collectors.toList());
    }
}
