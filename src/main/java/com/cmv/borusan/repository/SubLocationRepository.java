package com.cmv.borusan.repository;

import com.cmv.borusan.model.entity.SubLocation;
import com.cmv.borusan.model.entity.SubLocationDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubLocationRepository extends JpaRepository<SubLocation,Long> {

    SubLocation findByLocationId(Long id);

    List<SubLocation> getByLocationId(Long id);

    SubLocation findByName(String name);

    @Query("SELECT s FROM SubLocation s WHERE (:name = '' or upper_tr(s.name) like upper_tr(concat('%',:name,'%')))")
    Page<SubLocation> findAllPageable(String name, Pageable pageable);


}
