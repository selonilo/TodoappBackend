package com.cmv.borusan.controller.advice;

import com.cmv.borusan.exception.BorusanExceptionAdvice;
import com.cmv.borusan.exception.ExceptionUtil;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice extends BorusanExceptionAdvice {

    public ControllerExceptionAdvice(final ExceptionUtil exceptionUtil) {
        super(exceptionUtil);
    }

}
