package com.cmv.borusan.repository;

import com.cmv.borusan.model.entity.ProductGroup;
import com.cmv.borusan.model.entity.ProductLastDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface ProductGroupRepository extends JpaRepository<ProductGroup,Long> {


    @Query("SELECT p FROM ProductGroup p WHERE (:name = '' or upper_tr(p.name) like upper_tr(concat('%',:name,'%')))")
    Page<ProductGroup> findAllPageable(String name, Pageable pageable);

    List<ProductGroup> findByProductAreasId(Long id);

}
