package com.cofire.console.moduler.system.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.console.common.impl.SystemService;
import com.cofire.console.config.log.BussinessLog;

@RestController
@RequestMapping("/console")
public class BaseController {
    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 
     * @Title: getImage
     * @author ly
     * @Description:
     * @param @param path 相对路径 例如 \2019\5\24\3.png
     * @param @return
     * @param @throws FileNotFoundException
     * @param @throws IOException 参数
     * @return byte[] 返回类型
     */
    @BussinessLog("查看照片")
    @SuppressWarnings("resource")
    @RequestMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(String path) throws FileNotFoundException, IOException {
        logger.info("图片路径为：" + path);
        String imgPath = SystemService.getParamVal("0001", "1");
        String img404 = SystemService.getParamVal("0001", "3");
        if (StringUtils.isEmpty(path)) {
            imgPath = img404;
        } else {
            imgPath = imgPath + path;
        }
        File file = new File(imgPath);
        if (!file.exists()) {
            file = new File(img404);
        }
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
}
