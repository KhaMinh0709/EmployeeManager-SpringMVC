package com.DevJavaMinh.BESpringBoot05.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceExceptionNOtFound extends RuntimeException {
    public ResourceExceptionNOtFound(String msg) {
        super(msg);
    }
}
