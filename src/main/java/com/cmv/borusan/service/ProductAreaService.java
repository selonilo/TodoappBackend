package com.cmv.borusan.service;

import com.cmv.borusan.model.dto.ProductAreaDto;
import com.cmv.borusan.model.entity.Product;
import com.cmv.borusan.model.entity.ProductArea;
import com.cmv.borusan.model.mapper.ProductAreaMapper;
import com.cmv.borusan.repository.ProductAreaRepository;
import com.cmv.borusan.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProductAreaService {

    private final ProductAreaRepository productAreaRepository;

    private final ProductRepository productRepository;

    public List<ProductAreaDto> getAll(){
        return ProductAreaMapper.mapToList(productAreaRepository.findAll());
    }

    public ProductAreaDto save(ProductAreaDto productAreaDto){
        ProductArea productArea = ProductAreaMapper.mapTo(productAreaDto);
        productAreaRepository.save(productArea);
        return productAreaDto;
    }

    public Boolean delete(Long id){
        List<Product> product = productRepository.findByProductAreaId(id);
        for (Product product1:product){
            product1.setProductArea(null);
        }
        productRepository.saveAll(product);
        productAreaRepository.deleteById(id);
        return true;
    }

}
