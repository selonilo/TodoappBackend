package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.NumberPlateDto;
import com.cmv.borusan.model.entity.NumberPlate;

import java.util.List;
import java.util.stream.Collectors;

public class NumberPlateMapper {

    public static NumberPlateDto mapTo(NumberPlate numberPlate){
        NumberPlateDto numberPlateDto = new NumberPlateDto();
        numberPlateDto.setId(numberPlate.getId());
        numberPlateDto.setName(numberPlate.getName().toString());
        return numberPlateDto;
    }

    public static NumberPlate mapTo(NumberPlateDto numberPlateDto){
        NumberPlate numberPlate = new NumberPlate();
        numberPlate.setId(numberPlateDto.getId());
        numberPlate.setName(numberPlateDto.getName());
        return numberPlate;
    }

    public static List<NumberPlateDto> mapToList(List<NumberPlate> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(NumberPlateMapper::mapTo).collect(Collectors.toList());
    }
}
