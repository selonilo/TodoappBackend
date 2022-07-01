package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.SubLocationDetailDto;
import com.cmv.borusan.model.dto.SubLocationDetailSearch;
import com.cmv.borusan.service.SubLocationDetailService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubLocationDetailController extends BaseController{

    private final SubLocationDetailService subLocationDetailService;

    public SubLocationDetailController(SubLocationDetailService subLocationDetailService){
        this.subLocationDetailService = subLocationDetailService;
    }

    @GetMapping(PUBLIC_FIND_ALL_SUBLOCATIONDETAIL)
    public List<SubLocationDetailDto> getAll(){
        return subLocationDetailService.getAll();
    }

    @PostMapping(PUBLIC_SAVE_SUBLOCATIONDETAIL)
    public ResponseEntity<SubLocationDetailDto> save(@RequestBody SubLocationDetailDto subLocationDetail){
        return ResponseEntity.ok(subLocationDetailService.save(subLocationDetail));
    }

    @DeleteMapping(PUBLIC_DELETE_SUBLOCATIONDETAIL+"/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(subLocationDetailService.delete(id));
    }

    @PostMapping(PUBLIC_UPDATE_SUBLOCATIONDETAIL)
    public ResponseEntity<SubLocationDetailDto> update(@RequestBody SubLocationDetailDto subLocationDetail){
        return ResponseEntity.ok(subLocationDetailService.update(subLocationDetail));
    }

   /* @GetMapping(PUBLIC_GET_BY_SUBLOCATIN_ID+"/{id}")
    public List<SubLocationDetailDto> getBySubLocationId(@PathVariable Long id){
        List<SubLocationDetailDto> subLocationDetailDto = subLocationDetailService.getBySubLocationId(id);
        return subLocationDetailDto;
    }*/

    @GetMapping(PUBLIC_GET_BY_SUBLOCATIN_ID+"/{name}")
    public List<SubLocationDetailDto> getBySubLocationName(@PathVariable String name){
        List<SubLocationDetailDto> subLocationDetailDtos = subLocationDetailService.getBySubLocationName(name);
        return subLocationDetailDtos;
    }

    @PostMapping(PUBLIC_SUBLOCATIONDETAIL_SEARCH)
    public ResponseEntity getSubLocationDetailsWithSort(Pageable pageable, @RequestBody SubLocationDetailSearch subLocationDetailSearch){
        return ResponseEntity.ok(subLocationDetailService.findSubLocationDetailWithPagination(pageable,subLocationDetailSearch));
    }
}
