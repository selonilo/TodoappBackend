package com.cmv.borusan.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProductSubGroupDetailDto {

    private Long id;
    private String name;
    private Long productSubGroupId;
    private ProductSubGroupDto productSubGroupDto;
    private ProductGroupDto productGroupDto;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private String createUser;
    private String updateUser;
}
