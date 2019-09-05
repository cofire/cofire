package com.cofire.common.utils.qrCode;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofire.common.utils.file.FileUtil;
import com.cofire.common.utils.security.Util;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class QrCodeUtil {
    private static Logger logger = LoggerFactory.getLogger(QrCodeUtil.class);

    private final static String FORMAT = "png";
    private final static int WIDTH = 300;
    private final static int HEIGHT = 300;
    private final static HashMap hintMap = new HashMap();

    static {
        hintMap.put(EncodeHintType.CHARACTER_SET, "utf-8");// 字符集
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);// 纠错级别
        hintMap.put(EncodeHintType.MARGIN, 2);// 空白
    }

    public static String createQrCode(String basePath, String content) {
        if (StringUtils.isEmpty(basePath)) {
            basePath = "";
        }
        if (StringUtils.isEmpty(content)) {
            content = "";
            return null;
        }
        String uuid = Util.getUUID();
        String relateUrl = FileUtil.getRelatPath() + uuid + "." + FORMAT;
        String destUrl = basePath + relateUrl;
        File dest = new File(destUrl);
        try {
            // 判断文件父目录是否存在
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            Path filePath = dest.toPath();
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hintMap);
            MatrixToImageWriter.writeToPath(bitMatrix, FORMAT, filePath);
        } catch (Exception e) {
            logger.error("生成二维码失败：" + e.getMessage());
            return null;
        }
        return relateUrl;
    }

    public static void main(String[] args) {
        logger.info("二维码路径为：" + createQrCode("D:/data/qrCode", "www.baidu.com"));

    }
}
