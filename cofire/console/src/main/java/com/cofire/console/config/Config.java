package com.cofire.console.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * @ClassName: Config
 * @Description:加载xml文件
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
@Configuration
@ImportResource(locations = { "classpath:application-bean.xml" })
public class Config {

}
