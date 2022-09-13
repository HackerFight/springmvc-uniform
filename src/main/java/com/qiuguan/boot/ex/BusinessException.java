package com.qiuguan.boot.ex;

import com.qiuguan.boot.enums.ApiCommonCode;

/**
 * @author qiuguan
 * @date 2022/09/09 19:42:26  星期五
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(ApiCommonCode apiCommonCode) {
        super(apiCommonCode.getMessage());
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
