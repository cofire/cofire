package com.cofire.console.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebSecurityConfig extends WebMvcConfigurationSupport {
    /**
     * 配置静态访问资源
     * 
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/console/static/**").addResourceLocations("classpath:/templates/console/static/");
        registry.addResourceHandler("/ipad/static/**").addResourceLocations("classpath:/templates/ipad/static/");
        registry.addResourceHandler("/mobile/static/**").addResourceLocations("classpath:/templates/mobile/static/");
        super.addResourceHandlers(registry);
    }

}
