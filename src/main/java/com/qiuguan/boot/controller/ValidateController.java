package com.qiuguan.boot.controller;

import com.qiuguan.boot.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;

/**
 * @author qiuguan
 * 类上的 {@link Validated} 注解是为了test3方法
 */
@Validated
@Slf4j
@RestController
public class ValidateController extends BaseController {

    /**
     * POST http://localhost:8080/valid/test1
     * Content-Type: application/json
     *
     * 接受前端发送的json数据
     *
     * 用 {@link Validated} 和 {@link Valid} 哪个都可以
     */
    @PostMapping("/valid/test1")
    public Student test1(@Validated @RequestBody Student student){
        log.info("student = {}", student);
        return student;
    }

    /**
     * 表单
     * POST http://localhost:8080/valid/test2
     * Content-Type: application/x-www-form-urlencoded
     * studentNo=1122&name=zxy&age=23
     *
     * 用 {@link Validated} 和 {@link Valid} 哪个都可以
     */
    @PostMapping(value = "/valid/test2")
    public Student test2(@Valid Student student){
        log.info("student is {}", student);
        return student;
    }


    /**
     * POST http://localhost:8080/valid/test3
     * Content-Type: application/x-www-form-urlencoded
     * email=11111122222
     *
     * 单个参数校验
     * TODO: 注意：这种单个参数校验的，必须要在Controller类上添加 @Validate 注解(方法上也不行哦）
     */
    @PostMapping(value = "/valid/test3")
    public String test3(@Email String email){
        log.info("email is {}", email);
        return "email valid success";
    }
}
