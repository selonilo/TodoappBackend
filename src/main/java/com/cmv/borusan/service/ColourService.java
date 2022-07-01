package com.cmv.borusan.service;

import com.cmv.borusan.model.dto.ColourDto;
import com.cmv.borusan.model.entity.Colour;
import com.cmv.borusan.model.entity.Product;
import com.cmv.borusan.model.mapper.ColourMapper;
import com.cmv.borusan.repository.ColourRepository;
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
public class ColourService {

    private final ColourRepository colourRepository;

    private final ProductRepository productRepository;

    public List<ColourDto> getAll(){
        return ColourMapper.mapToList(colourRepository.findAll());
    }

    public ColourDto saveColour(ColourDto colourDto){
        Colour colour = ColourMapper.mapTo(colourDto);
        colourRepository.save(colour);
        return colourDto;
    }

    public Boolean delete(Long id){
        List<Product> products = productRepository.findByColourId(id);
        for (Product product:products){
            product.setColour(null);
        }
        productRepository.saveAll(products);
        colourRepository.deleteById(id);
        return true;
    }
}
