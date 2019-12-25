package com.cofire.basic.dataType;

/**
 * @author ly
 * @Description
 * @date 2019/12/22
 **/
public class StringTest {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("测试");
        stringBuffer.append("一下");
        System.out.println(stringBuffer);

        StringBuilder stringBuilder = new StringBuilder("测试");
        stringBuilder.append("一下");
        System.out.println(stringBuilder);
    }
}
