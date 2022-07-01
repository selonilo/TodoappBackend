package com.cmv.borusan.service;

import com.cmv.borusan.model.dto.SubLocationDetailDto;
import com.cmv.borusan.model.dto.SubLocationDetailSearch;
import com.cmv.borusan.model.entity.Product;
import com.cmv.borusan.model.entity.SubLocation;
import com.cmv.borusan.model.entity.SubLocationDetail;
import com.cmv.borusan.model.mapper.SubLocationDetailMapper;
import com.cmv.borusan.repository.ProductRepository;
import com.cmv.borusan.repository.SubLocationDetailRepository;
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
public class SubLocationDetailService {
    private final SubLocationDetailRepository subLocationDetailRepository;

    private final SubLocationRepository subLocationRepository;

    private final ProductRepository productRepository;

    public List<SubLocationDetailDto> getAll(){
        return SubLocationDetailMapper.mapToList(subLocationDetailRepository.findAll());
    }

    public List<SubLocationDetailDto> getBySubLocationId(Long id){
        return SubLocationDetailMapper.mapToList(subLocationDetailRepository.getBySubLocationId(id));
    }

    public List<SubLocationDetailDto> getBySubLocationName(String name){
        return SubLocationDetailMapper.mapToList(subLocationDetailRepository.getBySubLocationName(name));
    }

    public SubLocationDetailDto save(SubLocationDetailDto subLocationDetailDto){
        SubLocationDetail subLocationDetail = SubLocationDetailMapper.mapTo(subLocationDetailDto);

        Optional<SubLocation> subLocation = subLocationRepository.findById(subLocationDetailDto.getSubLocationId());
        if(subLocation.isPresent()){
            subLocationDetail.setSubLocation(subLocation.get());
        }
        else {
            throw new EntityNotFoundException();
        }
        subLocationDetailRepository.save(subLocationDetail);
        return subLocationDetailDto;
    }

    public Boolean delete(Long id){
        List<Product> product = productRepository.findBySubLocationDetailId(id);
        for (Product product1:product){
            product1.setSubLocationDetail(null);
        }
        productRepository.saveAll(product);
        subLocationDetailRepository.deleteById(id);
        return true;
    }

    public SubLocationDetailDto update(SubLocationDetailDto subLocationDetailDto){
        Optional<SubLocationDetail> subLocationDetailOptional = subLocationDetailRepository.findById(subLocationDetailDto.getId());
        if(subLocationDetailOptional.isPresent()){
            SubLocationDetail subLocationDetail = subLocationDetailOptional.get();
            SubLocationDetailMapper.updateSubLocationDetail(subLocationDetail,subLocationDetailDto);
            subLocationDetailRepository.save(subLocationDetail);
        }
        else {
            throw new IllegalArgumentException("not found id");
        }
        return subLocationDetailDto;
    }

    public Page<SubLocationDetailDto> findSubLocationDetailWithPagination(Pageable pageable, SubLocationDetailSearch subLocationDetailSearch){
        if (subLocationDetailSearch.getName() == null){
            subLocationDetailSearch.setName("");
        }
        Page<SubLocationDetail> subLocationDetails = subLocationDetailRepository.findAllPageable(subLocationDetailSearch.getName(),pageable);
        return subLocationDetails.map(SubLocationDetailMapper::mapTo);
    }
}
