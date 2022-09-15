package com.qiuguan.boot.handler;

import com.qiuguan.boot.enums.ApiCodeEnum;
import com.qiuguan.boot.ex.BusinessException;
import com.qiuguan.boot.result.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

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
        return ApiResult.fail(ex.getApiCommonCode());
    }

    /**
     * Controller上一层异常 ?
     * @see <a href="https://blog.csdn.net/ju_362204801/article/details/105726458"></a>
     */
    @ExceptionHandler({
            MissingPathVariableException.class,
            MissingRequestHeaderException.class,
            MissingServletRequestParameterException.class,
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public ApiResult<?> handleMissParamEx(Exception e){
        log.error("miss param", e);
        return ApiResult.fail(ApiCodeEnum.PARAM_MISS);
    }

    /**
     * 参数绑定异常，比如：bean的某个属性标注了 @NotNull, 但是没有传值，则会来到这里
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ApiResult<?> handleBindException(BindException e) {
        log.error("参数绑定异常: {}", e.getBindingResult());

        return ApiResult.fail(ApiCodeEnum.PARAM_ILLEGAL);
    }

    /**
     * 参数校验异常 ？
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiResult<?> handleValidException(MethodArgumentNotValidException e) {
        log.error("参数校验异常: {}", e.getBindingResult());

        return ApiResult.fail(ApiCodeEnum.PARAM_ILLEGAL);
    }


    @ExceptionHandler(Exception.class)
    public ApiResult<?> handleSystemEx(Exception e){
        log.error("系统异常", e);
        return ApiResult.fail(ApiCodeEnum.ERROR);
    }

    @ExceptionHandler(Throwable.class)
    public ApiResult<?> handleSystemError(Throwable e){
        log.error("系统错误", e);
        return ApiResult.fail(ApiCodeEnum.ERROR);
    }
}
