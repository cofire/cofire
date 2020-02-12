package com.cofire.basic.crawel.core;

import com.cofire.basic.crawel.template.TemplateMethod;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ly
 * @Description
 * @date 2020/02/12
 **/
public class DefaultParser {

    //    获取元素的值
    public static String getElementValue(Element element, TemplateMethod templateMethod) {
        try {
            if (null == element || null == templateMethod || StringUtils.isEmpty(templateMethod.getName())) {
                return "";
            }
            Method method = element.getClass().getDeclaredMethod(templateMethod.getName(), String.class);
            //        代表最终方法 返回 string
            if (null == templateMethod.getTemplateMethod() || null == templateMethod.getTemplateMethod().getName()) {
                return (String) method.invoke(element, templateMethod.getParam());
            } else {
                if (method.getReturnType() == Element.class) {
                    return getElementValue((Element) method.invoke(element, templateMethod.getParam()), templateMethod.getTemplateMethod());
                } else {
                    return getElementsValue((Elements) method.invoke(element, templateMethod.getParam()),
                            templateMethod.getTemplateMethod());
                }
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

    //    获取元素的值
    public static String getElementsValue(Elements elements, TemplateMethod templateMethod) {
        try {
            if (null == elements || null == templateMethod || StringUtils.isEmpty(templateMethod.getName())) {
                return "";
            }
            Method method = elements.getClass().getDeclaredMethod(templateMethod.getName(), String.class);
            //        代表最终方法 返回 string
            if (null == templateMethod.getTemplateMethod() || null == templateMethod.getTemplateMethod().getName()) {
                return (String) method.invoke(elements, templateMethod.getParam());
            } else {
                if (method.getReturnType() == Element.class) {
                    return getElementValue((Element) method.invoke(elements, templateMethod.getParam()), templateMethod.getTemplateMethod());
                } else {
                    return getElementsValue((Elements) method.invoke(elements, templateMethod.getParam()),
                            templateMethod.getTemplateMethod());
                }
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

    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("http://www.yiibai.com").get();
            Method select = document.getClass().getSuperclass().getDeclaredMethod("select", String.class);
            Elements xoxoList = (Elements) select.invoke(document, ".xoxo li");
            TemplateMethod tem = new TemplateMethod("attr", "href");
            TemplateMethod templateMethod = new TemplateMethod("getElementsByTag", "a", tem);
            for (Element xoxo : xoxoList) {
//                System.out.println(xoxo.getElementsByTag("a").attr("href"));
//                System.out.println(xoxo.getElementsByTag("a").text());
//                System.out.println(xoxo.ownText());
                System.out.println(getElementValue(xoxo, templateMethod));
            }
        } catch (
                IOException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
