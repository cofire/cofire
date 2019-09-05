package com.cofire.common.utils.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author huizi
 * @date 2017/8/28 0028 下午 8:06
 * @since 1.0
 */
public class BeanUtil {
    private static final transient Log logger = LogFactory.getLog(BeanUtil.class);

    @SuppressWarnings("rawtypes")
    public static Object get(Object bean, String property) {
        if (bean == null) {
            return null;
        } else if (bean instanceof Map) {
            return ((Map) bean).get(property);
        } else {
            try {
                String e = "get" + StringUtils.upperCase(StringUtils.substring(property, 0, 1)) + StringUtils.substring(property, 1);
                Method method = bean.getClass().getMethod(e, new Class[0]);
                return method.invoke(bean, new Object[0]);
            } catch (Exception var4) {
                logger.warn(var4);
                return null;
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public static Map groupBeanList(Collection beanList, String property) {
        return groupBeanList(beanList, property, (Object) null);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Map groupBeanList(Collection beanList, String property, Object nullKey) {
        LinkedHashMap result = new LinkedHashMap();
        Iterator var4 = beanList.iterator();
        while (var4.hasNext()) {
            Object bean = var4.next();
            try {
                Object keyvalue = get(bean, property);
                if (keyvalue == null) {
                    keyvalue = nullKey;
                }
                if (keyvalue != null) {
                    Object tmpList = (List) result.get(keyvalue);
                    if (tmpList == null) {
                        tmpList = new ArrayList();
                        result.put(keyvalue, tmpList);
                    }

                    ((List) tmpList).add(bean);
                }
            } catch (Exception var8) {
            }
        }
        return result;
    }

    public static <T> T mapToBean(HashMap<String, String> map, Class<T> class1) {
        T bean = null;
        try {
            bean = class1.newInstance();
            BeanUtils.populate(bean, map);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

}
