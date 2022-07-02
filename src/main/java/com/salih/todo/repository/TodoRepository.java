package com.salih.todo.repository;

import com.salih.todo.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    Todo findByName(String name);

    List<Todo> getByUserId(Long id);
}
