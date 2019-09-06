package com.cofire.console.moduler.base.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cofire.common.result.Result;
import com.cofire.common.result.SystemUtil;
import com.cofire.common.utils.constant.CodeEnum;
import com.cofire.common.utils.file.FileUtil;
import com.cofire.common.utils.file.ImageMarkUtil;
import com.cofire.common.utils.file.ImageZoomUtil;
import com.cofire.common.utils.security.Util;

/**
 * 
 * @ClassName: ImageUploadController
 * @Description:图片上传
 * @author ly
 * @date 2019年5月24日
 *
 * @version V1.0
 */
@RestController
@RequestMapping("/console")
public class UploadController {

    private final static Logger logger = LoggerFactory.getLogger(UploadController.class);

    /**
     * 
     * @Title: upload
     * @author ly
     * @Description:图片上传接口
     * @param @return 参数
     * @return Result 返回类型
     */
    @RequestMapping("/imgUplode")
    public Result imgUpload(HttpServletRequest request, @RequestParam(value = "file") MultipartFile file) {
        logger.info("接收到图片正在上传");
        Result result = new Result();
        if (file == null || file.isEmpty()) {
            logger.info("图片不存在");
            result.setSuc(false, CodeEnum.E_0000000013);
            return result;
        }
        String oriFileName = file.getOriginalFilename();
        String suffix = FileUtil.getSuffix(oriFileName);
        if (null == suffix) {
            logger.info("图片格式不正确");
            result.setSuc(false, CodeEnum.E_0000000014);
            return result;
        }
        String path = SystemUtil.getParamVal("0001", "1");
        if (StringUtils.isEmpty(path)) {
            logger.info("图片存储路径系统参数丢失");
            result.setSuc(false, CodeEnum.E_0000000000);
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
            result.setSuc(false, CodeEnum.E_0000000014);
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
        result.setSuc(true, CodeEnum.E_0000000011);
        result.setData(relateUrl);
        return result;
    }

}
