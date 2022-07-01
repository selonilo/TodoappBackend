package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.SubLocationDetailDto;
import com.cmv.borusan.model.entity.SubLocationDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class SubLocationDetailMapper {

    public static SubLocationDetailDto mapTo(SubLocationDetail subLocationDetail) {
        SubLocationDetailDto subLocationDetailDto = new SubLocationDetailDto();
        subLocationDetailDto.setId(subLocationDetail.getId());
        if (subLocationDetail.getSubLocation() != null) {
            subLocationDetailDto.setSubLocationDto(SubLocationMapper.mapTo(subLocationDetail.getSubLocation()));
            if (subLocationDetail.getSubLocation().getLocation() != null) {
                subLocationDetailDto.setLocationDto(LocationMapper.mapTo(subLocationDetail.getSubLocation().getLocation()));
            }
        }

        subLocationDetailDto.setName(subLocationDetail.getName().toString());
        subLocationDetailDto.setUpdatedAt(subLocationDetail.getUpdatedAt());
        subLocationDetailDto.setCreatedAt(subLocationDetail.getCreatedAt());
        subLocationDetailDto.setUpdateUser(subLocationDetail.getUpdateUser());
        subLocationDetailDto.setCreateUser(subLocationDetail.getCreateUser());
        return subLocationDetailDto;
    }

    public static SubLocationDetail mapTo(SubLocationDetailDto subLocationDetailDto) {
        SubLocationDetail subLocationDetail = new SubLocationDetail();
        subLocationDetail.setId(subLocationDetailDto.getId());
        subLocationDetail.setName(subLocationDetailDto.getName());
        subLocationDetail.setUpdatedAt(LocalDateTime.now());
        subLocationDetail.setCreatedAt(LocalDateTime.now());
        subLocationDetail.setUpdateUser(subLocationDetailDto.getUpdateUser());
        subLocationDetail.setCreateUser(subLocationDetailDto.getCreateUser());
        return subLocationDetail;
    }

    public static SubLocationDetail updateSubLocationDetail(SubLocationDetail entity, SubLocationDetailDto dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdateUser(dto.getUpdateUser());
        return entity;
    }

    public static List<SubLocationDetailDto> mapToList(List<SubLocationDetail> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream().map(SubLocationDetailMapper::mapTo).collect(Collectors.toList());
    }
}
