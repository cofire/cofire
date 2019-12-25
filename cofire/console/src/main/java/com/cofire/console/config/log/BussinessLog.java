package com.cofire.console.config.log;

import com.cofire.common.constant.Constants;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author ly
 * @version V1.0
 * @ClassName: BussinessLog
 * @Description:定义日志注解类
 * @date 2019年12月4日
 */
@Target(ElementType.METHOD) // 注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) // 注解在哪个阶段执行
@Documented // 生成文档
public @interface BussinessLog {
    /**
     * 记录接口名称
     **/
    String value() default "";

    /**
     * 记录操作类型
     **/
    String operation() default Constants.OPERATION_QUERY;

    /**
     * 是否记录返回值
     **/
    boolean flag() default true;

    Class<? extends Annotation> annotation() default Annotation.class;
}
