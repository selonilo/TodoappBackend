package com.cmv.borusan.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDto {

    private Long id;
    private String productBarcode;
    private String productGroup;
    private String productSubGroup;
    private String productSubGroupDetail;
    private String productLastDetail;
    private String location;
    private String subLocation;
    private String worker;
    private String productArea;
    private String colour;
    private String numberPlate;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private String createUser;
    private String updateUser;
    private String barcodePlace;
    private String situation;
    private Boolean calibration;
    private Date calibrationDate;
    private String deviceSerialNo;
    private String brand;
    private String model;
    private String screenSize;
    private String power;
    private Date warrantyStartDate;
    private Date warrantyEndDate;
    private Date firstPeriodicMaintenanceDate;
    private Boolean isOptional;
    private String descriptions;
}
