package com.qiuguan.boot.config;

import com.qiuguan.boot.handler.UniformResponseHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiuguan
 * @date 2022/09/09 09:25:14  星期五
 */
@Configuration
public class MvcConfig {

    @Bean
    public UniformResponseHandler uniformResponseHandler(RequestMappingHandlerAdapter adapter){
        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        assert returnValueHandlers != null;
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(returnValueHandlers);
        for (HandlerMethodReturnValueHandler returnValueHandler : returnValueHandlers) {
            //处理@ResponseBody注解的处理器
            if (returnValueHandler instanceof RequestResponseBodyMethodProcessor) {
                UniformResponseHandler h = new UniformResponseHandler(returnValueHandler);
                int indexOf = returnValueHandlers.indexOf(returnValueHandler);
                handlers.set(indexOf, h);
                adapter.setReturnValueHandlers(handlers);
                return h;
            }
        }

        return null;
    }

}
