package com.salih.todo.repository;

import com.salih.todo.model.entity.SubLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubLocationRepository extends JpaRepository<SubLocation,Long> {


    SubLocation findByName(String name);


}
