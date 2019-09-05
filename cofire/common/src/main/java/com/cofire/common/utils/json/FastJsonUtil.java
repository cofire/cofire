package com.cofire.common.utils.json;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 引入alibaba FastJson.<br>
 * 详情请移步 http://code.alibabatech.com/wiki/display/FastJSON/Overview 不要从工具类继承
 * 不要试图实例化工具类
 * 
 * @author 
 * @version V1.0
 * @Time 
 * @Modify remarks:
 */
public final class FastJsonUtil {

	/**
	 * 对象转Json字符串 
	 * @author 
	 * @Time 
	 * @param object
	 * @param features
	 * @return
	 */
	public static final String toPrettyJSONString(Object object) {
		return JSON.toJSONString(object, SerializerFeature.PrettyFormat);
	}

	/**
	 * 对象转Json字符串
	 * @author 
	 * @Time 
	 * @param object
	 * @param features
	 * @return
	 */
	public static final String toJSONString(Object object,
			SerializerFeature... features) {
		return JSON.toJSONString(object, features);
	}

	/**
	 * 对象转Json字符串
	 * 
	 * @author 
	 * @Time 
	 * @param object
	 * @param dateFormat
	 * @param features
	 * @return
	 */
	public static final String toJSONStringWithDateFormat(Object object,
			String dateFormat, SerializerFeature... features) {
		return JSON.toJSONStringWithDateFormat(object, dateFormat, features);
	}

	/**
	 * Json 字符串 转对象
	 * 
	 * @author 
	 * @Time 
	 * @param text
	 * @param clazz
	 * @param features
	 * @return
	 */
	public static final <T> T parseObject(String text, Class<T> clazz,
			Feature... features) {
		return JSON.parseObject(text, clazz, features);
	}

	/**
	 * Json 字符串 转对象
	 * 
	 * @author 
	 * @Time 
	 * @param text
	 * @param clazz
	 * @param features
	 * @return
	 */
	public static final <T> List<T> parseList(String text, Class<T> clazz) {
		return JSON.parseArray(text, clazz);
	}

	private FastJsonUtil() {
	}
	
	public static final String toString(Object obj){
		return JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
	}
}
