package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.ProductsDto;
import com.cmv.borusan.model.dto.ProductsSearch;
import com.cmv.borusan.service.ProductsService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController extends BaseController{

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping(PRODUCTS_GETALL)
    public List<ProductsDto> getAll(){
        return productsService.getAll();
    }

    @PostMapping(PRODUCTS_SAVE)
    public ResponseEntity<ProductsDto> saveProducts(@RequestBody ProductsDto productsDto){
        return ResponseEntity.ok(productsService.saveProducts(productsDto));
    }

    @DeleteMapping(PRODUCTS_DELETE+"/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(productsService.delete(id));
    }

    @PostMapping(PRODUCTS_UPDATE)
    public ResponseEntity<ProductsDto> update(@RequestBody ProductsDto productsDto){
        return ResponseEntity.ok(productsService.update(productsDto));
    }

    @PostMapping(PRODUCTS_PAGEABLE)
    public ResponseEntity getProductsWithSort(Pageable pageable, @RequestBody ProductsSearch productsSearch){
        return ResponseEntity.ok(productsService.findProductsWithPagination(pageable,productsSearch));
    }
}
