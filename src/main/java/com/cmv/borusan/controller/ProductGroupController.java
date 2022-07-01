package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.ProductGroupDto;
import com.cmv.borusan.model.dto.ProductGroupSearch;
import com.cmv.borusan.model.dto.SubLocationDto;
import com.cmv.borusan.service.ProductGroupService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductGroupController extends BaseController{

    private final ProductGroupService productGroupService;

    public ProductGroupController(ProductGroupService productGroupService){
        this.productGroupService = productGroupService;
    }

    @GetMapping(PUBLIC_FIND_ALL_PRODUCTGROUP)
    public List<ProductGroupDto> getAll(){
        return productGroupService.getAll();
    }

    @GetMapping(PUBLIC_FIND_BYID_PRODUCTAREA + "/{id}")
    public List<ProductGroupDto> getByProductAreaId(@PathVariable Long id){
        List<ProductGroupDto> productGroupDtos = productGroupService.getByProductAreaId(id);
        return productGroupDtos;
    }

    @PostMapping(PUBLIC_SAVE_PRODUCTGROUP)
    public ResponseEntity<ProductGroupDto> save(@RequestBody ProductGroupDto productGroup){
        return ResponseEntity.ok(productGroupService.save(productGroup));
    }

    @DeleteMapping(PUBLIC_DELETE_PRODUCTGROUP+"/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(productGroupService.delete(id));
    }

    @PostMapping(PUBLIC_UPDATE_PRODUCTGROUP)
    public ResponseEntity<ProductGroupDto> update(@RequestBody ProductGroupDto productGroup){
        return ResponseEntity.ok(productGroupService.update(productGroup));
    }

    @PostMapping(PUBLIC_PRODUCTGROUP_PAGEABLE)
    public ResponseEntity getProductGroupWithSort(Pageable pageable, @RequestBody ProductGroupSearch productGroupSearch){
        return ResponseEntity.ok(productGroupService.findProductGroupWithPagination(pageable,productGroupSearch));
    }
}
