package com.salih.todo.service;

import com.salih.todo.model.dto.TodoDto;
import com.salih.todo.model.entity.Todo;
import com.salih.todo.model.entity.User;
import com.salih.todo.model.mapper.TodoMapper;
import com.salih.todo.repository.TodoRepository;
import com.salih.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    private final UserRepository userRepository;

    public List<TodoDto> getAll(){
        return TodoMapper.mapToList(todoRepository.findAll());
    }

    public List<TodoDto> getByUserId(Long id){
        return TodoMapper.mapToList(todoRepository.getByUserId(id));
    }

    public TodoDto save(TodoDto todoDto){
        Todo todo = TodoMapper.mapTo(todoDto);

        Optional<User> user = userRepository.findById(todoDto.getUserId());
        if (user.isPresent()){
            todo.setUser(user.get());
        }
        else {
            throw new EntityNotFoundException();
        }
        todoRepository.save(todo);
        return todoDto;
    }

    public Boolean delete(Long id){
        todoRepository.deleteById(id);
        return true;
    }

    public TodoDto update(TodoDto todoDto){
        Optional<Todo> todoOptional = todoRepository.findById(todoDto.getId());
        if(todoOptional.isPresent()){
            Todo todo = todoOptional.get();
            TodoMapper.updateSubLocation(todo, todoDto);
            todoRepository.save(todo);
        }
        else {
            throw new IllegalArgumentException("not found id");
        }
        return todoDto;
    }



}
