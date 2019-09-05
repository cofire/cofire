package com.cofire.console.moduler.base.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  有关业务的公共校验
 * @author Mike
 * @version 2019.06.02
 */
public class BaseValidator {
	/**
	 * 检验字段长度是否大于length
	 * @param param
	 * @param length
	 * @return
	 */
	public static Boolean checkParameterLengthMore(String param, Integer length) {
		if((null == param || param.length() == 0) || (null != param && param.length() > length)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 检验字段长度是否小于length
	 * @param param
	 * @param length
	 * @return
	 */
	public static Boolean checkParameterLengthLess(String param, Integer length) {
		if((null == param || param.length() == 0) || (null != param && param.length() < length)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 检查对象是否不为空
	 * @param object
	 * @return
	 */
	public static Boolean checkObjectIsNotNull(Object object) {
		if(null != object) {
			return true;
		} else {
			return false;
		}
	}
	

	// 判断一个字符串是否含有数字
	public static boolean HasDigit(String content) {
	    boolean flag = false;
	    Pattern p = Pattern.compile(".*\\d+.*");
	    Matcher m = p.matcher(content);
	    if (m.matches()) {
	        flag = true;
	    }
	    return flag;
	}
}
