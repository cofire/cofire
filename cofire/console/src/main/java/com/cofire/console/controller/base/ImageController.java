package com.cofire.console.controller.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.result.Result;
import com.cofire.common.result.SystemUtil;
import com.cofire.common.utils.file.FileUtil;
import com.cofire.common.utils.file.ImageMarkUtil;
import com.cofire.common.utils.file.ImageZoomUtil;
import com.cofire.common.utils.security.Util;
import com.cofire.console.config.log.BussinessLog;

/**
 * @author ly
 * @version V1.0
 * @ClassName: ImageUploadController
 * @Description:图片上传
 * @date 2019年5月24日
 */
@RestController
@RequestMapping("/image")
public class ImageController {

    private final static Logger logger = LoggerFactory.getLogger(ImageController.class);

    /**
     * @param @return 参数
     * @return Result 返回类型
     * @Title: upload
     * @author ly
     * @Description:图片上传接口
     */
    @RequestMapping("/upload")
    public Result imgUpload(HttpServletRequest request, @RequestParam(value = "file") MultipartFile file) {
        logger.info("接收到图片正在上传");
        Result result = new Result();
        if (file == null || file.isEmpty()) {
            logger.info("图片不存在");
            result.setSuccess(false);
            return result;
        }
        String oriFileName = file.getOriginalFilename();
        String suffix = FileUtil.getSuffix(oriFileName);
        if (null == suffix) {
            logger.info("图片格式不正确");
            result.setSuccess(false, CodeEnum.E_400);
            return result;
        }
        String path = SystemUtil.getParamVal("0001", "1");
        if (StringUtils.isEmpty(path)) {
            logger.info("图片存储路径系统参数丢失");
            result.setSuccess(false, CodeEnum.E_500);
            return result;
        }
        String markText = SystemUtil.getParamVal("0001", "2");
        if (StringUtils.isEmpty(markText)) {
            markText = "默克审核专用，禁止泄露或转作它用";
        }
        String uuid = Util.getUUID();
        String relateUrl = FileUtil.getRelatPath() + uuid + "." + suffix;
        String picUrl = path + relateUrl;
        File dest = new File(picUrl);
        try {
            // 判断文件父目录是否存在
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            // 保存文件
            file.transferTo(dest);
        } catch (IOException e) {
            logger.error("IO异常：" + e.getMessage());
            result.setSuccess(false);
            return result;
        }
        try {
            logger.info("正在图片处理");
            ImageMarkUtil.ImageByText(markText, picUrl, picUrl, 45, suffix);
            ImageZoomUtil.zoomImage(picUrl, picUrl, 200);
            logger.info("图片处理成功");
        } catch (Exception e) {
            logger.error("图片处理失败：" + e.getMessage());
        }
        result.setSuccess(true, CodeEnum.E_200);
        result.setData(relateUrl);
        return result;
    }

    /**
     * @param @param  path
     * @param @return
     * @param @throws FileNotFoundException
     * @param @throws IOException 参数
     * @return byte[] 返回类型
     * @Title: getImage
     * @author ly
     * @Description:图片显示
     */
    @BussinessLog("查看照片")
    @SuppressWarnings("resource")
    @RequestMapping(value = "/", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(String path) throws FileNotFoundException, IOException {
        logger.info("图片路径为：" + path);
        String imgPath = SystemUtil.getParamVal("0001", "1");
        String img404 = SystemUtil.getParamVal("0001", "3");
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
        inputStream.close();
        return bytes;
    }
}
