package com.cmv.borusan.exception;


public class EntityNotFoundException extends BorusanException implements IErrorCode {

    public EntityNotFoundException(String id, Class clazz) {
        super(ENTITY_NOT_FOUND_EXCEPTION, null, new String[]{id, clazz.getSimpleName()});
    }

}