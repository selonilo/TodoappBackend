package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.ProductSubGroupDetailDto;
import com.cmv.borusan.model.dto.ProductSubGroupDetailSearch;
import com.cmv.borusan.service.ProductSubGroupDetailService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductSubGroupDetailController extends BaseController{

    private final ProductSubGroupDetailService productSubGroupDetailService;

    public ProductSubGroupDetailController(ProductSubGroupDetailService productSubGroupDetailService){
        this.productSubGroupDetailService = productSubGroupDetailService;
    }

    @GetMapping(PUBLIC_FIND_ALL_PRODUCTSUBGROUPDETAIL)
    public List<ProductSubGroupDetailDto> getAll(){
        return productSubGroupDetailService.getAll();
    }

    @PostMapping(PUBLIC_SAVE_PRODUCTSUBGROUPDETAIL)
    public ResponseEntity<ProductSubGroupDetailDto> save(@RequestBody ProductSubGroupDetailDto productSubGroupDetail){
        return ResponseEntity.ok(productSubGroupDetailService.save(productSubGroupDetail));
    }

    @DeleteMapping(PUBLIC_DELETE_PRODUCTSUBGROUPDETAIL+"/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(productSubGroupDetailService.delete(id));
    }

    @PostMapping(PUBLIC_UPDATE_PRODUCTSUBGROUPDETAIL)
    public ResponseEntity<ProductSubGroupDetailDto> update(@RequestBody ProductSubGroupDetailDto productSubGroup){
        return ResponseEntity.ok(productSubGroupDetailService.update(productSubGroup));
    }

    @GetMapping(PUBLIC_GET_BY_PRODUCTSUBGROUP_ID+"/{id}")
    public List<ProductSubGroupDetailDto> getByProductSubGroupId(@PathVariable Long id){
        List<ProductSubGroupDetailDto> productSubGroupDetailDto = productSubGroupDetailService.getByProductSubGroupId(id);
        return productSubGroupDetailDto;
    }

    @PostMapping(PUBLIC_PRODUCTSUBGROUPDETAIL_PAGEABLE)
    public ResponseEntity getProductSubGroupDetailsWithSort(Pageable pageable, @RequestBody ProductSubGroupDetailSearch productSubGroupDetailSearch){
        return ResponseEntity.ok(productSubGroupDetailService.findProductSubGroupDetailWithPagination(pageable,productSubGroupDetailSearch));
    }
}
