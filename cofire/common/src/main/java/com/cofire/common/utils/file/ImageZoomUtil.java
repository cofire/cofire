package com.cofire.common.utils.file;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageZoomUtil {
    /*
     * 图片缩放,w，h为缩放的目标宽度和高度 src为源文件目录，dest为缩放后保存目录
     */
    public static void zoomImage(String src, String dest, int w, int h) throws Exception {

        Double wr = 0.0, hr = 0.0, rate = 0.0;
        File srcFile = new File(src);
        File destFile = new File(dest);

        BufferedImage bufImg = ImageIO.read(srcFile); // 读取图片
        Image Itemp = bufImg.getScaledInstance(w, h, bufImg.SCALE_SMOOTH);// 设置缩放目标图片模板
        wr = w * 1.0 / bufImg.getWidth(); // 获取缩放比例
        hr = h * 1.0 / bufImg.getHeight();
        if (wr.compareTo(hr) > 0) {
            rate = hr;
        } else {
            rate = wr;
        }
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(rate, rate), null);
        Itemp = ato.filter(bufImg, null);
        try {
            ImageIO.write((BufferedImage) Itemp, dest.substring(dest.lastIndexOf(".") + 1), destFile); // 写入缩减后的图片
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * 图片按比率缩放 size为文件大小
     */
    public static void zoomImage(String src, String dest, Integer size) throws Exception {
        File srcFile = new File(src);
        File destFile = new File(dest);

        long fileSize = srcFile.length();
        if (fileSize < size * 1024) {// 文件大于size k时，才进行缩放,注意：size以K为单位
            return;
        }
        Double rate = Math.sqrt((size * 1024.0) / fileSize); // 获取长宽缩放比例

        BufferedImage bufImg = ImageIO.read(srcFile);
        Image Itemp = bufImg.getScaledInstance(bufImg.getWidth(), bufImg.getHeight(), bufImg.SCALE_SMOOTH);

        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(rate, rate), null);
        Itemp = ato.filter(bufImg, null);
        try {
            ImageIO.write((BufferedImage) Itemp, dest.substring(dest.lastIndexOf(".") + 1), destFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        zoomImage("D:/data/upload/2019/5/24/5f8c7807ea2b43abb0eabc19dee48a20.png", "D:/data/upload/2019/5/24/1.png", 200);
        zoomImage("D:/data/upload/2019/5/24/5f8c7807ea2b43abb0eabc19dee48a20.png", "D:/data/upload/2019/5/24/2.png", 200, 200);
    }
}
