package com.springBoot.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.utils.image.ValidateCodeUtil;

@RestController
@RequestMapping("/base")
public class BaseController {

    @Value("${test}")
    private String test;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/validateCode")
    public void validateCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 设置浏览器不缓存本页
            response.addHeader("Pragma", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            response.addHeader("Expires", "0");
            // 生成验证码，写入用户session
            String verifyCode = ValidateCodeUtil.createRandomNO(6);
            request.getSession().setAttribute("imageVerify", verifyCode);
            // 输出验证码给客户端
            response.setContentType("image/jpeg");
            BufferedImage bim = ValidateCodeUtil.creatImage(verifyCode);
            ImageIO.write(bim, "JPEG", response.getOutputStream());

        } catch (Exception e) {
        }
    }

    @RequestMapping("/property")
    public String property() {
        return test;
    }
}
