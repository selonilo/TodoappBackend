package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.LocationDto;
import com.cmv.borusan.model.entity.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class LocationMapper {

    public static LocationDto mapTo(Location location){
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setName(location.getName().toString());
        locationDto.setUpdatedAt(location.getUpdatedAt());
        locationDto.setCreatedAt(location.getCreatedAt());
        locationDto.setUpdateUser(location.getUpdateUser());
        locationDto.setCreateUser(location.getCreateUser());
        return locationDto;
    }

    public static Location mapTo(LocationDto locationDto){
        Location location = new Location();
        location.setId(locationDto.getId());
        location.setName(locationDto.getName());
        location.setUpdatedAt(LocalDateTime.now());
        location.setCreatedAt(LocalDateTime.now());
        location.setUpdateUser(locationDto.getUpdateUser());
        location.setCreateUser(locationDto.getCreateUser());
        return location;
    }

    public static Location updateLocation(Location entity, LocationDto dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdateUser(dto.getUpdateUser());
        return entity;
    }

    public static List<LocationDto> mapToList(List<Location> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(LocationMapper::mapTo).collect(Collectors.toList());
    }
}
