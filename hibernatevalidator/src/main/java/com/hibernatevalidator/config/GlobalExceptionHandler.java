package com.hibernatevalidator.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author xiaolong
 * @create 2020-07-19 19:31
 * @description 全局异常捕获类
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Object expHandler(Exception e){
        if (e instanceof MethodArgumentNotValidException){
            log.error(e.getMessage());
            String msg="";
            List<ObjectError> errors=((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            for(ObjectError error : errors){
                msg += error.getDefaultMessage();
                msg += ",";
            }
            return msg;
        }
        else if(e instanceof HttpMessageNotReadableException){
            log.error(e.getMessage());
            return "输入参数不合规范";
        }
        return null;
    }
}
