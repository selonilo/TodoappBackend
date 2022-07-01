package com.cmv.borusan.repository;

import com.cmv.borusan.model.entity.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker,Long> {

    @Query("SELECT w FROM Worker w WHERE w.name LIKE %?1%")
    Page<Worker> search(Pageable pageable);

    @Query("SELECT w FROM Worker w WHERE (:name = '' or upper_tr(w.name) like upper_tr(concat('%',:name,'%'))) " +
            "and (:surname = '' or upper_tr(w.surname) like upper_tr(concat('%',:surname,'%')))")
    Page<Worker> findAll(String name,String surname, Pageable pageable);


}
