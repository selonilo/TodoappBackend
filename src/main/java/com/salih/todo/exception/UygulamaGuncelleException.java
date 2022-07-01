package com.salih.todo.exception;

public class UygulamaGuncelleException extends BorusanException implements IErrorCode{

    public UygulamaGuncelleException(String name){
        super(UYGULAMA_EXCEPTION, null, new String[]{name});
    }
}
