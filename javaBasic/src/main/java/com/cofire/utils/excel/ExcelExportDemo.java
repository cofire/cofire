package com.cofire.utils.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

//创建Excel文件
public class ExcelExportDemo {
    // 新建一个Excel文件，里面添加5行5列的内容，另外添加一个合并2行5列的大单元格以及一个合并2行1列的5个合并单元格。
    public void createExcel(String fileName) {
        File file = new File(fileName);// 创建excel文件对象
        FileOutputStream fOut = null;
        try {
            // 创建一个新的HSSFWorkbook对象
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 创建一个Excel的工作表，可以指定工作表的名字
            HSSFSheet sheet = workbook.createSheet("myFirstExcel");
            // 创建字体，红色、粗体
            HSSFFont font = workbook.createFont();
            font.setColor(HSSFFont.COLOR_NORMAL);
            font.setBold(true);
            HSSFFont font1 = workbook.createFont();
            // 创建字体，黑色、非粗体
            font1.setColor(HSSFFont.COLOR_NORMAL);
            font1.setBold(false);
            // 创建单元格的格式，如居中、左对齐等
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER); // 水平方向上居中对齐
            // 垂直方向上居中对齐
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle.setFont(font); // 设置字体
            HSSFCellStyle cellStyle1 = workbook.createCellStyle();
            cellStyle1.setAlignment(HorizontalAlignment.LEFT);
            cellStyle1.setFont(font1);
            // 下面将建立一个4行3列的表。第一行为表头。
            int rowNum = 0;// 行标
            int colNum = 0;// 列标
            // 建立表头信息
            HSSFRow row = sheet.createRow((short) rowNum); // 在索引0的位置创建行
            HSSFCell cell = null; // 单元格
            for (colNum = 0; colNum < 5; colNum++) {
                // 在当前行的colNum列上创建单元格
                cell = row.createCell((short) colNum);
                // 定义单元格为字符类型，也可以指定为日期类型、数字类型
                cell.setCellType(CellType.STRING);
                cell.setCellStyle(cellStyle); // 为单元格设置格式
                cell.setCellValue("表头-第" + (colNum + 1) + "列"); // 添加内容至单元格
            }
            rowNum++;
            for (; rowNum < 5; rowNum++) {
                // 新建第rowNum行
                row = sheet.createRow((short) rowNum);
                for (colNum = 0; colNum < 5; colNum++) {
                    // 在当前行的colNum位置创建单元格
                    cell = row.createCell((short) colNum);
                    cell.setCellStyle(cellStyle1);
                    cell.setCellValue("表体-第" + rowNum + "行第" + (colNum + 1) + "列");
                }
            }
            // 合并单元格
            // 先创建2行5列的单元格，然后将这些单元格合并为2个大单元格
            rowNum = 5;
            for (; rowNum < 9; rowNum++) {
                row = sheet.createRow((short) rowNum);
                for (colNum = 0; colNum < 5; colNum++) {
                    // 在当前行的colNum位置创建单元格
                    cell = row.createCell((short) colNum);
                }
            }
            fOut = new FileOutputStream(file);
            // 将创建的内容写到指定的Excel文件中
            workbook.write(fOut);
            fOut.flush();
            fOut.close();// 操作结束，关闭文件
            System.out.println("Excel文件创建成功！\nExcel文件的存放路径为：" + file.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Excel文件" + file.getAbsolutePath() + "创建失败\n其原因为：" + e);
        } finally {
            if (fOut != null) {
                try {
                    fOut.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ExcelExportDemo excel = new ExcelExportDemo();
        String fileName = "src/source/ExcelExportUtil.xls";
        excel.createExcel(fileName);
    }
}