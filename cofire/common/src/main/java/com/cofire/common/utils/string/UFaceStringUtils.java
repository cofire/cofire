package com.cofire.common.utils.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;


/**
 * 字符串工具类
 * @author Nicholas Shen
 * @version 1.0
 * @since 1.0
 */
public class UFaceStringUtils {
	
	private UFaceStringUtils() {}
	
	/**
	 * 将参数中的所有字符串拼接为整个字符串返回
	 * @param fragments 需要拼接的字符串
	 * @return String 拼接完成的字符串
	 */
	public static String join(String... fragments) {
		StringBuilder strBuilder = new StringBuilder();
		for(String fragment : fragments) {
			strBuilder.append(fragment);
		}
		return strBuilder.toString();
	}
	
	/**
	 * 将对象转换为字符串
	 * @param obj
	 * @return
	 */
	public static String parseString(Object obj) {
		String result = (obj == null ? null : String.valueOf(obj));
		if(result == null) {
			return null;
		} else if(StringUtils.isBlank(result)) {
			return null;
		} else {
			return result.trim();
		}
	}
	
	/**
	 * 检查字符串是否为空或者null.<br/>
	 * <pre>
	 * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return StringUtils.isBlank(str);
	}
	
	/**
	 * 检查字符串是否不为空或者null.<br/>
	 * <pre>
	 * StringUtils.isBlank(null)      = false
     * StringUtils.isBlank("")        = false
     * StringUtils.isBlank(" ")       = false
     * StringUtils.isBlank("bob")     = true
     * StringUtils.isBlank("  bob  ") = true
     * </pre>
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !UFaceStringUtils.isBlank(str);
	}
	
	/**
	 * 将字符串转换为十六进制的比特数组
	 * @param strhex
	 * @return
	 */
	public static byte[] hex2byte(String strhex) {
		if (strhex == null) {
			return null;
		}
		int l = strhex.length();
		if (l % 2 == 1) {
			return null;
		}
		byte[] b = new byte[l / 2];
		for (int i = 0; i != l / 2; i++) {
			b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
		}
		return b;
	}
	
	/**
	 * 将十六进制的比特数组转换为字符串
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}
	
	/**
	 * 将字符重复指定次数
	 * @param times 重复次数
	 * @param replacement
	 * @return
	 */
	public static String repeat(int times,String replacement) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < times; i++) {
			sb.append(replacement);
		}
		return sb.toString();
	}
	
	/**
	 * 过滤字符串中的回车换行和制表符
	 * @param str
	 * @return
	 */
	public static String filterBlankCharacter(String str) {
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(str);  
		return m.replaceAll("");
	}
}
