package com.cmv.borusan.exception;

import org.springframework.http.HttpStatus;

public class GeneralException extends BorusanException implements IErrorCode {

    private static final long serialVersionUID = 1L;

    public GeneralException(String message) {
        super(GENERAL_EXCEPTION, null, null, new String[]{"message"}, new String[]{message}, HttpStatus.BAD_REQUEST);
    }

}