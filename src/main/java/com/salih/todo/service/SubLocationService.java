package com.salih.todo.service;

import com.salih.todo.model.dto.SubLocationDto;
import com.salih.todo.model.entity.SubLocation;
import com.salih.todo.model.mapper.SubLocationMapper;
import com.salih.todo.repository.SubLocationRepository;
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

    public List<SubLocationDto> getAll(){
        return SubLocationMapper.mapToList(subLocationRepository.findAll());
    }

    public SubLocationDto save(SubLocationDto subLocationDto){
        SubLocation subLocation = SubLocationMapper.mapTo(subLocationDto);
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
        subLocationRepository.deleteById(id);
        return true;
    }

    public SubLocationDto update(SubLocationDto subLocationDto){
        Optional<SubLocation> subLocationOptional = subLocationRepository.findById(subLocationDto.getId());
        if(subLocationOptional.isPresent()){
            SubLocation subLocation = subLocationOptional.get();
            SubLocationMapper.updateSubLocation(subLocation,subLocationDto);
            subLocationRepository.save(subLocation);
        }
        else {
            throw new IllegalArgumentException("not found id");
        }
        return subLocationDto;
    }



}
