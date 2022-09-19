package com.qiuguan.boot.controller;

import com.qiuguan.boot.bean.Teacher;
import com.qiuguan.boot.convert.Test;
import com.qiuguan.boot.resolver.RequestBodyMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiuguan
 * @date 2022/09/18 20:17:54  星期日
 */
@Slf4j
@RestController
public class CustomParamParseController {


    @PostMapping("/parse")
    public Teacher parse(@RequestBodyMapping Teacher teacher) {
        log.info("teacher is {}", teacher);
        return teacher;
    }
}
