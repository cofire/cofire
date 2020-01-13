package com.cofire.common.utils.validate;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import com.cofire.common.result.ParamItem;
import com.cofire.common.utils.string.StringUtil;

/**
 * @author ly
 * @version V1.0
 * @ClassName: ParamValidator
 * @Description:参数校验
 * @date 2019年10月14日
 */
public class ParamValidator {

    /**
     * @param @param  values
     * @param @return false：参数信息完整 true：参数信息不完整
     * @return boolean 返回类型
     * @Title: checkParamsHasEmpty
     * @author ly
     * @Description:检测参数是否为空
     */
    public static boolean checkParamsHasEmpty(String... values) {
        for (int i = 0; i < values.length; i++) {
            if (StringUtils.isEmpty(values[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验参数中是否有为空的属性
     *
     * @param paramObj        参数对象
     * @param checkProperties 需要校验的参数
     * @return false：参数信息完整 true：参数信息不完整
     * @throws IllegalAccessException
     */
    @SuppressWarnings("unlikely-arg-type")
    public static boolean checkParamsHasEmpty(Object paramObj, String... checkProperties) throws IllegalAccessException {
        Assert.notNull(paramObj, "参数对象不能为空");
        Class<?> paramObjClass = paramObj.getClass();
        Field[] fields = paramObjClass.getDeclaredFields();
        List<String> checkPropList = (checkProperties != null) ? Arrays.asList(checkProperties) : null;
        if (CollectionUtils.isEmpty(checkPropList)) {
            return false;
        }
        for (Field field : fields) {
            if (checkPropList.contains(field.getName())) {
                // 该方法可以访问被private修饰的字段的value值
                field.setAccessible(true);
                if (Objects.isNull(field.get(paramObjClass))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkHasPros(Class<?> clazz, String... checkProperties) {
        Assert.notNull(clazz, "参数对象不能为空");
        Field[] fields = clazz.getDeclaredFields();
        List<String> checkPropList = (checkProperties != null) ? Arrays.asList(checkProperties) : null;
        boolean isChecked = false;
        for (String prop : checkPropList) {
            for (Field field : fields) {
                if (field.getName().equalsIgnoreCase(StringUtil.lineToHump(prop)) || field.getName().equalsIgnoreCase(StringUtil.humpToLine(prop))) {

                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        checkHasPros(ParamItem.class, "length");
    }
}
