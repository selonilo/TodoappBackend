package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.SubLocationDto;
import com.cmv.borusan.model.dto.SubLocationSearch;
import com.cmv.borusan.service.SubLocationService;
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

    @GetMapping(PUBLIC_GET_BY_LOCATION_ID_SUBLOCATION+"/{id}")
    public List<SubLocationDto> getByLocationId(@PathVariable Long id){
        List<SubLocationDto> subLocationDto = subLocationService.getByLocationId(id);
        return subLocationDto;
    }

    @PostMapping(PUBLIC_SUBLOCATIN_SEARCH)
    public ResponseEntity getSubLocationWithSort(Pageable pageable, @RequestBody SubLocationSearch subLocationSearch){
        return ResponseEntity.ok(subLocationService.findSubLocationWithPagination(pageable,subLocationSearch));
    }

}
