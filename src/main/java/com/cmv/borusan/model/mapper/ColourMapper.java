package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.ColourDto;
import com.cmv.borusan.model.entity.Colour;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ColourMapper {

    public static ColourDto mapTo(Colour colour){
        ColourDto colourDto = new ColourDto();
        colourDto.setId(colour.getId());
        colourDto.setName(colour.getName().toString());
        return colourDto;
    }

    public static Colour mapTo(ColourDto colourDto){
        Colour colour = new Colour();
        colour.setId(colourDto.getId());
        colour.setName(colourDto.getName());
        return colour;
    }

    public static List<ColourDto> mapToList(List<Colour> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(ColourMapper::mapTo).collect(Collectors.toList());
    }
}
