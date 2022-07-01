package com.cmv.borusan.repository;

import com.cmv.borusan.model.entity.ProductLastDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductLastDetailRepository extends JpaRepository<ProductLastDetail,Long> {
    List<ProductLastDetail> getByProductSubGroupDetailIdOrderByName(Long id);

    @Query("SELECT p FROM ProductLastDetail p WHERE (:name = '' or upper_tr(p.name) like upper_tr(concat('%',:name,'%')))")
    Page<ProductLastDetail> findAllPageable(String name, Pageable pageable);

    Optional<ProductLastDetail> findByProductSubGroupDetailIdAndName(Long id,String name);
}
