package com.cofire.console.controller.api;

import com.cofire.common.result.Result;
import com.cofire.console.config.log.BussinessLog;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author ly
 * @version V1.0
 * @ClassName: JsonApiController
 * @Description:测试接收json格式参数
 * @date 2019年12月4日
 */
@RestController
@RequestMapping("/console/api")
public class JsonApiController {

    @BussinessLog("测试")
    @RequestMapping("/test")
    public Result test(@RequestBody Person person) throws IOException {
        Result result = new Result();
        result.setData(person);
        return result;
    }

    @BussinessLog("测试2")
    @RequestMapping("/test2")
    public Result test2(@RequestBody @RequestParam(value = "list[]") List<Person> list) throws IOException {
        Result result = new Result();
        result.setData(list);
        return result;
    }

    @BussinessLog("测试3")
    @RequestMapping("/test3")
    public Result test3(@RequestBody @RequestParam(value = "id") List<String> id) throws IOException {
        Result result = new Result();
        result.setData(id);
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
