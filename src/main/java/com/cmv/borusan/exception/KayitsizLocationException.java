package com.cmv.borusan.exception;

public class KayitsizLocationException extends BorusanException implements IErrorCode{

    public KayitsizLocationException(String name){
        super(LOCATION_EXCEPTION, null, new String[]{name});
    }
}
