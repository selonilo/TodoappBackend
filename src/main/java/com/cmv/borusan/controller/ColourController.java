package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.ColourDto;
import com.cmv.borusan.service.ColourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ColourController extends BaseController{

    private final ColourService colourService;

    public ColourController(ColourService colourService){
        this.colourService = colourService;
    }

    @GetMapping(PUBLIC_FIND_ALL_COLOUR)
    public List<ColourDto> getAll(){
        return colourService.getAll();
    }

    @PostMapping(PUBLIC_SAVE_COLOUR)
    public ResponseEntity<ColourDto> saveColour(@RequestBody ColourDto colourDto){
        return ResponseEntity.ok(colourService.saveColour(colourDto));
    }

    @DeleteMapping(PUBLIC_DELETE_COLOUR+"/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(colourService.delete(id));
    }


}
