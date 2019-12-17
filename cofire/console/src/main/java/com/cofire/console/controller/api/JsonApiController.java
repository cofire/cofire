package com.cofire.console.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.result.Result;
import com.cofire.common.utils.context.HttpContext;
import com.cofire.console.config.log.BussinessLog;

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

    @BussinessLog("测试")
    @RequestMapping("/test")
    public Result test(HttpRequest request, @RequestBody Person person) {
        Result result = new Result();
        result.setData(person);
        return result;
    }

    @RequestMapping("/test2")
    String request(HttpServletRequest request, HttpServletResponse response) {
        String param = null;
        // try {
        // BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
        // StringBuilder responseStrBuilder = new StringBuilder();
        // String inputStr;
        // while ((inputStr = streamReader.readLine()) != null)
        // responseStrBuilder.append(inputStr);
        //
        // JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
        // param = jsonObject.toJSONString();
        // System.out.println(param);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        HttpContext.getRequestParameters();
        return param;
    }

}

class Person {
    public String name;
    public List<Phone> phone;
}

class Phone {
    public String num;
}