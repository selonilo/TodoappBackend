package com.cmv.borusan.exception;

public class KullaniciAdiSifreException extends BorusanException implements IErrorCode{

    public KullaniciAdiSifreException(String name){
        super(AUTH_EXCEPTION, null, new String[]{name});
    }
}
