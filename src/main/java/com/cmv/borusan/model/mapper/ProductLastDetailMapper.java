package com.cmv.borusan.model.mapper;


import com.cmv.borusan.model.dto.ProductLastDetailDto;
import com.cmv.borusan.model.entity.ProductLastDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProductLastDetailMapper {

    public static ProductLastDetailDto mapTo(ProductLastDetail productLastDetail){
        ProductLastDetailDto productLastDetailDto = new ProductLastDetailDto();
        productLastDetailDto.setId(productLastDetail.getId());
        if(productLastDetail.getProductSubGroupDetail() != null){
            productLastDetailDto.setProductSubGroupDetailDto(ProductSubGroupDetailMapper.mapTo(productLastDetail.getProductSubGroupDetail()));
            if(productLastDetail.getProductSubGroupDetail().getProductSubGroup()!=null){
                productLastDetailDto.setProductSubGroupDto(ProductSubGroupMapper.mapTo(productLastDetail.getProductSubGroupDetail().getProductSubGroup()));
                if (productLastDetail.getProductSubGroupDetail().getProductSubGroup().getProductGroup()!=null){
                    productLastDetailDto.setProductGroupDto(ProductGroupMapper.mapTo(productLastDetail.getProductSubGroupDetail().getProductSubGroup().getProductGroup()));
                }
            }
        }
        productLastDetailDto.setName(productLastDetail.getName().toString());
        productLastDetailDto.setUpdatedAt(productLastDetail.getUpdatedAt());
        productLastDetailDto.setCreatedAt(productLastDetail.getCreatedAt());
        productLastDetailDto.setUpdateUser(productLastDetail.getUpdateUser());
        productLastDetailDto.setCreateUser(productLastDetail.getCreateUser());
        return productLastDetailDto;
    }

    public static ProductLastDetail mapTo(ProductLastDetailDto productLastDetailDto){
        ProductLastDetail productLastDetail = new ProductLastDetail();
        productLastDetail.setId(productLastDetailDto.getId());
        productLastDetail.setName(productLastDetailDto.getName());
        productLastDetail.setUpdatedAt(LocalDateTime.now());
        productLastDetail.setCreatedAt(LocalDateTime.now());
        productLastDetail.setUpdateUser(productLastDetailDto.getUpdateUser());
        productLastDetail.setCreateUser(productLastDetailDto.getCreateUser());
        return productLastDetail;
    }

    public static ProductLastDetail updateProductLastDetail(ProductLastDetail entity, ProductLastDetailDto dto){
        entity.setName(dto.getName());
        entity.setId(dto.getId());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdateUser(dto.getUpdateUser());
        return entity;
    }

    public static List<ProductLastDetailDto> mapToList(List<ProductLastDetail> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(ProductLastDetailMapper::mapTo).collect(Collectors.toList());
    }
}
