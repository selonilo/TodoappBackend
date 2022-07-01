package com.cmv.borusan.exception;

public class KayitliBarcodeException extends BorusanException implements IErrorCode{

    public KayitliBarcodeException(String productBarcode) {
        super(BARCODE_EXCEPTION, null, new String[]{productBarcode});
    }

}
