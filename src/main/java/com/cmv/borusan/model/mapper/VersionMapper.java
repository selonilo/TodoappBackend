package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.VersionDto;
import com.cmv.borusan.model.entity.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class VersionMapper {
    public static VersionDto mapTo(Version version){
        VersionDto versionDto = new VersionDto();
        versionDto.setId(version.getId());
        versionDto.setVersion(version.getVersion().toString());
        return versionDto;
    }

    public static Version mapTo(VersionDto versionDto){
        Version version = new Version();
        version.setId(versionDto.getId());
        version.setVersion(versionDto.getVersion());
        return version;
    }

    public static List<VersionDto> mapToList(List<Version> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(VersionMapper::mapTo).collect(Collectors.toList());
    }
}
