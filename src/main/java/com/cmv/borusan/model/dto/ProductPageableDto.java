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
public class ProductPageableDto {
    private Long id;
    private String productBarcode;
    private String oldBarcode;
    private String sapCode;
    private String locationName;
    private Long locationId;
    private String subLocationName;
    private String subLocationDescription;
    private Long subLocationId;
    private String subLocationDetailName;
    private String colour;
    private Long subLocationDetailId;
    private String productGroupName;
    private Long productGroupId;
    private String productSubGroupName;
    private Long productSubGroupId;
    private String productSubGroupDetailName;
    private Long productSubGroupDetailId;
    private String productLastDetailName;
    private Long productLastDetailId;
    private Long productAreaId;
    private String productAreaName;
    private String workerName;
    private String workerSurname;
    private Long workerId;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private String dynamicPath;
    private String fileType;
    private String basePath;

    private String dynamicPath1;
    private String fileType1;
    private String basePath1;

    private String dynamicPath2;
    private String fileType2;
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
    private Long numberPlateId;
    private Long colourId;
    private String barcodePlace;
}
