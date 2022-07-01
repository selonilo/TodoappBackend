package com.cmv.borusan.model.mapper;

import com.cmv.borusan.model.dto.ProductDto;
import com.cmv.borusan.model.dto.ProductPageableDto;
import com.cmv.borusan.model.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProductMapper {

    public static ProductPageableDto mapToPageable(Product product) {
        ProductPageableDto productPageableDto = new ProductPageableDto();
        productPageableDto.setId(product.getId());
        productPageableDto.setProductBarcode(product.getProductBarcode());
        if (product.getOldBarcode() != null) {
            productPageableDto.setOldBarcode(product.getOldBarcode());
        }
        if (product.getSapCode() != null) {
            productPageableDto.setSapCode(product.getSapCode());
        }
        if (product.getDeviceSerialNo() != null){
            productPageableDto.setDeviceSerialNo(product.getDeviceSerialNo());
        }
        if (product.getBrand() != null){
            productPageableDto.setBrand(product.getBrand());
        }
        if (product.getModel() != null){
            productPageableDto.setModel(product.getModel());
        }
        if (product.getPower() != null){
            productPageableDto.setPower(product.getPower());
        }
        if (product.getBatteryChangeDate() != null){
            productPageableDto.setBatteryChangeDate(product.getBatteryChangeDate());
        }
        if (product.getLocationTip() != null){
            productPageableDto.setLocationTip(product.getLocationTip());
        }
        if (product.getWarranty() != null){
            productPageableDto.setWarranty(product.getWarranty());
        }
        if (product.getWarrantyEndDate() != null){
            productPageableDto.setWarrantyEndDate(product.getWarrantyEndDate());
        }
        if (product.getWarrantyStartDate() != null){
            productPageableDto.setWarrantyStartDate(product.getWarrantyStartDate());
        }
        if (product.getPeriodicMaintenance() != null){
            productPageableDto.setPeriodicMaintenance(product.getPeriodicMaintenance());
        }
        if (product.getFirstPeriodicMaintenanceDate() != null){
            productPageableDto.setFirstPeriodicMaintenanceDate(product.getFirstPeriodicMaintenanceDate());
        }
        if (product.getTechnicalService() != null){
            productPageableDto.setTechnicalService(product.getTechnicalService());
        }
        if (product.getSituation() != null){
            productPageableDto.setSituation(product.getSituation());
        }
        if (product.getColumn1() != null){
            productPageableDto.setColumn1(product.getColumn1());
        }
        if (product.getColumn2() != null){
            productPageableDto.setColumn2(product.getColumn2());
        }
        if (product.getColumn3() != null){
            productPageableDto.setColumn3(product.getColumn3());
        }
        if (product.getColumn4() != null){
            productPageableDto.setColumn4(product.getColumn4());
        }
        if (product.getColumn5() != null){
            productPageableDto.setColumn5(product.getColumn5());
        }
        if (product.getCalibration() != null){
            productPageableDto.setCalibration(product.getCalibration());
        }
        if (product.getCalibrationDate() != null){
            productPageableDto.setCalibrationDate(product.getCalibrationDate());
        }
        if (product.getDescriptions() != null){
            productPageableDto.setDescriptions(product.getDescriptions());
        }
        if (product.getOperator() != null){
            productPageableDto.setOperator(product.getOperator());
        }
        if (product.getResponsiblePerson() != null){
            productPageableDto.setResponsiblePerson(product.getResponsiblePerson());
        }
        if (product.getWarrantyPeriod() != null){
            productPageableDto.setWarrantyPeriod(product.getWarrantyPeriod());
        }
        if (product.getScreenSize() != null){
            productPageableDto.setScreenSize(product.getScreenSize());
        }
        if (product.getCapacity() != null){
            productPageableDto.setCapacity(product.getCapacity());
        }
        if (product.getFillingDate() != null){
            productPageableDto.setFillingDate(product.getFillingDate());
        }

        productPageableDto.setLocationName(product.getLocation().getName());
        productPageableDto.setLocationId(product.getLocation().getId());
        productPageableDto.setCreatedAt(product.getCreatedAt());
        productPageableDto.setUpdatedAt(product.getUpdatedAt());
        if (product.getProductArea() != null){
            productPageableDto.setProductAreaName(product.getProductArea().getName());
            productPageableDto.setProductAreaId(product.getProductArea().getId());
        }

        if (product.getSubLocation() != null) {
            productPageableDto.setSubLocationName(product.getSubLocation().getName());
            productPageableDto.setSubLocationId(product.getSubLocation().getId());
            productPageableDto.setSubLocationDescription(product.getSubLocation().getDescription());
        }
        if (product.getSubLocationDetail() != null) {
            productPageableDto.setSubLocationDetailName(product.getSubLocationDetail().getName());
            productPageableDto.setSubLocationDetailId(product.getSubLocationDetail().getId());
        }
        productPageableDto.setProductGroupName(product.getProductGroup().getName());
        productPageableDto.setProductGroupId(product.getProductGroup().getId());
        if (product.getProductSubGroup() != null) {
            productPageableDto.setProductSubGroupName(product.getProductSubGroup().getName());
            productPageableDto.setProductSubGroupId(product.getProductSubGroup().getId());
        }
        if (product.getProductSubGroupDetail() != null) {
            productPageableDto.setProductSubGroupDetailName(product.getProductSubGroupDetail().getName());
            productPageableDto.setProductSubGroupDetailId(product.getProductSubGroupDetail().getId());
        }
        if (product.getProductLastDetail() != null) {
            productPageableDto.setProductLastDetailName(product.getProductLastDetail().getName());
            productPageableDto.setProductLastDetailId(product.getProductLastDetail().getId());
        }
        if (product.getWorker() != null) {
            productPageableDto.setWorkerName(product.getWorker().getName());
            productPageableDto.setWorkerId(product.getWorker().getId());
            productPageableDto.setWorkerSurname(product.getWorker().getSurname());
        }
        if (product.getColour() != null){
            productPageableDto.setColour(product.getColour().getName());
            productPageableDto.setColourId(product.getColour().getId());
        }
        if (product.getNumberPlate() != null){
            productPageableDto.setNumberPlate(product.getNumberPlate().getName());
            productPageableDto.setNumberPlateId(product.getNumberPlate().getId());
        }
        if (product.getDynamicPath() != null) {
            productPageableDto.setDynamicPath(product.getDynamicPath());
        }
        if (product.getFileType() != null){
            productPageableDto.setFileType(product.getFileType());
        }
        if (product.getBasePath() != null){
            productPageableDto.setBasePath(product.getBasePath());
        }

        if (product.getDynamicPath1() != null) {
            productPageableDto.setDynamicPath1(product.getDynamicPath1());
        }
        if (product.getFileType1() != null){
            productPageableDto.setFileType1(product.getFileType1());
        }
        if (product.getBasePath1() != null){
            productPageableDto.setBasePath1(product.getBasePath1());
        }

        if (product.getDynamicPath2() != null) {
            productPageableDto.setDynamicPath1(product.getDynamicPath2());
        }
        if (product.getFileType2() != null){
            productPageableDto.setFileType2(product.getFileType2());
        }
        if (product.getBasePath2() != null){
            productPageableDto.setBasePath2(product.getBasePath2());
        }

        if (product.getLocations() != null){
            productPageableDto.setLocations(product.getLocations());
        }
        if (product.getIsOptional() != null){
            productPageableDto.setIsOptional(product.getIsOptional());
        }
        if (product.getBarcodePlace() != null){
            productPageableDto.setBarcodePlace(product.getBarcodePlace());
        }

        return productPageableDto;
    }

    public static ProductDto mapTo(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        if (product.getLocation() != null) {
            productDto.setLocationDto(LocationMapper.mapTo(product.getLocation()));
        }
        if (product.getProductArea() != null){
            productDto.setProductAreaDto(ProductAreaMapper.mapTo(product.getProductArea()));
        }

        if (product.getSubLocation() != null) {
            productDto.setSubLocationDto(SubLocationMapper.mapTo(product.getSubLocation()));
        }
        if (product.getSubLocationDetail() != null) {
            productDto.setSubLocationDetailDto(SubLocationDetailMapper.mapTo(product.getSubLocationDetail()));
        }
        if (product.getProductGroup() != null) {
            productDto.setProductGroupDto(ProductGroupMapper.mapTo(product.getProductGroup()));
        }
        if (product.getProductSubGroup() != null) {
            productDto.setProductSubGroupDto(ProductSubGroupMapper.mapTo(product.getProductSubGroup()));
        }
        if (product.getProductSubGroupDetail() != null) {
            productDto.setProductSubGroupDetailDto(ProductSubGroupDetailMapper.mapTo(product.getProductSubGroupDetail()));
        }
        if (product.getProductLastDetail() != null) {
            productDto.setProductLastDetailDto(ProductLastDetailMapper.mapTo(product.getProductLastDetail()));
        }
        if (product.getWorker() != null) {
            productDto.setWorkerDto(WorkerMapper.mapTo(product.getWorker()));
        }
        if (product.getColour() != null){
            productDto.setColourDto(ColourMapper.mapTo(product.getColour()));
        }
        if (product.getNumberPlate() != null){
            productDto.setNumberPlateDto(NumberPlateMapper.mapTo(product.getNumberPlate()));
        }
        productDto.setOldBarcode(product.getOldBarcode());
        productDto.setSapCode(product.getSapCode());
        productDto.setProductBarcode(product.getProductBarcode());
        productDto.setUpdatedAt(product.getUpdatedAt());
        productDto.setCreatedAt(product.getCreatedAt());
        productDto.setUpdateUser(product.getUpdateUser());
        productDto.setCreateUser(product.getCreateUser());
        productDto.setDynamicPath(product.getDynamicPath());
        productDto.setDeviceSerialNo(product.getDeviceSerialNo());
        productDto.setBrand(product.getBrand());
        productDto.setModel(product.getModel());
        productDto.setPower(product.getPower());
        productDto.setBatteryChangeDate(product.getBatteryChangeDate());
        productDto.setLocationTip(product.getLocationTip());
        productDto.setWarranty(product.getWarranty());
        productDto.setWarrantyStartDate(product.getWarrantyStartDate());
        productDto.setWarrantyEndDate(product.getWarrantyEndDate());
        productDto.setPeriodicMaintenance(product.getPeriodicMaintenance());
        productDto.setFirstPeriodicMaintenanceDate(product.getFirstPeriodicMaintenanceDate());
        productDto.setTechnicalService(product.getTechnicalService());
        productDto.setSituation(product.getSituation());
        productDto.setColumn1(product.getColumn1());
        productDto.setColumn2(product.getColumn2());
        productDto.setColumn3(product.getColumn3());
        productDto.setColumn4(product.getColumn4());
        productDto.setColumn5(product.getColumn5());
        productDto.setCalibrationDate(product.getCalibrationDate());
        productDto.setDescriptions(product.getDescriptions());
        productDto.setOperator(product.getOperator());
        productDto.setResponsiblePerson(product.getResponsiblePerson());
        productDto.setWarrantyPeriod(product.getWarrantyPeriod());
        productDto.setScreenSize(product.getScreenSize());
        productDto.setCapacity(product.getCapacity());
        productDto.setFillingDate(product.getFillingDate());
        productDto.setCalibration(product.getCalibration());
        productDto.setLocations(product.getLocations());
        productDto.setIsOptional(product.getIsOptional());
        productDto.setBarcodePlace(product.getBarcodePlace());
        return productDto;
    }

    public static Product mapTo(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setDeviceSerialNo(productDto.getDeviceSerialNo());
        product.setBrand(productDto.getBrand());
        product.setModel(productDto.getModel());
        product.setPower(productDto.getPower());
        product.setBatteryChangeDate(productDto.getBatteryChangeDate());
        product.setLocationTip(productDto.getLocationTip());
        product.setWarranty(productDto.getWarranty());
        product.setWarrantyStartDate(productDto.getWarrantyStartDate());
        product.setWarrantyEndDate(productDto.getWarrantyEndDate());
        product.setPeriodicMaintenance(productDto.getPeriodicMaintenance());
        product.setFirstPeriodicMaintenanceDate(productDto.getFirstPeriodicMaintenanceDate());
        product.setTechnicalService(productDto.getTechnicalService());
        product.setSituation(productDto.getSituation());
        product.setColumn1(productDto.getColumn1());
        product.setColumn2(productDto.getColumn2());
        product.setColumn3(productDto.getColumn3());
        product.setColumn4(productDto.getColumn4());
        product.setColumn5(productDto.getColumn5());
        product.setOldBarcode(productDto.getOldBarcode());
        product.setSapCode(productDto.getSapCode());
        product.setProductBarcode(productDto.getProductBarcode());
        product.setUpdatedAt(LocalDateTime.now());
        product.setCreatedAt(LocalDateTime.now());
        product.setCalibrationDate(productDto.getCalibrationDate());
        product.setDescriptions(productDto.getDescriptions());
        product.setOperator(productDto.getOperator());
        product.setResponsiblePerson(productDto.getResponsiblePerson());
        product.setWarrantyPeriod(productDto.getWarrantyPeriod());
        product.setScreenSize(productDto.getScreenSize());
        product.setCapacity(productDto.getCapacity());
        product.setFillingDate(productDto.getFillingDate());
        product.setUpdateUser(productDto.getUpdateUser());
        product.setCreateUser(productDto.getCreateUser());
        product.setFileType(productDto.getFileType());
        product.setCalibration(productDto.getCalibration());
        product.setLocations(productDto.getLocations());
        product.setIsOptional(productDto.getIsOptional());
        product.setBarcodePlace(productDto.getBarcodePlace());
        return product;
    }

    public static Product updateProduct(Product entity, ProductDto dto) {
        entity.setId(dto.getId());
        entity.setOldBarcode(dto.getOldBarcode());
        entity.setSapCode(dto.getSapCode());
        entity.setProductBarcode(dto.getProductBarcode());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setUpdateUser(dto.getUpdateUser());
        entity.setDynamicPath(dto.getDynamicPath());
        entity.setFileType(dto.getFileType());
        entity.setBasePath(dto.getBasePath());

        entity.setDynamicPath1(dto.getDynamicPath1());
        entity.setFileType1(dto.getFileType1());
        entity.setBasePath1(dto.getBasePath1());

        entity.setDynamicPath2(dto.getDynamicPath2());
        entity.setFileType2(dto.getFileType2());
        entity.setBasePath2(dto.getBasePath2());
        return entity;
    }

    public static List<ProductDto> mapToList(List<Product> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream().map(ProductMapper::mapTo).collect(Collectors.toList());
    }


}
