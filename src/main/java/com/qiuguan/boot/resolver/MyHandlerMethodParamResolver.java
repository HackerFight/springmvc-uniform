package com.qiuguan.boot.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qiuguan
 * @date 2022/09/18 17:41:09  星期日
 *
 * 我们知道，如果前端传入使用POST请求传入的是'Content-Type: application/json' 类型的数据，
 * 那么 Controller类需要使用 {@link RequestBody} 注解
 * 去标注，否则无法完成映射，那么我现在不使用 {@link RequestBody} 注解，而使用自定义的 {@link  RequestBodyMapping}
 * 注解完成映射
 */
public class MyHandlerMethodParamResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestBodyMapping.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest nativeRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        assert nativeRequest != null;
        String contentType = nativeRequest.getContentType();
        if (contentType == null) {
            throw new IllegalArgumentException("not found body");
        }

        if (MediaType.APPLICATION_JSON_VALUE.equals(contentType)) {
        }

        return null;
    }
}
