package com.example.server.exception;

import com.example.server.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class PoiExceptionHandler {

    @ExceptionHandler(PoiException.class)
    public Result handlePoiException(PoiException e) {
        log.info("e=",e.getMessage());
        return Result.error(e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public Result hanleException(Exception e){
        log.info("e=",e.getMessage());
        return Result.error(e.getMessage());
    }
}
