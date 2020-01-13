package com.cofire.common.utils.file;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.cofire.common.utils.context.HttpUtil;
import org.apache.commons.lang.StringUtils;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.cofire.common.utils.string.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasyExcelUtils {
    private final static Logger logger = LoggerFactory.getLogger(EasyExcelUtils.class);
    /**
     * @param @param  response
     * @param @param  clazz
     * @param @param  dateList
     * @param @param  type
     * @param @param  fileName
     * @param @param  sheetName
     * @param @throws IOException 参数
     * @return void 返回类型
     * @Title: createExcelStream
     * @author ly
     * @Description:数据导出excel
     */
    public static void createExcelStream(HttpServletResponse response, Class<? extends BaseRowModel> clazz, List<? extends BaseRowModel> dateList,
                                         ExcelTypeEnum type, String fileName, String sheetName) throws IOException {
        if (StringUtils.isEmpty(fileName)) {
            fileName = DateUtils.dataTimeToNumber(new Date());
        }
        if (StringUtils.isEmpty(sheetName)) {
            sheetName = "index";
        }
        try {
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + type.getValue());
            ServletOutputStream out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, type, true);
            if (dateList.size() > 0) {
                Sheet sheet = new Sheet(1, 0, clazz);
                sheet.setSheetName(sheetName);
                writer.write(dateList, sheet);
                writer.finish();
                out.flush();
            }
        } catch (IOException e) {
            logger.error("error:", e);
            response.sendRedirect("/error/exportError");
        }
    }
}
