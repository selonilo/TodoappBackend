package com.cmv.borusan.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProductSubGroupDto {

    private Long id;
    private String name;
    private Long productGroupId;
    private ProductGroupDto productGroupDto;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private String createUser;
    private String updateUser;
}
