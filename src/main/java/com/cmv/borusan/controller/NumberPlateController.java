package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.NumberPlateDto;
import com.cmv.borusan.service.NumberPlateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NumberPlateController extends BaseController {

    private final NumberPlateService numberPlateService;

    public NumberPlateController(NumberPlateService numberPlateService){
        this.numberPlateService = numberPlateService;
    }

    @GetMapping(PUBLIC_FIND_ALL_NUMBER_PLATE)
    public List<NumberPlateDto> getAll(){
        return numberPlateService.getAll();
    }

    @PostMapping(PUBLIC_SAVE_NUMBER_PLATE)
    public ResponseEntity<NumberPlateDto> saveNumberPlate(@RequestBody NumberPlateDto numberPlateDto){
        return ResponseEntity.ok(numberPlateService.saveNumberPlate(numberPlateDto));
    }

    @DeleteMapping(PUBLIC_DELETE_NUMBER_PLATE + "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(numberPlateService.delete(id));
    }
}
