package com.cmv.borusan.repository;

import com.cmv.borusan.model.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products,Long> {

    Optional<Products> findByProductBarcode(String productBarcode);

    @Query("SELECT ps FROM Products ps WHERE (:productBarcode = '' or upper_tr(ps.productBarcode) like upper_tr(concat('%',:productBarcode,'%')))" +
            "and (:productGroup = '' or upper_tr(ps.productGroup) like upper_tr(concat('%',:productGroup,'%')))" +
            "and (:productSubGroup = '' or upper_tr(ps.productSubGroup) like upper_tr(concat('%',:productSubGroup,'%')))" +
            "and (:productSubGroupDetail = '' or upper_tr(ps.productSubGroupDetail) like upper_tr(concat('%',:productSubGroupDetail,'%')))" +
            "and (:productLastDetail = '' or upper_tr(ps.productLastDetail) like upper_tr(concat('%',:productLastDetail,'%')))" +
            "and (:location = '' or upper_tr(ps.location) like upper_tr(concat('%',:location,'%')))" +
            "and (:subLocation = '' or upper_tr(ps.subLocation) like upper_tr(concat('%',:subLocation,'%')))" +
            "and (:worker = '' or upper_tr(ps.worker) like upper_tr(concat('%',:worker,'%')))" +
            "and (:productArea = '' or upper_tr(ps.productArea) like upper_tr(concat('%',:productArea,'%')))" +
            "and (:colour = '' or upper_tr(ps.colour) like upper_tr(concat('%',:colour,'%')))")
    Page<Products> findAllProducts(String productBarcode, String productGroup, String productSubGroup, String productSubGroupDetail, String productLastDetail,
                                   String location, String subLocation, String worker, String productArea, String colour,Pageable pageable);
}
