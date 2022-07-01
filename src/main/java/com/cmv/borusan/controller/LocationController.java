package com.cmv.borusan.controller;

import com.cmv.borusan.model.dto.LocationDto;
import com.cmv.borusan.model.dto.LocationSearch;
import com.cmv.borusan.service.LocationService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController extends BaseController{

    private final LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping(PUBLIC_FIND_ALL_LOCATION)
    public List<LocationDto> getAll(){
        return locationService.getAll();
    }

    @PostMapping(PUBLIC_SAVE_LOCATION)
    public ResponseEntity<LocationDto> save(@RequestBody LocationDto location){
        return ResponseEntity.ok(locationService.save(location));
    }

    @DeleteMapping(PUBLIC_DELETE_LOCATION+"/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(locationService.delete(id));
    }

    @PostMapping(PUBLIC_UPDATE_LOCATION)
    public ResponseEntity<LocationDto> update(@RequestBody LocationDto location){
        return ResponseEntity.ok(locationService.update(location));
    }

    @GetMapping(PUBLIC_GET_BY_LOCATION_ID+"/{id}")
    public ResponseEntity<LocationDto> getById(@PathVariable Long id){
        LocationDto locationDto = locationService.getById(id);
        return ResponseEntity.ok(locationDto);
    }

    @PostMapping(PUBLIC_LOCATION_SEARCH)
    public ResponseEntity getLocationWithSort(Pageable pageable, @RequestBody LocationSearch locationSearch){
        return ResponseEntity.ok(locationService.findLocationWithPagination(pageable,locationSearch));
    }
}
