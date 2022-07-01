package com.cmv.borusan.repository;

import com.cmv.borusan.model.entity.ProductSubGroupDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductSubGroupDetailRepository extends JpaRepository<ProductSubGroupDetail,Long> {

    List<ProductSubGroupDetail> getByProductSubGroupIdOrderByName(Long id);

    @Query("SELECT p FROM ProductSubGroupDetail p WHERE (:name = '' or upper_tr(p.name) like upper_tr(concat('%',:name,'%')))")
    Page<ProductSubGroupDetail> findAllPageable(String name, Pageable pageable);

    Optional<ProductSubGroupDetail> findByProductSubGroupIdAndName(Long id,String name);
}
