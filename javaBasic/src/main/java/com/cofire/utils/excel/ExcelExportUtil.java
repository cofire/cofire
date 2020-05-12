package com.cofire.utils.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class ExcelExportUtil {
    public static <E> void excelExport(String fileName, String filePath, String sheetName, String[] rowHead, List<E[]> dataList) {
        System.out.println("开始生成excel");
        FileOutputStream fOut = null;
        // 创建一个新的HSSFWorkbook对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        try {
            File file = new File(filePath + fileName + ".xls");
            if (!file.getParentFile().exists()) {
                System.out.println("excel存放目录不存在");
                file.getParentFile().mkdirs();
                System.out.println("生成excel存放目录");
            }

            // 创建一个Excel的工作表，可以指定工作表的名字
            if (sheetName == null || sheetName.trim().length() > 0) {
                sheetName = "sheet1";
            }
            HSSFSheet sheet = workbook.createSheet(sheetName);
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
            int rowCount = 0;// 总行数
            int colCount = 0;// 总列数

            HSSFRow row = null;// 行
            HSSFCell cell = null; // 单元格

            if (rowHead != null && rowHead.length > 0) {
                rowCount = 1;
                colCount = rowHead.length;

                // 建立表头信息
                row = sheet.createRow((short) rowNum); // 在索引0的位置创建行
                for (colNum = 0; colNum < colCount; colNum++) {
                    // 在当前行的colNum列上创建单元格
                    cell = row.createCell((short) colNum);
                    // 定义单元格为字符类型，也可以指定为日期类型、数字类型
                    cell.setCellType(CellType.STRING);
                    cell.setCellStyle(cellStyle); // 为单元格设置格式
                    cell.setCellValue(rowHead[colNum]); // 添加内容至单元格
                }
                rowNum++;
            }
            if (dataList != null && dataList.size() > 0) {
                rowCount = rowCount + dataList.size();
                if (colCount == 0) {
                    E[] dataTmp = dataList.get(0);
                    colCount = dataTmp.length;
                }
                for (E[] data : dataList) {
                    // 新建第rowNum行
                    row = sheet.createRow((short) rowNum);
                    for (colNum = 0; colNum < colCount; colNum++) {
                        // 在当前行的colNum位置创建单元格
                        cell = row.createCell((short) colNum);
                        cell.setCellStyle(cellStyle1);
                        cell.setCellType(CellType.STRING);
                        if (data[colNum] != null) {
                            cell.setCellValue(data[colNum].toString());
                        } else {
                            cell.setCellValue("");
                        }
                    }
                    rowNum++;
                }
            }

            // 让列宽随着导出的列长自动适应
            for (colNum = 0; colNum < rowHead.length; colNum++) {
                int columnWidth = sheet.getColumnWidth(colNum) / 256;
                for (rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    HSSFRow currentRow;
                    // 当前行未被使用过
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    } else {
                        currentRow = sheet.getRow(rowNum);
                    }
                    if (currentRow.getCell(colNum) != null) {
                        HSSFCell currentCell = currentRow.getCell(colNum);
                        if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                            int length = currentCell.getStringCellValue().getBytes().length;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }
                }
                if (colNum == 0) {
                    sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
                } else {
                    sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
                }
            }
            // sheet.protectSheet("111111");
            fOut = new FileOutputStream(file);
            // 将创建的内容写到指定的Excel文件中
            workbook.write(fOut);
            workbook.writeProtectWorkbook("password", "owner");
            fOut.flush();
            fOut.close();// 操作结束，关闭文件
            System.out.println("Excel文件创建成功！\nExcel文件的存放路径为：" + file.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Excel文件创建失败\n其原因为：" + e);
        } finally {
            try {
                workbook.close();
                if (fOut != null) {
                    fOut.close();
                }
            } catch (IOException e1) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String fileName = "test";
        String filePath = "src/source/";
        String[] rowName = { "姓名", null, "性别", "住址" };
        Integer[] stu1 = { 1243242342, 1, 1, 1 };
        Integer[] stu2 = { 2, 1243242342, 2, 2 };
        Integer[] stu3 = { 3, 3, 1243242342, 3 };
        Integer[] stu4 = { 4, 4, null, 4 };
        List<Integer[]> listStu = new ArrayList();
        listStu.add(stu1);
        listStu.add(stu2);
        listStu.add(stu3);
        listStu.add(stu4);
        excelExport(fileName, filePath, "学生信息", rowName, listStu);
    }
}