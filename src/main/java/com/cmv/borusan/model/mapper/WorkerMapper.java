package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.WorkerDto;
import com.cmv.borusan.model.entity.Worker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class WorkerMapper {

    public static WorkerDto mapTo(Worker worker){
        WorkerDto workerDto = new WorkerDto();
        workerDto.setId(worker.getId());
        workerDto.setName(worker.getName().toString());
        workerDto.setSurname(worker.getSurname());
        workerDto.setUpdatedAt(worker.getUpdatedAt());
        workerDto.setCreatedAt(worker.getCreatedAt());
        workerDto.setUpdateUser(worker.getUpdateUser());
        workerDto.setCreateUser(worker.getCreateUser());
        return workerDto;
    }

    public static Worker mapTo(WorkerDto workerDto){
        Worker worker = new Worker();
        worker.setId(workerDto.getId());
        worker.setName(workerDto.getName());
        worker.setSurname(workerDto.getSurname());
        worker.setUpdatedAt(LocalDateTime.now());
        worker.setCreatedAt(LocalDateTime.now());
        worker.setUpdateUser(workerDto.getUpdateUser());
        worker.setCreateUser(workerDto.getUpdateUser());
        return worker;
    }

    public static Worker updateWorker(Worker entity, WorkerDto dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdateUser(dto.getUpdateUser());
        return entity;
    }

    public static List<WorkerDto> mapToList(List<Worker> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(WorkerMapper::mapTo).collect(Collectors.toList());
    }
}
