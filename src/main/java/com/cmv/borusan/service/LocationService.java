package com.cmv.borusan.service;

import com.cmv.borusan.exception.EntityNotFoundException;
import com.cmv.borusan.model.dto.LocationDto;
import com.cmv.borusan.model.dto.LocationSearch;
import com.cmv.borusan.model.entity.Location;
import com.cmv.borusan.model.entity.Product;
import com.cmv.borusan.model.mapper.LocationMapper;
import com.cmv.borusan.repository.LocationRepository;
import com.cmv.borusan.repository.ProductRepository;
import com.cmv.borusan.repository.SubLocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    private final ProductRepository productRepository;

    private final SubLocationRepository subLocationRepository;

    public List<LocationDto> getAll() {
        return LocationMapper.mapToList(locationRepository.findAll());
    }

    public LocationDto getById(Long id) {
        return LocationMapper.mapTo(locationRepository.getById(id));
    }

    public LocationDto save(LocationDto locationDto) {
        Location location = LocationMapper.mapTo(locationDto);
        locationRepository.save(location);
        return locationDto;
    }

    public Boolean delete(Long id) {
        List<Product> product = productRepository.findByLocationId(id);
        
        for (Product product1:product){
            product1.setLocation(null);
        }
        productRepository.saveAll(product);
        locationRepository.deleteById(id);
        return true;
    }

    public LocationDto update(LocationDto locationDto) {
        Location locationOptional = locationRepository.findById(locationDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(locationDto.getId().toString(), Location.class));

        Location location = locationOptional;
        LocationMapper.updateLocation(location, locationDto);
        locationRepository.save(location);
        return locationDto;
    }

    public Page<LocationDto> findLocationWithPagination(Pageable pageable, LocationSearch locationSearch){
        if (locationSearch.getName() == null){
            locationSearch.setName("");
        }
        Page<Location> locations = locationRepository.findAllPageable(locationSearch.getName(),pageable);
        return locations.map(LocationMapper::mapTo);
    }



}
