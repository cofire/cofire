package com.cofire.console.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

public class EasyExcelUtils {
    /**
     *
     * @param response
     * @param dateList
     * @param type
     * @param name fileName and sheetName
     * @throws UnsupportedEncodingException
     */
    public static void createExcelStream(HttpServletResponse response, List<? extends BaseRowModel> dateList, ExcelTypeEnum type, String name)
            throws UnsupportedEncodingException {
        try {
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" + name + type.getValue());
            ServletOutputStream out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, type, true);
            // TODO 数据为空时。。。。
            if (dateList.size() > 0) {
                Sheet sheet = new Sheet(1, 0, dateList.get(0).getClass());
                sheet.setSheetName(name);
                writer.write(dateList, sheet);
                writer.finish();
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
