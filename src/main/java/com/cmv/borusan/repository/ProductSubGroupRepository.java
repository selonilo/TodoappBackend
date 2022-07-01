package com.cmv.borusan.repository;

import com.cmv.borusan.model.entity.ProductLastDetail;
import com.cmv.borusan.model.entity.ProductSubGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductSubGroupRepository extends JpaRepository<ProductSubGroup,Long> {

    List<ProductSubGroup> getByProductGroupIdOrderByName(Long id);

    @Query("SELECT p FROM ProductSubGroup p WHERE (:name = '' or upper_tr(p.name) like upper_tr(concat('%',:name,'%')))")
    Page<ProductSubGroup> findAllPageable(String name, Pageable pageable);

    Optional<ProductSubGroup> findByProductGroupIdAndName(Long id,String name);
}
