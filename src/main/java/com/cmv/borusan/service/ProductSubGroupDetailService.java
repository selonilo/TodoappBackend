package com.cmv.borusan.service;

import com.cmv.borusan.exception.EntityNotFoundException;
import com.cmv.borusan.model.dto.ProductSubGroupDetailDto;
import com.cmv.borusan.model.dto.ProductSubGroupDetailSearch;
import com.cmv.borusan.model.entity.Product;
import com.cmv.borusan.model.entity.ProductSubGroup;
import com.cmv.borusan.model.entity.ProductSubGroupDetail;

import com.cmv.borusan.model.mapper.ProductSubGroupDetailMapper;
import com.cmv.borusan.repository.ProductLastDetailRepository;
import com.cmv.borusan.repository.ProductRepository;
import com.cmv.borusan.repository.ProductSubGroupDetailRepository;
import com.cmv.borusan.repository.ProductSubGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProductSubGroupDetailService {

    private final ProductRepository productRepository;

    private final ProductSubGroupDetailRepository productSubGroupDetailRepository;

    private final ProductSubGroupRepository productSubGroupRepository;

    private final ProductLastDetailRepository productLastDetailRepository;


    public List<ProductSubGroupDetailDto> getAll() {
        return ProductSubGroupDetailMapper.mapToList(productSubGroupDetailRepository.findAll());
    }

    public ProductSubGroupDetailDto save(ProductSubGroupDetailDto productSubGroupDetailDto) {
        ProductSubGroupDetail productSubGroupDetail = ProductSubGroupDetailMapper.mapTo(productSubGroupDetailDto);
        Optional<ProductSubGroupDetail> productSubGroupDetailOptional = productSubGroupDetailRepository.findByProductSubGroupIdAndName(productSubGroupDetailDto.getProductSubGroupId(),productSubGroupDetailDto.getName());
        if (!productSubGroupDetailOptional.isPresent()){
            ProductSubGroup productSubGroup = productSubGroupRepository.findById(productSubGroupDetailDto.getProductSubGroupId())
                    .orElseThrow(() -> new EntityNotFoundException(productSubGroupDetailDto.getProductSubGroupId().toString(), ProductSubGroupDetail.class));
            productSubGroupDetail.setProductSubGroup(productSubGroup);
            productSubGroupDetailRepository.save(productSubGroupDetail);
        }
        return productSubGroupDetailDto;
    }

    public List<ProductSubGroupDetailDto> getByProductSubGroupId(Long id){
        return ProductSubGroupDetailMapper.mapToList(productSubGroupDetailRepository.getByProductSubGroupIdOrderByName(id));
    }

    public Boolean delete(Long id) {
        List<Product> product = productRepository.findByProductSubGroupDetailId(id);
        for (Product product1:product){
            product1.setProductSubGroupDetail(null);
        }
        productRepository.saveAll(product);
        productSubGroupDetailRepository.deleteById(id);
        return true;
    }

    public ProductSubGroupDetailDto update(ProductSubGroupDetailDto productSubGroupDetailDto) {
        Optional<ProductSubGroupDetail> productSubGroupDetailOptional = productSubGroupDetailRepository.findById(productSubGroupDetailDto.getId());
        if (productSubGroupDetailOptional.isPresent()){
            ProductSubGroupDetail productSubGroupDetail = productSubGroupDetailOptional.get();
            ProductSubGroupDetailMapper.updateProductSubGroupDetail(productSubGroupDetail,productSubGroupDetailDto);
            ProductSubGroup productSubGroup = productSubGroupRepository.findById(productSubGroupDetailDto.getProductSubGroupId()).orElseThrow(()->new IllegalArgumentException("not found id"));
            productSubGroupDetail.setProductSubGroup(productSubGroup);
            productSubGroupDetailRepository.save(productSubGroupDetail);
        }
        else {
            throw new IllegalArgumentException("not found id");
        }
        return productSubGroupDetailDto;
    }

    public Page<ProductSubGroupDetailDto> findProductSubGroupDetailWithPagination(Pageable pageable, ProductSubGroupDetailSearch productSubGroupDetailSearch){
        if (productSubGroupDetailSearch.getName() == null){
            productSubGroupDetailSearch.setName("");
        }
        Page<ProductSubGroupDetail> productSubGroupDetails = productSubGroupDetailRepository.findAllPageable(productSubGroupDetailSearch.getName(),pageable);
        return productSubGroupDetails.map(ProductSubGroupDetailMapper::mapTo);
    }
}
