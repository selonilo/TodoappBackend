package com.cmv.borusan.model.entity;

import com.cmv.borusan.model.base.ExtendedModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Products extends ExtendedModel {

    @Column(name = "product_barcode")
    private String productBarcode;

    @Column(name = "product_group")
    private String productGroup;

    @Column(name = "product_sub_group")
    private String productSubGroup;

    @Column(name = "product_sub_group_detail")
    private String productSubGroupDetail;

    @Column(name = "product_last_detail")
    private String productLastDetail;

    @Column(name = "location")
    private String location;

    @Column(name = "sub_location")
    private String subLocation;

    @Column(name = "worker")
    private String worker;

    @Column(name = "product_area")
    private String productArea;

    @Column(name = "colour")
    private String colour;

    @Column(name = "number_plate")
    private String numberPlate;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "barcode_place")
    private String barcodePlace;

    @Column(name = "situation")
    private String situation;

    @Column(name = "calibration")
    private Boolean calibration;

    @Column(name = "calibration_date", columnDefinition = "TIMESTAMP")
    private Date calibrationDate;

    @Column(name = "device_serial_no")
    private String deviceSerialNo;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "power")
    private String power;

    @Column(name = "warranty_start_date", columnDefinition = "TIMESTAMP")
    private Date warrantyStartDate;

    @Column(name = "warranty_end_date", columnDefinition = "TIMESTAMP")
    private Date warrantyEndDate;

    @Column(name = "first_periodic_maintenance_date", columnDefinition = "TIMESTAMP")
    private Date firstPeriodicMaintenanceDate;

    @Column(name = "is_optional")
    private Boolean isOptional;

    @Column(name = "descriptions")
    private String descriptions;

}
