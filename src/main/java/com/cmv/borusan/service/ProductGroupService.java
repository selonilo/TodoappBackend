package com.cmv.borusan.service;

import com.cmv.borusan.exception.EntityNotFoundException;
import com.cmv.borusan.model.dto.ProductGroupDto;
import com.cmv.borusan.model.dto.ProductGroupSearch;
import com.cmv.borusan.model.dto.SubLocationDto;
import com.cmv.borusan.model.entity.Product;
import com.cmv.borusan.model.entity.ProductGroup;
import com.cmv.borusan.model.mapper.ProductGroupMapper;
import com.cmv.borusan.model.mapper.SubLocationMapper;
import com.cmv.borusan.repository.ProductAreaRepository;
import com.cmv.borusan.repository.ProductGroupRepository;
import com.cmv.borusan.repository.ProductRepository;
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
public class ProductGroupService {

    private final ProductRepository productRepository;

    private final ProductGroupRepository productGroupRepository;

    private final ProductAreaRepository productAreaRepository;

    public List<ProductGroupDto> getAll(){
        return ProductGroupMapper.mapToList(productGroupRepository.findAll());
    }

    public ProductGroupDto save(ProductGroupDto productGroupDto){
        ProductGroup productGroup = ProductGroupMapper.mapTo(productGroupDto);

            for (Long productAreaId:productGroupDto.getProductAreaList()){
                productGroup.getProductAreas().add(productAreaRepository.findById(productAreaId).get());
            }
            productGroupRepository.save(productGroup);

        return productGroupDto;
    }

    public List<ProductGroupDto> getByProductAreaId(Long id){
        return ProductGroupMapper.mapToList(productGroupRepository.findByProductAreasId(id));

    }

    public Boolean delete(Long id){
        List<Product> product = productRepository.findByProductGroupId(id);
        for (Product product1:product){
            product1.setProductGroup(null);
        }
        productRepository.saveAll(product);
        productGroupRepository.deleteById(id);
        return true;
    }

    public ProductGroupDto update(ProductGroupDto productGroupDto){
        ProductGroup product = productGroupRepository.findById(productGroupDto.getId())
                .orElseThrow(()->new EntityNotFoundException(productGroupDto.getId().toString(),ProductGroup.class));


        ProductGroupMapper.updateProductGroup(product,productGroupDto);
        product.getProductAreas().clear();
        for (Long productAreaId:productGroupDto.getProductAreaList()){
            product.getProductAreas().add(productAreaRepository.findById(productAreaId).get());
        }
        productGroupRepository.save(product);
        return productGroupDto;
    }

    public Page<ProductGroupDto> findProductGroupWithPagination(Pageable pageable, ProductGroupSearch productGroupSearch){
        if (productGroupSearch.getName() == null){
            productGroupSearch.setName("");
        }
        Page<ProductGroup> productGroups = productGroupRepository.findAllPageable(productGroupSearch.getName(),pageable);
        return productGroups.map(ProductGroupMapper::mapTo);
    }
}
