package com.cofire.common.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ValidateCode {

    /*
     * 随机,含字母
     * 图片验证码使用
     */
    public static String createRandom(int len) {
        String random = "";
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
                "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (int i = 0; i < len; i++) {
            random = random + " " + values[(int) (Math.random() * 72)];
        }
        return random;
    }

    /*
     * 随机,不含字母
     * 手机验证码使用
     */
    public static String createRandomNO(int len) {
        String random = "";
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < len; i++) {
            random = random + "" + values[(int) (Math.random() * 10)];
        }
        return random;
    }

    public BufferedImage creatImage(String img) {

        /* 在内存中创建图象 */
        int width = 100, height = 22;
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        /* 获取图形上下文 */
        Graphics g = image.getGraphics();

        /* 生成随机类 */
        Random random = new Random();

        /* 设定背景色 */
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        /* 设定字体 */
        g.setFont(new Font("Times New Roman", Font.BOLD, 22));

        /* 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到 */
        g.setColor(Color.black);
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            // int xl = random.nextInt(1);
            // int yl = random.nextInt(1);

            g.drawLine(x, y, x, y);
        }

        /* 取随机产生的认证码(4位字母数字) */
        g.setColor(Color.BLUE);
        g.drawString(img, 10, 17);
        /* 图象生效 */
        g.dispose();
        return image;
    }

    public static void main(String[] args) {
        System.out.println(createRandom(6));
        System.out.println(createRandomNO(6));
    }

}
