package com.cofire.basic.dataType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jessin on 17-2-26.
 */
public class PatternDemo {
    public static void main(String[] args) {
        // 预先编译
        String str = "\\$(\\w+)\\((\\d+)\\)";
        Pattern pattern = Pattern.compile(str);
        String text = "hello $natureOrder(123) if you like this ,please use $indexOrder(99);";
        // 生成编译类
        Matcher matcher = pattern.matcher(text);
        // 得到所有的匹配结果
        while (matcher.find()) {
            // 整个匹配的字符串：$function(argument)
            System.out.println(matcher.group());
            // 第一个()的内容：函数名function
            System.out.println(matcher.group(1));
            // 第二个括号的内容：数字argument
            System.out.println(matcher.group(2));
            // 将所有的匹配项删除，必须赋值才能起作用
            text = text.replace(matcher.group(), "field");
            // $natureOrder(123)
            // natureOrder
            // 123
            // $indexOrder(99)
            // indexOrder
            // 99
        }
        System.out.println(text);
        // hello field if you like this ,please use field;
    }
}
