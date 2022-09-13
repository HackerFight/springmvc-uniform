package com.qiuguan.boot.controller;

import com.qiuguan.boot.bean.Person;
import com.qiuguan.boot.enums.ApiCodeEnum;
import com.qiuguan.boot.enums.ApiCommonCode;
import com.qiuguan.boot.result.ApiResult;
import com.qiuguan.boot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qiuguan
 * @date 2022/09/08 18:52:15  星期四
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public ApiResult<?> hello(){
        return ApiResult.ok("666");
    }

    @GetMapping("/test/{id}")
    public String test(@PathVariable Integer id){
        return "7777__" + id;
    }

    @GetMapping("/test2")
    public String testEx(){
        return this.helloService.helloService();
    }

    @GetMapping("/param")
    public ApiResult<?> testParamEx(@RequestParam(name = "id") Integer id){
        if (null == id) {
            return ApiResult.fail(ApiCodeEnum.PARAM_ILLEGAL);
        }
        return ApiResult.ok(id);
    }

    /**
     * GET: http://localhost:8080/bean?id=123&name=fuyuanhui&gender=1&phone=18368116334
     * 参数解析器是：{@link org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor}
     *
     * POST: 必须搭配 {@link RequestBody} 注解
     * 如果使用了{@link RequestBody} 注解，则使用 {@link org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor}
     * 如果没有使用{@link RequestBody} 注解，则和GET 使用的处理器一样，但是无法完成属性映射
     */
    @GetMapping("/bean")
    //@PostMapping("/bean")
    public ApiResult<?> testBean(Person person){
        return ApiResult.ok(person);
    }
}
