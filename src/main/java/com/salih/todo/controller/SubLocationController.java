package com.salih.todo.controller;

import com.salih.todo.model.dto.SubLocationDto;
import com.salih.todo.service.SubLocationService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubLocationController extends BaseController{

    private final SubLocationService subLocationService;

    public SubLocationController(SubLocationService subLocationService){
        this.subLocationService = subLocationService;
    }

    @GetMapping(PUBLIC_FIND_ALL_SUBLOCATION)
    public List<SubLocationDto> getAll(){
        return subLocationService.getAll();
    }

    @PostMapping(PUBLIC_SAVE_SUBLOCATION)
    public ResponseEntity<SubLocationDto> save(@RequestBody SubLocationDto subLocation){
        return ResponseEntity.ok(subLocationService.save(subLocation));
    }

    @DeleteMapping(PUBLIC_DELETE_SUBLOCATION+"/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(subLocationService.delete(id));
    }

    @PostMapping(PUBLIC_UPDATE_SUBLOCATION)
    public ResponseEntity<SubLocationDto> update(@RequestBody SubLocationDto subLocation){
        return ResponseEntity.ok(subLocationService.update(subLocation));
    }


}
