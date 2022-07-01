package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.SubLocationDto;
import com.cmv.borusan.model.entity.SubLocation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class SubLocationMapper {
    public static SubLocationDto mapTo(SubLocation subLocation){
        SubLocationDto subLocationDto = new SubLocationDto();
        subLocationDto.setId(subLocation.getId());
        subLocationDto.setLocationDto(LocationMapper.mapTo(subLocation.getLocation()));
        subLocationDto.setName(subLocation.getName().toString());
        subLocationDto.setDescription(subLocation.getDescription());
        subLocationDto.setUpdatedAt(subLocation.getUpdatedAt());
        subLocationDto.setCreatedAt(subLocation.getCreatedAt());
        subLocationDto.setUpdateUser(subLocation.getUpdateUser());
        subLocationDto.setCreateUser(subLocation.getCreateUser());
        return subLocationDto;
    }

    public static SubLocation mapTo(SubLocationDto subLocationDto){
        SubLocation subLocation = new SubLocation();
        subLocation.setId(subLocationDto.getId());
        subLocation.setName(subLocationDto.getName());
        subLocation.setDescription(subLocationDto.getDescription());
        subLocation.setUpdatedAt(LocalDateTime.now());
        subLocation.setCreatedAt(LocalDateTime.now());
        subLocation.setUpdateUser(subLocationDto.getUpdateUser());
        subLocation.setCreateUser(subLocationDto.getCreateUser());
        return subLocation;
    }

    public static SubLocation updateSubLocation(SubLocation entity, SubLocationDto dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdateUser(dto.getUpdateUser());
        return entity;
    }

    public static List<SubLocationDto> mapToList(List<SubLocation> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(SubLocationMapper::mapTo).collect(Collectors.toList());
    }


}
