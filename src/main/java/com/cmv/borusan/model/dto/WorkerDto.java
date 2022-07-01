package com.cmv.borusan.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class WorkerDto {

    private Long id;
    private String name;
    private String surname;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private String createUser;
    private String updateUser;
}
