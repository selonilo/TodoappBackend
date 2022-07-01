package com.cmv.borusan.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SubLocationDetailDto {

    private Long id;
    private String name;
    private Long subLocationId;
    private SubLocationDto subLocationDto;
    private LocationDto locationDto;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private String createUser;
    private String updateUser;
}
