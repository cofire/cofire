package com.cofire.console.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ly
 * @version V1.0
 * @ClassName: SystemConfig
 * @Description:管理配置文件中的参数
 * @date 2019年12月4日
 */
@Component
public class SystemConfig {
    /**
     * 数据库类型
     */
    @Value("${spring.datasource.databaseId}")
    private String databaseId;

    public String getDatabaseId() {
        return databaseId;
    }

}
