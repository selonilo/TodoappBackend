package com.cmv.borusan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsSearch {
    String productBarcode;
    String productGroup;
    String productSubGroup;
    String productSubGroupDetail;
    String productLastDetail;
    String location;
    String subLocation;
    String worker;
    String productArea;
    String colour;
}
