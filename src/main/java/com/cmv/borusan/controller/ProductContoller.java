package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.ProductDto;
import com.cmv.borusan.model.dto.ProductSearch;
import com.cmv.borusan.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ProductContoller extends BaseController{

    private final ProductService productService;

    public ProductContoller(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(PUBLIC_FIND_ALL_PRODUCT)
    public List<ProductDto> getAll(){
        return productService.getAll();
    }


    @PostMapping(PUBLIC_SAVE_PRODUCT)
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto product){
        return ResponseEntity.ok(productService.save(product));
    }

    @PostMapping(PUBLIC_PRODUCT_WEB_SAVE)
    public ResponseEntity<Boolean> saveWeb(@RequestBody ProductDto product){
        return ResponseEntity.ok(productService.saveWeb(product));
    }

    @DeleteMapping(PUBLIC_DELETE_PRODUCT + "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(productService.delete(id));
    }

    @PostMapping(PUBLIC_UPDATE_PRODUCT)
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto product){
        return ResponseEntity.ok((productService.update(product)));
    }

    @GetMapping(PUBLIC_PRODUCT_IMAGE)
    public ResponseEntity downloadFile(@RequestParam String dynamicPath){
        return productService.downloadFile(dynamicPath);
    }

    @PostMapping(PUBLIC_PRODUCT_PAGEABLE)
    public ResponseEntity getProductsWithSort(Pageable pageable, @RequestBody ProductSearch productSearch){
        return ResponseEntity.ok(productService.findProductsWithPagination(pageable,productSearch));
    }

}
