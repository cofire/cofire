package com.cofire.basic.crawel.core;

import com.cofire.basic.crawel.template.TemplateMethod;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ly
 * @Description
 * @date 2020/02/12
 **/
public class DefaultParser {

    //    获取元素的值
    public static <T> String getElementValue(T element, TemplateMethod templateMethod) {
        try {
            if (null == element || null == templateMethod || StringUtils.isEmpty(templateMethod.getName())) {
                return "";
            }
            Method method = getElemetMethod(element, templateMethod);
            //        代表最终方法 返回 string
            if (null == templateMethod.getTemplateMethod() || null == templateMethod.getTemplateMethod().getName()) {
                return (String) elementMethodInvoke(method, templateMethod, element);
            } else {
                return getElementValue(elementMethodInvoke(method, templateMethod, element), templateMethod.getTemplateMethod());
            }
        } catch (
                NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static <T> Method getElemetMethod(T element, TemplateMethod templateMethod) throws NoSuchMethodException {
        if (null == element || null == templateMethod || StringUtils.isEmpty(templateMethod.getName())) {
            return null;
        }
        if (StringUtils.isAllEmpty(templateMethod.getParam())) {
            return element.getClass().getDeclaredMethod(templateMethod.getName());
        } else {
            return element.getClass().getDeclaredMethod(templateMethod.getName(), String.class);
        }
    }

    public static <T> Object elementMethodInvoke(Method method, TemplateMethod templateMethod, T element) throws InvocationTargetException, IllegalAccessException {
        if (StringUtils.isAllEmpty(templateMethod.getParam())) {
            return method.invoke(element);
        } else {
            return method.invoke(element, templateMethod.getParam());
        }
    }
}
