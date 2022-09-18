package com.qiuguan.boot.resolver;

import java.lang.annotation.*;

/**
 * @author qiuguan
 * @date 2022/09/18 17:46:19  星期日
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnumParam {

}
