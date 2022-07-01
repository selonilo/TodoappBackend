package com.cmv.borusan.service;

import com.cmv.borusan.exception.EntityNotFoundException;
import com.cmv.borusan.exception.KayitliBarcodeException;
import com.cmv.borusan.model.dto.ProductsDto;
import com.cmv.borusan.model.dto.ProductsSearch;
import com.cmv.borusan.model.entity.Products;
import com.cmv.borusan.model.mapper.ProductsMapper;
import com.cmv.borusan.repository.ProductsRepository;
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
public class ProductsService {

    private final ProductsRepository productsRepository;

    public List<ProductsDto> getAll() {
        return ProductsMapper.mapToList(productsRepository.findAll());
    }

    public ProductsDto saveProducts(ProductsDto productsDto){
        Products products = ProductsMapper.mapTo(productsDto);
        Optional<Products> productsOptional = productsRepository.findByProductBarcode(productsDto.getProductBarcode());
        if (productsOptional.isPresent()){
            throw new KayitliBarcodeException(productsDto.getProductBarcode());
        }
        productsRepository.save(products);
        return productsDto;
    }

    public Boolean delete(Long id){
        productsRepository.deleteById(id);
        return true;
    }

    public ProductsDto update(ProductsDto productsDto){
        Products products= productsRepository.findById(productsDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(productsDto.getId().toString(), Products.class));
        ProductsMapper.updateProducts(products, productsDto);
        productsRepository.save(products);
        return productsDto;
    }

    public Page<ProductsDto> findProductsWithPagination(Pageable pageable, ProductsSearch productsSearch){
        if (productsSearch.getProductBarcode() == null){
            productsSearch.setProductBarcode("");
        }
        if (productsSearch.getProductGroup() == null){
            productsSearch.setProductGroup("");
        }
        if (productsSearch.getProductSubGroup() == null){
            productsSearch.setProductSubGroup("");
        }
        if (productsSearch.getProductSubGroupDetail() == null){
            productsSearch.setProductSubGroupDetail("");
        }
        if (productsSearch.getProductLastDetail() == null){
            productsSearch.setProductLastDetail("");
        }
        if (productsSearch.getLocation() == null){
            productsSearch.setLocation("");
        }
        if (productsSearch.getSubLocation() == null){
            productsSearch.setSubLocation("");
        }
        if (productsSearch.getWorker() == null){
            productsSearch.setWorker("");
        }
        if (productsSearch.getProductArea() == null){
            productsSearch.setProductArea("");
        }
        if (productsSearch.getColour() == null){
            productsSearch.setColour("");
        }
        Page<Products> products = productsRepository.findAllProducts(productsSearch.getProductBarcode(),productsSearch.getProductGroup(), productsSearch.getProductSubGroup(), productsSearch.getProductSubGroupDetail(),
                productsSearch.getProductLastDetail(),productsSearch.getLocation(),productsSearch.getSubLocation(),productsSearch.getWorker(),productsSearch.getProductArea(),productsSearch.getColour(),pageable);
        return products.map(ProductsMapper::mapTo);
    }


}
