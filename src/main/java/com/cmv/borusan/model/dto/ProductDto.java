package com.cmv.borusan.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String productBarcode;
    private Long productGroupId;
    private ProductGroupDto productGroupDto;
    private Long productSubGroupId;
    private ProductSubGroupDto productSubGroupDto;
    private Long productSubGroupDetailId;
    private ProductSubGroupDetailDto productSubGroupDetailDto;
    private Long productLastDetailId;
    private ProductLastDetailDto productLastDetailDto;
    private Long locationId;
    private LocationDto locationDto;
    private ProductAreaDto productAreaDto;
    private Long productAreaId;
    private ColourDto colourDto;
    private Long subLocationId;
    private String subLocationName;
    private String subLocationDescription;
    private SubLocationDto subLocationDto;
    private Long subLocationDetailId;
    private SubLocationDetailDto subLocationDetailDto;
    private Long workerId;
    private WorkerDto workerDto;
    private String sapCode;
    private String oldBarcode;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private String createUser;
    private String updateUser;
    private String dynamicPath;
    private String publicId;
    private String publicId1;
    private String publicId2;
    private String fileType;
    private String encodedImage;
    private String basePath;
    private String dynamicPath1;
    private String fileType1;
    private String encodedImage1;
    private String basePath1;
    private String dynamicPath2;
    private String fileType2;
    private String encodedImage2;
    private String basePath2;
    private String deviceSerialNo;
    private String brand;
    private String model;
    private String power;
    private Date batteryChangeDate;
    private String locationTip;
    private Boolean warranty;
    private String warrantyStartDate;
    private String warrantyEndDate;
    private Boolean periodicMaintenance;
    private Date firstPeriodicMaintenanceDate;
    private String technicalService;
    private String situation;
    private String column1;
    private String column2;
    private String column3;
    private String column4;
    private String column5;
    private Long colourId;
    private String colour;
    private String calibrationDate;
    private String descriptions;
    private String operator;
    private String responsiblePerson;
    private String warrantyPeriod;
    private String screenSize;
    private String capacity;
    private Date fillingDate;
    private Boolean calibration;
    private String locations;
    private Boolean isOptional;
    private String numberPlate;
    private NumberPlateDto numberPlateDto;
    private Long numberPlateId;
    private String barcodePlace;

}
