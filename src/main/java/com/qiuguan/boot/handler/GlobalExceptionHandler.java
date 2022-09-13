package com.qiuguan.boot.handler;

import com.qiuguan.boot.ex.BusinessException;
import com.qiuguan.boot.result.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author qiuguan
 * @date 2022/09/09 19:43:00  星期五
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    public ApiResult<?> handleBusinessEx(BusinessException ex){
        log.error("业务异常", ex);
        return ApiResult.fail(ex);
    }

    @ExceptionHandler({
            MissingPathVariableException.class,
            MissingRequestHeaderException.class,
            MissingServletRequestParameterException.class
    })
    public ApiResult<?> handleMissParamEx(Exception e){
        log.error("miss param", e);
        return ApiResult.fail(e);
    }

    @ExceptionHandler(Exception.class)
    public ApiResult<?> handleSystemEx(Exception e){
        log.error("系统异常", e);
        return ApiResult.fail(e);
    }
}
