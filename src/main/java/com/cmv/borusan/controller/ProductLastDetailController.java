package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.ProductLastDetailDto;
import com.cmv.borusan.model.dto.ProductLastDetailSearch;
import com.cmv.borusan.service.ProductLastDetailService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductLastDetailController extends BaseController{

    private final ProductLastDetailService productLastDetailService;

    public ProductLastDetailController(ProductLastDetailService productLastDetailService){
        this.productLastDetailService = productLastDetailService;
    }

    @GetMapping(PUBLIC_FIND_ALL_PRODUCTLASTDETAIL)
    public List<ProductLastDetailDto> getAll(){
        return productLastDetailService.getAll();
    }

    @PostMapping(PUBLIC_SAVE_PRODUCTLASTDETAIL)
    public ResponseEntity<ProductLastDetailDto> save(@RequestBody ProductLastDetailDto productLastDetail){
        return ResponseEntity.ok(productLastDetailService.save(productLastDetail));
    }

    @DeleteMapping(PUBLIC_DELETE_PRODUCTLASTDETAIL+"/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true)Long id){
        return ResponseEntity.ok(productLastDetailService.delete(id));
    }

    @PostMapping(PUBLIC_UPDATE_PRODUCTLASTDETAIL)
    public ResponseEntity<ProductLastDetailDto> update(@RequestBody ProductLastDetailDto productLastDetail){
        return ResponseEntity.ok(productLastDetailService.update(productLastDetail));
    }

    @GetMapping(PUBLIC_GET_BY_PRODUCTSUBGROUPDETAIL_ID+"/{id}")
    public List<ProductLastDetailDto> getByProductSubGroupDetailId(@PathVariable Long id){
        List<ProductLastDetailDto> productLastDetailDto = productLastDetailService.getByProductSubGroupDetailId(id);
        return productLastDetailDto;
    }

    @PostMapping(PUBLIC_PRODUCTLASTDETAIL_PAGEABLE)
    public ResponseEntity getProductLastDetailsWithSort(Pageable pageable, @RequestBody ProductLastDetailSearch productLastDetailSearch){
        return ResponseEntity.ok(productLastDetailService.findProductLastDetailWithPagination(pageable,productLastDetailSearch));
    }

}
