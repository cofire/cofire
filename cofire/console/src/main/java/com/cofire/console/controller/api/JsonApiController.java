package com.cofire.console.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.result.Result;

/**
 * 
 * @ClassName: JsonApiController
 * @Description:测试接收json格式参数
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
@RestController
@RequestMapping("/console/api")
public class JsonApiController {

    @RequestMapping("/test")
    public Result test(@RequestBody Person person) {
        Result result = new Result();
        result.setData(person);
        return result;
    }

    @RequestMapping("/test2")
    public Result test(@RequestBody Object person) {
        Result result = new Result();
        result.setData(person);
        return result;
    }
}

class Person {
    public String name;
    public List<Phone> phone;
}

class Phone {
    public String num;
}