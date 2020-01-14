package com.cofire.console.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ly
 * @version V1.0
 * @ClassName: Config
 * @Description:加载xml文件
 * @date 2019年12月4日
 */
@Configuration
@ImportResource(locations = {"classpath:application-bean.xml"})
public class Config {

}
