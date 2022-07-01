package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.ProductGroupDto;
import com.cmv.borusan.model.entity.ProductGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProductGroupMapper {

    public static ProductGroupDto mapTo(ProductGroup productGroup){
        ProductGroupDto productGroupDto = new ProductGroupDto();
        productGroupDto.setId(productGroup.getId());
        productGroupDto.setName(productGroup.getName().toString());
        productGroupDto.setUpdatedAt(productGroup.getUpdatedAt());
        productGroupDto.setCreatedAt(productGroup.getCreatedAt());
        productGroupDto.setUpdateUser(productGroup.getUpdateUser());
        productGroupDto.setCreateUser(productGroup.getCreateUser());
        productGroupDto.setCalibration(productGroup.getCalibration());
        productGroupDto.setProductAreaList(productGroup.getProductAreas().stream().map(productArea -> productArea.getId()).collect(Collectors.toList()));


        return productGroupDto;
    }

    public static ProductGroup mapTo(ProductGroupDto productGroupDto){
        ProductGroup productGroup = new ProductGroup();
        productGroup.setId(productGroupDto.getId());
        productGroup.setName(productGroupDto.getName());
        productGroup.setUpdatedAt(LocalDateTime.now());
        productGroup.setCreatedAt(LocalDateTime.now());
        productGroup.setUpdateUser(productGroupDto.getUpdateUser());
        productGroup.setCreateUser(productGroupDto.getCreateUser());
        productGroup.setCalibration(productGroupDto.getCalibration());
        return productGroup;
    }

    public static ProductGroup updateProductGroup(ProductGroup entity, ProductGroupDto dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdateUser(dto.getUpdateUser());
        entity.setCalibration(dto.getCalibration());
        return entity;
    }

    public static List<ProductGroupDto> mapToList(List<ProductGroup> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(ProductGroupMapper::mapTo).collect(Collectors.toList());
    }
}
