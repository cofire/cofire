package com.cofire.common.utils.validate;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.util.Assert;

/**
 * 
 * @ClassName: ParamValidator
 * @Description:参数校验
 * @author ly
 * @date 2019年10月14日
 *
 * @version V1.0
 */
public class ParamValidator {

    /**
     * 校验参数中是否有为空的属性
     *
     * @param paramObj 参数对象
     * @param checkProperties 需要校验的参数
     * @return true：参数信息完整 false：参数信息不完整
     * @throws IllegalAccessException
     */
    @SuppressWarnings("unlikely-arg-type")
    public static boolean checkParamsHasEmpty(Object paramObj, String... checkProperties) throws IllegalAccessException {
        Assert.notNull(paramObj, "参数对象不能为空");
        Class<?> paramObjClass = paramObj.getClass();
        Field[] fields = paramObjClass.getDeclaredFields();
        List<String> checkPropList = (checkProperties != null) ? Arrays.asList(checkProperties) : null;
        for (Field field : fields) {
            if (checkPropList.contains(field)) {
                // 该方法可以访问被private修饰的字段的value值
                field.setAccessible(true);
                if (Objects.isNull(field.get(paramObjClass))) {
                    return true;
                }
            }
        }
        return false;
    }
}
