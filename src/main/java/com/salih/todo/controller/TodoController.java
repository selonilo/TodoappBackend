package com.salih.todo.controller;

import com.salih.todo.model.dto.TodoDto;
import com.salih.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController extends BaseController{

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping(PUBLIC_FIND_ALL_TODO)
    public List<TodoDto> getAll(){
        return todoService.getAll();
    }

    @GetMapping(PUBLIC_GET_BY_USER_ID)
    public List<TodoDto> getByUserId(@PathVariable Long id){
        List<TodoDto> todoDtos = todoService.getByUserId(id);
        return todoDtos;
    }

    @PostMapping(PUBLIC_SAVE_TODO)
    public ResponseEntity<TodoDto> save(@RequestBody TodoDto todoDto){
        return ResponseEntity.ok(todoService.save(todoDto));
    }

    @DeleteMapping(PUBLIC_DELETE_TODO+"/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(todoService.delete(id));
    }

    @PostMapping(PUBLIC_UPDATE_TODO)
    public ResponseEntity<TodoDto> update(@RequestBody TodoDto todoDto){
        return ResponseEntity.ok(todoService.update(todoDto));
    }


}
