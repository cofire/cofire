package com.cofire.console.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasePageController {

    @RequestMapping("/console")
    public String console() {
        return "console/index";
    }

    @RequestMapping("/ipad")
    public String ipad() {
        return "ipad/index";
    }

    @RequestMapping("/mobile")
    public String mobile() {
        return "mobile/index";
    }
}
