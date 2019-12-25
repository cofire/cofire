package com.cofire.common.utils.validate;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ly
 * @version V1.0
 * @ClassName: commonValidator
 * @Description:公共校验
 * @date 2019年12月4日
 */
public class CommonValidator {
    private static final Pattern CHINESS_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5]");

    /**
     * 检查字段是否都是数字
     *
     * @param value输入的数值
     * @return true-都是数字 false-存在非数字
     */
    public static boolean isNumber(String value) {
        try {
            new BigDecimal(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 检查字段是否由大写和数字组成
     *
     * @param value 检查的字段
     * @return true-是由大写字母和数字组成的 false-不是由字母数字组成的
     */
    public static boolean isUpaperCase(String value) {
        int isLD = 0;
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (Character.isUpperCase(ch)) {
                isLD++;
            } else if (Character.isDigit(ch)) {
                isLD++;
            } else {
                isLD = isLD + 0;
            }
        }
        if (value.length() == isLD) {
            return true;
        }
        return false;
    }

    /**
     * 检查字段是否由大写组成
     *
     * @param value 检查的字段
     * @return true-是由大写字母组成的 false-不是由字母数字组成的
     */
    public static boolean isUpaper(String value) {
        int isLD = 0;
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (Character.isUpperCase(ch)) {
                isLD++;
            } else {
                isLD = isLD + 0;
            }
        }
        if (value.length() == isLD) {
            return true;
        }
        return false;
    }

    /**
     * @param str
     * @return boolean 返回类型；true-包含汉字 false-不包含汉字
     * @Title: isContainChinese
     * @Description:判断传入的字符串是否包含汉字 如果包含则返回true；反之返回false
     * @Author: myl
     * @Date: 2019年5月30日
     */
    public static boolean isContainChinese(String str) {
        Matcher m = CHINESS_PATTERN.matcher(str);
        return m.find();
    }

}
