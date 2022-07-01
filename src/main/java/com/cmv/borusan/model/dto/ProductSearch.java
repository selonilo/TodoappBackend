package com.cmv.borusan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearch {
    String sapCode;
    String productBarcode;
    String oldBarcode;
    String productGroup;
    String productSubGroup;
    String productSubGroupDetail;
    String productLastDetail;
    String location;
    String subLocation;
    String subLocationDetail;
    String worker;
    String productArea;
    String locations;
}
