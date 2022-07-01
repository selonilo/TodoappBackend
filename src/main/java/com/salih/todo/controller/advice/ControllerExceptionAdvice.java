package com.salih.todo.controller.advice;

import com.salih.todo.exception.BorusanExceptionAdvice;
import com.salih.todo.exception.ExceptionUtil;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice extends BorusanExceptionAdvice {

    public ControllerExceptionAdvice(final ExceptionUtil exceptionUtil) {
        super(exceptionUtil);
    }

}
