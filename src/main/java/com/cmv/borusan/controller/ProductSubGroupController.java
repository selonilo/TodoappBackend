package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.ProductSubGroupDto;
import com.cmv.borusan.model.dto.ProductSubGroupSearch;
import com.cmv.borusan.service.ProductSubGroupService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductSubGroupController extends BaseController{

    private final ProductSubGroupService productSubGroupService;

    public ProductSubGroupController(ProductSubGroupService productSubGroupService){
        this.productSubGroupService = productSubGroupService;
    }

    @GetMapping(PUBLIC_FIND_ALL_PRODUCTSUBGROUP)
    public List<ProductSubGroupDto> getAll(){
        return productSubGroupService.getAll();
    }

    @PostMapping(PUBLIC_SAVE_PRODUCTSUBGROUP)
    public ResponseEntity<ProductSubGroupDto> save(@RequestBody ProductSubGroupDto productSubGroup){
        return ResponseEntity.ok(productSubGroupService.save(productSubGroup));
    }

    @DeleteMapping(PUBLIC_DELETE_PRODUCTSUBGROUP+"/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(productSubGroupService.delete(id));
    }

    @PostMapping(PUBLIC_UPDATE_PRODUCTSUBGROUP)
    public ResponseEntity<ProductSubGroupDto> update(@RequestBody ProductSubGroupDto productSubGroup){
        return ResponseEntity.ok(productSubGroupService.update(productSubGroup));
    }

    @GetMapping(PUBLIC_GET_BY_PRODUCTGROUP_ID+"/{id}")
    public List<ProductSubGroupDto> getByProductGroupId(@PathVariable Long id){
        List<ProductSubGroupDto> productSubGroupDto = productSubGroupService.getByProductGroupId(id);
        return productSubGroupDto;
    }

    @PostMapping(PUBLIC_PRODUCTSUBGROUP_PAGEABLE)
    public ResponseEntity getProductSubGroupWithSort(Pageable pageable, @RequestBody ProductSubGroupSearch productSubGroupSearch){
        return ResponseEntity.ok(productSubGroupService.findProductSubGroupWithPagination(pageable,productSubGroupSearch));
    }


}
