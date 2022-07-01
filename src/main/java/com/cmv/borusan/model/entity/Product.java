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
@Table(name = "product")
public class Product extends ExtendedModel {

    @Column(name = "product_barcode")
    private String productBarcode;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductGroup productGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductSubGroup productSubGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductSubGroupDetail productSubGroupDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductLastDetail productLastDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    private SubLocation subLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    private SubLocationDetail subLocationDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    private Worker worker;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductArea productArea;

    @ManyToOne(fetch = FetchType.LAZY)
    private Colour colour;

    @ManyToOne(fetch = FetchType.LAZY)
    private NumberPlate numberPlate;

    @Column(name = "sap_code")
    private String sapCode;

    @Column(name = "old_barcode")
    private String oldBarcode;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "name")
    private String name;

    @Column(name = "baseUrl")
    private String baseUrl;

    @Column(name = "basePath")
    private String basePath;

    @Column(name = "dynamicPath")
    private String dynamicPath;

    @Column(name = "baseUrl1")
    private String baseUrl1;

    @Column(name = "basePath1")
    private String basePath1;

    @Column(name = "dynamicPath1")
    private String dynamicPath1;

    @Column(name = "baseUrl2")
    private String baseUrl2;

    @Column(name = "basePath2")
    private String basePath2;

    @Column(name = "dynamicPath2")
    private String dynamicPath2;

    @Column(name = "publicId")
    private String publicId;

    @Column(name = "publicId1")
    private String publicId1;

    @Column(name = "publicId2")
    private String publicId2;

    @Column(name = "device_serial_no")
    private String deviceSerialNo;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "power")
    private String power;

    @Column(name = "battery_change_date", columnDefinition = "TIMESTAMP")
    private Date batteryChangeDate;

    @Column(name = "location_tip")
    private String locationTip;

    @Column(name = "warranty")
    private Boolean warranty;

    @Column(name = "warranty_start_date_s")
    private String warrantyStartDate;

    @Column(name = "warranty_end_date_s")
    private String warrantyEndDate;

    @Column(name = "periodic_maintenance")
    private Boolean periodicMaintenance;

    @Column(name = "first_periodic_maintenance_date", columnDefinition = "TIMESTAMP")
    private Date firstPeriodicMaintenanceDate;

    @Column(name = "technical_service")
    private String technicalService;

    @Column(name = "situation")
    private String situation;

    @Column(name = "column1")
    private String column1;

    @Column(name = "column2")
    private String column2;

    @Column(name = "column3")
    private String column3;

    @Column(name = "column4")
    private String column4;

    @Column(name = "column5")
    private String column5;

    @Column(name = "calibration")
    private Boolean calibration;

    @Column(name = "calibration_date_s")
    private String calibrationDate;

    @Column(name = "descriptions")
    private String descriptions;

    @Column(name = "operator")
    private String operator;

    @Column(name = "responsible_person")
    private String responsiblePerson;

    @Column(name = "warrant_period")
    private String warrantyPeriod;

    @Column(name = "screenSize")
    private String screenSize;

    @Column(name = "capacity")
    private String capacity;

    @Column(name = "locations")
    private String locations;

    @Column(name = "filling_date", columnDefinition = "TIMESTAMP")
    private Date fillingDate;

    @Column(name = "is_optional")
    private Boolean isOptional;

    @Column(name = "barcode_place")
    private String barcodePlace;

    private String fileType;

    private String encodedImage;

    private String fileType1;

    private String encodedImage1;

    private String fileType2;

    private String encodedImage2;

    public String getPublicAddress() {
        return baseUrl + dynamicPath;
    }

}
