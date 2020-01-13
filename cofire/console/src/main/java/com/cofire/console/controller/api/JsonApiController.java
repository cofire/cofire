package com.cofire.console.controller.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cofire.common.utils.context.HttpHelper;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.result.Result;
import com.cofire.common.utils.context.HttpContext;
import com.cofire.console.config.log.BussinessLog;

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
}

class Person {
    public String name;
    public List<Phone> phone;
}

class Phone {
    public String num;
}
