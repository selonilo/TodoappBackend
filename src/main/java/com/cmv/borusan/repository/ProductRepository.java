package com.cmv.borusan.repository;

import com.cmv.borusan.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {


    Optional<Product> getProductByDynamicPath(String dynamicPath);

    List<Product> findByLocationId(Long id);

    List<Product> findBySubLocationId(Long id);

    List<Product> findByProductAreaId(Long id);

    List<Product> findBySubLocationDetailId(Long id);

    List<Product> findByProductLastDetailId(Long id);

    List<Product> findByProductSubGroupDetailId(Long id);

    List<Product> findByProductSubGroupId(Long id);

    List<Product> findByProductGroupId(Long id);

    List<Product> findByWorkerId(Long id);

    List<Product> findByColourId(Long id);

    List<Product> findByNumberPlateId(Long id);

    Optional<Product> findByProductBarcode(String productBarcode);

    Optional<Product> findByUpdatedAt(LocalDateTime dateTime);

    @Query("select case when count(p) > 0 then true else false end "+
            "from Product p where p.productBarcode =:productBarcode ")
    Boolean existSameProductWithProductBarcode(String productBarcode);

    @Query("SELECT DISTINCT p FROM Product p " +
            "LEFT JOIN p.productGroup pg " +
            "LEFT JOIN p.productArea pa " +
            "LEFT JOIN p.productSubGroup psg " +
            "LEFT JOIN p.productSubGroupDetail psgd " +
            "LEFT JOIN p.productLastDetail pld " +
            "LEFT JOIN p.location l " +
            "LEFT JOIN p.subLocation sl " +
            "LEFT JOIN p.subLocationDetail sld " +
            "LEFT JOIN p.worker w " +
            "WHERE (:sapCode = '' or upper_tr(p.sapCode) like upper_tr(concat('%',:sapCode,'%')))" +
            "and (:productArea = '' or upper_tr(pa.name) like upper_tr(concat('%',:productArea,'%')))" +
            "and (:productBarcode = '' or upper_tr(p.productBarcode) like upper_tr(concat('%',:productBarcode,'%')))" +
            "and (:locations = '' or upper_tr(p.locations) like upper_tr(concat('%',:locations,'%')))" +
            "and (:oldBarcode = '' or upper_tr(p.oldBarcode) like upper_tr(concat('%',:oldBarcode,'%')))" +
            "and (:productGroup = '' or upper_tr(pg.name) like upper_tr(concat('%',:productGroup,'%')))" +
            "and (:productSubGroup = '' or upper_tr(psg.name) like upper_tr(concat('%',:productSubGroup,'%')))" +
            "and (:productSubGroupDetail = '' or upper_tr(psgd.name) like upper_tr(concat('%',:productSubGroupDetail,'%')))" +
            "and (:productLastDetail = '' or upper_tr(pld.name) like upper_tr(concat('%',:productLastDetail,'%')))" +
            "and (:location = '' or upper_tr(l.name) like upper_tr(concat('%',:location,'%')))" +
            "and (:subLocation = '' or upper_tr(sl.name) like upper_tr(concat('%',:subLocation,'%')))" +
            "and (:subLocationDetail = '' or upper_tr(sld.name) like upper_tr(concat('%',:subLocationDetail,'%')))" +
            "and (:worker = '' or upper_tr(w.name) like upper_tr(concat('%',:worker,'%')))")
    Page<Product> findAllPageable(String sapCode, String productBarcode, String locations,
                                  String oldBarcode, String productGroup, String productSubGroup,
                                  String productSubGroupDetail, String productLastDetail, String location, String subLocation, String subLocationDetail, String worker, String productArea,
                                  Pageable pageable);

}
