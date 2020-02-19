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

    /**
     * 根据字段类型不同返回不一样的内容
     * 字段类型为文件时，将返回文件下载后的相对路径
     * 其他类型返回处理后的文本
     **/
    public static <T> String getElementValue(T element, String fieldType, TemplateMethod templateMethod) {
        if (SpiderConstants.FieldTypeEnum.FILE.getCode().equalsIgnoreCase(fieldType)) {

            String fileUrl = getElementValue(element, templateMethod);
            return FileDownLoad.downLoad(fileUrl, "");
        }
        return getElementValue(element, templateMethod);
    }

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
