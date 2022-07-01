package com.cmv.borusan.exception;

public class UygulamaGuncelleException extends BorusanException implements IErrorCode{

    public UygulamaGuncelleException(String name){
        super(UYGULAMA_EXCEPTION, null, new String[]{name});
    }
}
