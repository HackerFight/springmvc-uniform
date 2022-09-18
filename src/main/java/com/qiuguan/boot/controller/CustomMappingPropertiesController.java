package com.qiuguan.boot.controller;

import com.qiuguan.boot.bean.EventBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiuguan
 * @date 2022/09/18 23:06:57  星期日
 */
@Slf4j
@RestController
public class CustomMappingPropertiesController {

    /**
     * 表单提交
     * POST: http://localhost:8080/cvc
     * Content type 'application/x-www-form-urlencoded
     *
     *表单提交就不用使用 {@link org.springframework.web.bind.annotation.RequestBody} 了
     * 因为 {@link org.springframework.web.bind.annotation.RequestBody} 是JSON 提交
     */
    @PostMapping("/register")
    public EventBean register(EventBean eventBean) {
        log.info("eventBean is {}", eventBean);
        return eventBean;
    }
}
