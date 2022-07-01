package com.cmv.borusan.service;

import com.cmv.borusan.model.dto.NumberPlateDto;
import com.cmv.borusan.model.entity.NumberPlate;
import com.cmv.borusan.model.entity.Product;
import com.cmv.borusan.model.mapper.NumberPlateMapper;
import com.cmv.borusan.repository.NumberPlateRepository;
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
public class NumberPlateService {

    private final ProductRepository productRepository;

    private final NumberPlateRepository numberPlateRepository;

    public List<NumberPlateDto> getAll(){return NumberPlateMapper.mapToList(numberPlateRepository.findAll());
    }

    public NumberPlateDto saveNumberPlate(NumberPlateDto numberPlateDto){
        NumberPlate numberPlate = NumberPlateMapper.mapTo(numberPlateDto);
        numberPlateRepository.save(numberPlate);
        return numberPlateDto;
    }

    public Boolean delete(Long id){
        List<Product> products = productRepository.findByNumberPlateId(id);
        for (Product product:products){
            product.setNumberPlate(null);
        }
        productRepository.saveAll(products);
        numberPlateRepository.deleteById(id);
        return true;
    }
}
