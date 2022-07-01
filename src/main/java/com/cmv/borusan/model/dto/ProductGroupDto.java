package com.cmv.borusan.model.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductGroupDto {

    private Long id;
    private String name;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private String createUser;
    private String updateUser;
    private List<Long> productAreaList;
    private Boolean calibration;
}
