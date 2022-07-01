package com.cmv.borusan.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyUsedException extends BorusanException implements IErrorCode {

    public EmailAlreadyUsedException() {
        super(EMAIL_ALREADY_USED_EXCEPTION, null, null, null, null, HttpStatus.BAD_REQUEST);
    }

}