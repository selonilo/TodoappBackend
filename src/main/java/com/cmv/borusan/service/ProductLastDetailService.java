package com.cmv.borusan.service;

import com.cmv.borusan.exception.EntityNotFoundException;
import com.cmv.borusan.model.dto.ProductLastDetailDto;
import com.cmv.borusan.model.dto.ProductLastDetailSearch;
import com.cmv.borusan.model.entity.Product;
import com.cmv.borusan.model.entity.ProductLastDetail;
import com.cmv.borusan.model.entity.ProductSubGroupDetail;
import com.cmv.borusan.model.mapper.ProductLastDetailMapper;
import com.cmv.borusan.repository.ProductLastDetailRepository;
import com.cmv.borusan.repository.ProductRepository;
import com.cmv.borusan.repository.ProductSubGroupDetailRepository;
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
public class ProductLastDetailService {

    private final ProductRepository productRepository;

    private final ProductLastDetailRepository productLastDetailRepository;

    private final ProductSubGroupDetailRepository productSubGroupDetailRepository;

    public List<ProductLastDetailDto> getAll(){
        return ProductLastDetailMapper.mapToList(productLastDetailRepository.findAll());
    }

    public List<ProductLastDetailDto> getByProductSubGroupDetailId(Long id){
        return ProductLastDetailMapper.mapToList(productLastDetailRepository.getByProductSubGroupDetailIdOrderByName(id));
    }

    public ProductLastDetailDto save(ProductLastDetailDto productLastDetailDto){
        ProductLastDetail productLastDetail = ProductLastDetailMapper.mapTo(productLastDetailDto);

        Optional<ProductLastDetail> productLastDetailOptional = productLastDetailRepository.findByProductSubGroupDetailIdAndName(productLastDetailDto.getProductSubGroupDetailId(),productLastDetailDto.getName());

        if (!productLastDetailOptional.isPresent()){
            ProductSubGroupDetail productSubGroupDetail = productSubGroupDetailRepository.findById(productLastDetailDto.getProductSubGroupDetailId())
                    .orElseThrow(()->new EntityNotFoundException(productLastDetailDto.getProductSubGroupDetailId().toString(),ProductLastDetail.class));

            productLastDetail.setProductSubGroupDetail(productSubGroupDetail);
        }
        productLastDetailRepository.save(productLastDetail);
        return productLastDetailDto;
    }

    public Boolean delete(Long id){
        List<Product> product = productRepository.findByProductLastDetailId(id);
        for (Product product1:product){
            product1.setProductLastDetail(null);
        }
        productRepository.saveAll(product);
        productLastDetailRepository.deleteById(id);
        return true;
    }

    public ProductLastDetailDto update(ProductLastDetailDto productLastDetailDto){
        Optional<ProductLastDetail> productLastDetailOptional = productLastDetailRepository.findById(productLastDetailDto.getId());
        if (productLastDetailOptional.isPresent()){
            ProductLastDetail productLastDetail = productLastDetailOptional.get();
            ProductLastDetailMapper.updateProductLastDetail(productLastDetail,productLastDetailDto);
            ProductSubGroupDetail productSubGroupDetail = productSubGroupDetailRepository.findById(productLastDetailDto.getProductSubGroupDetailId()).orElseThrow(()->new IllegalArgumentException("not found id"));
            productLastDetail.setProductSubGroupDetail(productSubGroupDetail);
            productLastDetailRepository.save(productLastDetail);
        }
        else {
            throw new IllegalArgumentException("not found id");
        }

        return productLastDetailDto;
    }

    public Page<ProductLastDetailDto> findProductLastDetailWithPagination(Pageable pageable, ProductLastDetailSearch productLastDetailSearch){
        if (productLastDetailSearch.getName() == null){
            productLastDetailSearch.setName("");
        }
        Page<ProductLastDetail> productLastDetails = productLastDetailRepository.findAllPageable(productLastDetailSearch.getName(),pageable);
        return productLastDetails.map(ProductLastDetailMapper::mapTo);
    }
}
