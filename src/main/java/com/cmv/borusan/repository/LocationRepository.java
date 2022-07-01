package com.cmv.borusan.repository;

import com.cmv.borusan.model.entity.Location;
import com.cmv.borusan.model.entity.SubLocationDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location,Long> {

    @Query("SELECT s FROM Location s WHERE (:name = '' or upper_tr(s.name) like upper_tr(concat('%',:name,'%')))")
    Page<Location> findAllPageable(String name, Pageable pageable);

}
