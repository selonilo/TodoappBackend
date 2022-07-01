package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.ProductSubGroupDetailDto;
import com.cmv.borusan.model.entity.ProductSubGroupDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProductSubGroupDetailMapper {

    public static ProductSubGroupDetailDto mapTo(ProductSubGroupDetail productSubGroupDetail){
        ProductSubGroupDetailDto productSubGroupDetailDto = new ProductSubGroupDetailDto();
        productSubGroupDetailDto.setId(productSubGroupDetail.getId());
        if(productSubGroupDetail.getProductSubGroup() != null){
            productSubGroupDetailDto.setProductSubGroupDto(ProductSubGroupMapper.mapTo(productSubGroupDetail.getProductSubGroup()));
            if(productSubGroupDetail.getProductSubGroup().getProductGroup()!=null){
                productSubGroupDetailDto.setProductGroupDto(ProductGroupMapper.mapTo(productSubGroupDetail.getProductSubGroup().getProductGroup()));
            }
        }
        productSubGroupDetailDto.setName(productSubGroupDetail.getName().toString());
        productSubGroupDetailDto.setUpdatedAt(productSubGroupDetail.getUpdatedAt());
        productSubGroupDetailDto.setCreatedAt(productSubGroupDetail.getCreatedAt());
        productSubGroupDetailDto.setUpdateUser(productSubGroupDetail.getUpdateUser());
        productSubGroupDetailDto.setCreateUser(productSubGroupDetail.getCreateUser());
        return productSubGroupDetailDto;
    }

    public static ProductSubGroupDetail mapTo(ProductSubGroupDetailDto productSubGroupDetailDto){
        ProductSubGroupDetail productSubGroupDetail = new ProductSubGroupDetail();
        productSubGroupDetail.setId(productSubGroupDetailDto.getId());
        productSubGroupDetail.setName(productSubGroupDetailDto.getName());
        productSubGroupDetail.setUpdatedAt(LocalDateTime.now());
        productSubGroupDetail.setCreatedAt(LocalDateTime.now());
        productSubGroupDetail.setUpdateUser(productSubGroupDetailDto.getUpdateUser());
        productSubGroupDetail.setCreateUser(productSubGroupDetailDto.getCreateUser());
        return productSubGroupDetail;
    }

    public static ProductSubGroupDetail updateProductSubGroupDetail(ProductSubGroupDetail entity, ProductSubGroupDetailDto dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdateUser(dto.getUpdateUser());
        return entity;
    }

    public static List<ProductSubGroupDetailDto> mapToList(List<ProductSubGroupDetail> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(ProductSubGroupDetailMapper::mapTo).collect(Collectors.toList());
    }
}
