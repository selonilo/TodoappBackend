package com.salih.todo.repository;

import com.salih.todo.model.entity.SubLocationDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubLocationDetailRepository extends JpaRepository<SubLocationDetail,Long> {

    List<SubLocationDetail> getBySubLocationId(Long id);
    List<SubLocationDetail> getBySubLocationName(String name);

}
