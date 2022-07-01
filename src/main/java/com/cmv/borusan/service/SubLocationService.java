package com.cmv.borusan.service;

import com.cmv.borusan.model.dto.SubLocationDto;
import com.cmv.borusan.model.dto.SubLocationSearch;
import com.cmv.borusan.model.entity.Location;
import com.cmv.borusan.model.entity.Product;
import com.cmv.borusan.model.entity.SubLocation;
import com.cmv.borusan.model.mapper.SubLocationMapper;
import com.cmv.borusan.repository.LocationRepository;
import com.cmv.borusan.repository.ProductRepository;
import com.cmv.borusan.repository.SubLocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SubLocationService {
    private final SubLocationRepository subLocationRepository;

    private final LocationRepository locationRepository;

    private final ProductRepository productRepository;

    public List<SubLocationDto> getAll(){
        return SubLocationMapper.mapToList(subLocationRepository.findAll());
    }

    public List<SubLocationDto> getByLocationId(Long id){
        return SubLocationMapper.mapToList(subLocationRepository.getByLocationId(id));
    }

    public SubLocationDto save(SubLocationDto subLocationDto){
        SubLocation subLocation = SubLocationMapper.mapTo(subLocationDto);

        Optional<Location> location = locationRepository.findById(subLocationDto.getLocationId());
        if(location.isPresent()){
            subLocation.setLocation(location.get());
        }
        else{
            throw new EntityNotFoundException();
        }
        Optional<SubLocation> subLocationOptional = Optional.ofNullable(subLocationRepository.findByName(subLocationDto.getName()));
        if (subLocationOptional.isPresent()){
            throw new EntityNotFoundException();
        }
        else {
            subLocationRepository.save(subLocation);
        }
        return subLocationDto;
    }

    public Boolean delete(Long id){
        List<Product> product = productRepository.findBySubLocationId(id);
        for (Product product1:product){
            product1.setSubLocation(null);
        }
        productRepository.saveAll(product);
        subLocationRepository.deleteById(id);
        return true;
    }

    public SubLocationDto update(SubLocationDto subLocationDto){
        Optional<SubLocation> subLocationOptional = subLocationRepository.findById(subLocationDto.getId());
        if(subLocationOptional.isPresent()){
            SubLocation subLocation = subLocationOptional.get();
            SubLocationMapper.updateSubLocation(subLocation,subLocationDto);
            Location location = locationRepository.findById(subLocationDto.getLocationId()).orElseThrow(()->new IllegalArgumentException("not found id"));
            subLocation.setLocation(location);
            subLocationRepository.save(subLocation);
        }
        else {
            throw new IllegalArgumentException("not found id");
        }
        return subLocationDto;
    }

    public Page<SubLocationDto> findSubLocationWithPagination(Pageable pageable, SubLocationSearch subLocationSearch){
        if (subLocationSearch.getName() == null){
            subLocationSearch.setName("");
        }
        Page<SubLocation> subLocations = subLocationRepository.findAllPageable(subLocationSearch.getName(),pageable);
        return subLocations.map(SubLocationMapper::mapTo);
    }


}
