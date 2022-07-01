package com.cmv.borusan.repository;

import com.cmv.borusan.model.entity.SubLocationDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubLocationDetailRepository extends JpaRepository<SubLocationDetail,Long> {

    List<SubLocationDetail> getBySubLocationId(Long id);
    List<SubLocationDetail> getBySubLocationName(String name);

    @Query("SELECT s FROM SubLocationDetail s WHERE (:name = '' or upper_tr(s.name) like upper_tr(concat('%',:name,'%')))")
    Page<SubLocationDetail> findAllPageable(String name, Pageable pageable);
}
