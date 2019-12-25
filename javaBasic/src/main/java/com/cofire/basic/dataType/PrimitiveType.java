package com.cofire.basic.dataType;

/**
 * @Description
 * @ClassName PrimitiveType
 * @Author Ly
 * @date 2019.12.22 14:26
 */
public class PrimitiveType {
    public static void main(String[] args) {
        // byte
        /**
         * byte 数据类型是8位、有符号的，以二进制补码表示的整数；
         * 最小值是 -128（-2^7）；
         * 最大值是 127（2^7-1）；
         * 默认值是 0；
         **/
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // short
        /**
         * short 数据类型是 16 位、有符号的以二进制补码表示的整数
         * 最小值是 -32768（-2^15）；
         * 最大值是 32767（2^15 - 1）；
         * Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；
         * 默认值是 0；
         **/
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();

        // int
        /**
         * int 数据类型是32位、有符号的以二进制补码表示的整数；
         * 最小值是 -2,147,483,648（-2^31）；
         * 最大值是 2,147,483,647（2^31 - 1）；
         * 一般地整型变量默认为 int 类型；
         * 默认值是 0 ；
         **/
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        /**
         * long 数据类型是 64 位、有符号的以二进制补码表示的整数；
         * 最小值是 -9,223,372,036,854,775,808（-2^63）；
         * 最大值是 9,223,372,036,854,775,807（2^63 -1）；
         * 这种类型主要使用在需要比较大整数的系统上；
         * 默认值是 0L；
         **/
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // float
        /**
         * float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
         * float 在储存大型浮点数组的时候可节省内存空间；
         * 默认值是 0.0f；
         * 浮点数不能用来表示精确的值，如货币；
         **/
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        /**
         * double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数；
         * 浮点数的默认类型为double类型；
         * double类型同样不能表示精确的值，如货币；
         * 默认值是 0.0d；
         **/
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        /**
         *char类型是一个单一的 16 位 Unicode 字符；
         * 最小值是 \u0000（即为0）；
         * 最大值是 \uffff（即为65,535）；
         * char 数据类型可以储存任何字符；
         **/
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
                + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="
                + (int) Character.MAX_VALUE);

        // boolean
        System.out.println(Boolean.TYPE);
    }
}
