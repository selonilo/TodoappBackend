package com.cmv.borusan.service;

import com.cmv.borusan.model.dto.ProductSubGroupDto;
import com.cmv.borusan.model.dto.ProductSubGroupSearch;
import com.cmv.borusan.model.entity.Product;
import com.cmv.borusan.model.entity.ProductGroup;
import com.cmv.borusan.model.entity.ProductSubGroup;
import com.cmv.borusan.model.mapper.ProductSubGroupMapper;
import com.cmv.borusan.repository.ProductGroupRepository;
import com.cmv.borusan.repository.ProductRepository;
import com.cmv.borusan.repository.ProductSubGroupRepository;
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
public class ProductSubGroupService {

    private final ProductRepository productRepository;

    private final ProductSubGroupRepository productSubGroupRepository;

    private final ProductGroupRepository productGroupRepository;

    public List<ProductSubGroupDto> getAll(){
        return ProductSubGroupMapper.mapToList(productSubGroupRepository.findAll());
    }

    public List<ProductSubGroupDto> getByProductGroupId(Long id){
        return ProductSubGroupMapper.mapToList(productSubGroupRepository.getByProductGroupIdOrderByName(id));
    }

    public ProductSubGroupDto save(ProductSubGroupDto productSubGroupDto){
        ProductSubGroup productSubGroup = ProductSubGroupMapper.mapTo(productSubGroupDto);

        Optional<ProductSubGroup> productSubGroupOptional = productSubGroupRepository.findByProductGroupIdAndName(productSubGroupDto.getProductGroupId(),productSubGroupDto.getName());

        if (!productSubGroupOptional.isPresent()){
            Optional<ProductGroup> productGroup = productGroupRepository.findById(productSubGroupDto.getProductGroupId());
            if (productGroup.isPresent()) {
                productSubGroup.setProductGroup(productGroup.get());
            } else {
                throw new EntityNotFoundException();
            }
            productSubGroupRepository.save(productSubGroup);
        }
        return productSubGroupDto;
    }

    public Boolean delete(Long id){
        List<Product> product = productRepository.findByProductSubGroupId(id);
        for (Product product1:product){
            product1.setProductSubGroup(null);
        }
        productRepository.saveAll(product);
        productSubGroupRepository.deleteById(id);
        return true;
    }

    public ProductSubGroupDto update(ProductSubGroupDto productSubGroupDto){
        Optional<ProductSubGroup> productSubGroupOptional = productSubGroupRepository.findById(productSubGroupDto.getId());
        if(productSubGroupOptional.isPresent()){
            ProductSubGroup productSubGroup = productSubGroupOptional.get();
            ProductSubGroupMapper.updateProductSubGroup(productSubGroup,productSubGroupDto);
            ProductGroup productGroup = productGroupRepository.findById(productSubGroupDto.getProductGroupId()).orElseThrow(()->new IllegalArgumentException("not found id"));
            productSubGroup.setProductGroup(productGroup);
            productSubGroupRepository.save(productSubGroup);
        }
        else {
            throw new IllegalArgumentException("not found id");
        }
        return productSubGroupDto;
    }

    public Page<ProductSubGroupDto> findProductSubGroupWithPagination(Pageable pageable, ProductSubGroupSearch productSubGroupSearch){
        if (productSubGroupSearch.getName() == null){
            productSubGroupSearch.setName("");
        }
        Page<ProductSubGroup> productSubGroups = productSubGroupRepository.findAllPageable(productSubGroupSearch.getName(),pageable);
        return productSubGroups.map(ProductSubGroupMapper::mapTo);
    }
}
