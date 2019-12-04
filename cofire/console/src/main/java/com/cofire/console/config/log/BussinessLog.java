package com.cofire.console.config.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: BussinessLog
 * @Description:定义日志注解类
 * @author ly
 * @date 2019年12月4日
 *
 * @version V1.0
 */
@Target(ElementType.METHOD) // 注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) // 注解在哪个阶段执行
@Documented // 生成文档
public @interface BussinessLog {
    String value() default "";
}
