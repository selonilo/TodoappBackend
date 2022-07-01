package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.ProductSubGroupDto;
import com.cmv.borusan.model.entity.ProductSubGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProductSubGroupMapper {

    public static ProductSubGroupDto mapTo(ProductSubGroup productSubGroup){
        ProductSubGroupDto productSubGroupDto = new ProductSubGroupDto();
        productSubGroupDto.setId(productSubGroup.getId());
        productSubGroupDto.setName(productSubGroup.getName().toString());
        productSubGroupDto.setProductGroupDto(ProductGroupMapper.mapTo(productSubGroup.getProductGroup()));
        productSubGroupDto.setUpdatedAt(productSubGroup.getUpdatedAt());
        productSubGroupDto.setCreatedAt(productSubGroup.getCreatedAt());
        productSubGroupDto.setUpdateUser(productSubGroup.getUpdateUser());
        productSubGroupDto.setCreateUser(productSubGroup.getCreateUser());
        return productSubGroupDto;
    }

    public static ProductSubGroup mapTo(ProductSubGroupDto productSubGroupDto){
        ProductSubGroup productSubGroup = new ProductSubGroup();
        productSubGroup.setId(productSubGroupDto.getId());
        productSubGroup.setName(productSubGroupDto.getName());
        productSubGroup.setUpdatedAt(LocalDateTime.now());
        productSubGroup.setCreatedAt(LocalDateTime.now());
        productSubGroup.setUpdateUser(productSubGroupDto.getUpdateUser());
        productSubGroup.setCreateUser(productSubGroupDto.getCreateUser());
        return productSubGroup;
    }

    public static ProductSubGroup updateProductSubGroup(ProductSubGroup entity, ProductSubGroupDto dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdateUser(dto.getUpdateUser());
        return entity;
    }

    public static List<ProductSubGroupDto> mapToList(List<ProductSubGroup> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(ProductSubGroupMapper::mapTo).collect(Collectors.toList());
    }
}
