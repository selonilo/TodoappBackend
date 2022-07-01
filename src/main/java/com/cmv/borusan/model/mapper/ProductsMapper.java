package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.ProductsDto;
import com.cmv.borusan.model.dto.WorkerDto;
import com.cmv.borusan.model.entity.Products;
import com.cmv.borusan.model.entity.Worker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProductsMapper {


    public static ProductsDto mapTo(Products products){
        ProductsDto productsDto = new ProductsDto();
        productsDto.setId(products.getId());
        productsDto.setProductBarcode(products.getProductBarcode());
        productsDto.setProductGroup(products.getProductGroup());
        productsDto.setProductSubGroup(products.getProductSubGroup());
        productsDto.setProductSubGroupDetail(products.getProductSubGroupDetail());
        productsDto.setProductLastDetail(products.getProductLastDetail());
        productsDto.setLocation(products.getLocation());
        productsDto.setSubLocation(products.getSubLocation());
        productsDto.setWorker(products.getWorker());
        productsDto.setProductArea(products.getProductArea());
        productsDto.setColour(products.getColour());
        productsDto.setNumberPlate(products.getNumberPlate());
        productsDto.setUpdatedAt(products.getUpdatedAt());
        productsDto.setCreatedAt(products.getCreatedAt());
        productsDto.setBarcodePlace(products.getBarcodePlace());
        productsDto.setSituation(products.getSituation());
        productsDto.setCalibration(products.getCalibration());
        productsDto.setCalibrationDate(products.getCalibrationDate());
        productsDto.setDeviceSerialNo(products.getDeviceSerialNo());
        productsDto.setBrand(products.getBrand());
        productsDto.setModel(products.getModel());
        productsDto.setScreenSize(products.getScreenSize());
        productsDto.setPower(products.getPower());
        productsDto.setWarrantyStartDate(products.getWarrantyStartDate());
        productsDto.setWarrantyEndDate(products.getWarrantyEndDate());
        productsDto.setFirstPeriodicMaintenanceDate(products.getFirstPeriodicMaintenanceDate());
        productsDto.setIsOptional(products.getIsOptional());
        productsDto.setDescriptions(products.getDescriptions());
        return productsDto;
    }

    public static Products mapTo(ProductsDto productsDto){
        Products products = new Products();
        products.setId(productsDto.getId());
        products.setProductBarcode(productsDto.getProductBarcode());
        products.setProductGroup(productsDto.getProductGroup());
        products.setProductSubGroup(productsDto.getProductSubGroup());
        products.setProductSubGroupDetail(productsDto.getProductSubGroupDetail());
        products.setProductLastDetail(productsDto.getProductLastDetail());
        products.setLocation(productsDto.getLocation());
        products.setSubLocation(productsDto.getSubLocation());
        products.setWorker(productsDto.getWorker());
        products.setProductArea(productsDto.getProductArea());
        products.setColour(productsDto.getColour());
        products.setNumberPlate(productsDto.getNumberPlate());
        products.setUpdatedAt(LocalDateTime.now());
        products.setCreatedAt(LocalDateTime.now());
        products.setBarcodePlace(productsDto.getBarcodePlace());
        products.setSituation(productsDto.getSituation());
        products.setCalibration(productsDto.getCalibration());
        products.setCalibrationDate(productsDto.getCalibrationDate());
        products.setDeviceSerialNo(productsDto.getDeviceSerialNo());
        products.setBrand(productsDto.getBrand());
        products.setModel(productsDto.getModel());
        products.setScreenSize(productsDto.getScreenSize());
        products.setPower(productsDto.getPower());
        products.setWarrantyStartDate(productsDto.getWarrantyStartDate());
        products.setWarrantyEndDate(productsDto.getWarrantyEndDate());
        products.setFirstPeriodicMaintenanceDate(productsDto.getFirstPeriodicMaintenanceDate());
        products.setIsOptional(productsDto.getIsOptional());
        products.setDescriptions(productsDto.getDescriptions());
        return products;
    }

    public static Products updateProducts(Products entity, ProductsDto dto){
        entity.setId(dto.getId());
        entity.setProductBarcode(dto.getProductBarcode());
        entity.setProductGroup(dto.getProductGroup());
        entity.setProductSubGroup(dto.getProductSubGroup());
        entity.setProductSubGroupDetail(dto.getProductSubGroupDetail());
        entity.setProductLastDetail(dto.getProductLastDetail());
        entity.setLocation(dto.getLocation());
        entity.setSubLocation(dto.getSubLocation());
        entity.setWorker(dto.getWorker());
        entity.setProductArea(dto.getProductArea());
        entity.setColour(dto.getColour());
        entity.setNumberPlate(dto.getNumberPlate());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setBarcodePlace(dto.getBarcodePlace());
        entity.setSituation(dto.getSituation());
        entity.setCalibration(dto.getCalibration());
        entity.setCalibrationDate(dto.getCalibrationDate());
        entity.setDeviceSerialNo(dto.getDeviceSerialNo());
        entity.setBrand(dto.getBrand());
        entity.setModel(dto.getModel());
        entity.setScreenSize(dto.getScreenSize());
        entity.setPower(dto.getPower());
        entity.setWarrantyStartDate(dto.getWarrantyStartDate());
        entity.setWarrantyEndDate(dto.getWarrantyEndDate());
        entity.setFirstPeriodicMaintenanceDate(dto.getFirstPeriodicMaintenanceDate());
        entity.setIsOptional(dto.getIsOptional());
        entity.setDescriptions(dto.getDescriptions());
        return entity;
    }


    public static List<ProductsDto> mapToList(List<Products> dtos){
        if(dtos == null){
            return null;
        }
        return dtos.stream().map(ProductsMapper::mapTo).collect(Collectors.toList());
    }
}
