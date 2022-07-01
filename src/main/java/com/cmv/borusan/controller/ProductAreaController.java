package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.ProductAreaDto;
import com.cmv.borusan.service.ProductAreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductAreaController extends BaseController{

    private final ProductAreaService productAreaService;

    public ProductAreaController(ProductAreaService productAreaService) {
        this.productAreaService = productAreaService;
    }

    @GetMapping(PUBLIC_FIND_ALL_PRODUCT_AREA)
    public List<ProductAreaDto> getAll(){
        return productAreaService.getAll();
    }

    @PostMapping(PUBLIC_SAVE_PRODUCT_AREA)
    public ResponseEntity<ProductAreaDto> save(@RequestBody ProductAreaDto productAreaDto){
        return ResponseEntity.ok(productAreaService.save(productAreaDto));
    }

    @DeleteMapping(PUBLIC_DELETE_PRODUCT_AREA+"/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(productAreaService.delete(id));
    }
}
