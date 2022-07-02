package com.salih.todo.model.mapper;

import com.salih.todo.model.dto.TodoDto;
import com.salih.todo.model.entity.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class TodoMapper {
    public static TodoDto mapTo(Todo todo){
        TodoDto todoDto = new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setName(todo.getName().toString());
        todoDto.setUpdatedAt(todo.getUpdatedAt());
        todoDto.setCreatedAt(todo.getCreatedAt());
        return todoDto;
    }

    public static Todo mapTo(TodoDto todoDto){
        Todo todo = new Todo();
        todo.setId(todoDto.getId());
        todo.setName(todoDto.getName());
        todo.setUpdatedAt(LocalDateTime.now());
        todo.setCreatedAt(LocalDateTime.now());
        return todo;
    }

    public static Todo updateSubLocation(Todo entity, TodoDto dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUpdatedAt(LocalDateTime.now());
        return entity;
    }

    public static List<TodoDto> mapToList(List<Todo> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(TodoMapper::mapTo).collect(Collectors.toList());
    }


}
