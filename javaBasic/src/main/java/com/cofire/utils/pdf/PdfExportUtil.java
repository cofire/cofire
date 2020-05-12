package com.cofire.utils.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfExportUtil {

    private static Font headfont;// 设置字体大小
    private static Font keyfont;// 设置字体大小
    private static Font textfont;// 设置字体大小
    private static int maxWidth = 520;// 设置表格宽度

    static {
        BaseFont bfChinese;
        try {
            bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            headfont = new Font(bfChinese, 10, Font.BOLD);// 设置字体大小
            keyfont = new Font(bfChinese, 8, Font.BOLD);// 设置字体大小
            textfont = new Font(bfChinese, 8, Font.NORMAL);// 设置字体大小
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <E> Boolean pdfExport(String fileName, String filePath, String title, String[] rowName, List<E[]> dataList) throws Exception {
        System.out.println("开始生成pdf");
        Document document = new Document();
        try {
            File file = new File(filePath + fileName + ".pdf");
            if (!file.getParentFile().exists()) {
                System.out.println("pdf存放目录不存在");
                file.getParentFile().mkdirs();
                System.out.println("生成pdf存放目录");
            }
            file.createNewFile();
            document.setPageSize(PageSize.A4);// 设置页面大小
            try {
                PdfWriter.getInstance(document, new FileOutputStream(file));
                document.open();
            } catch (Exception e) {
                System.err.println("生成pdf失败");
                e.printStackTrace();
                document.close();
                return false;
            }
            generatePDF(document, title, rowName, dataList);
            System.out.println("生成pdf结束");
            return true;
        } catch (Exception e) {
            System.err.println("生成pdf失败");
            e.printStackTrace();
            document.close();
            return false;
        }
    }

    public static PdfPCell createCell(String value, com.itextpdf.text.Font font, int align) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    public static PdfPCell createCell(String value, com.itextpdf.text.Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    public PdfPCell createCell(String value, com.itextpdf.text.Font font, int align, int colspan) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    public static PdfPCell createCell(String value, com.itextpdf.text.Font font, int align, int colspan, boolean boderFlag) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setPhrase(new Phrase(value, font));
        cell.setPadding(3.0f);
        if (!boderFlag) {
            cell.setBorder(0);
            cell.setPaddingTop(15.0f);
            cell.setPaddingBottom(8.0f);
        }
        return cell;
    }

    public static PdfPTable createTable(int colNumber) {
        PdfPTable table = new PdfPTable(colNumber);
        try {
            table.setTotalWidth(maxWidth);
            table.setLockedWidth(true);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setBorder(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    public static PdfPTable createTable(float[] widths) {
        PdfPTable table = new PdfPTable(widths);
        try {
            table.setTotalWidth(maxWidth);
            table.setLockedWidth(true);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setBorder(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    public static PdfPTable createBlankTable() {
        PdfPTable table = new PdfPTable(1);
        table.getDefaultCell().setBorder(0);
        table.addCell(createCell("", keyfont));
        table.setSpacingAfter(20.0f);
        table.setSpacingBefore(20.0f);
        return table;
    }

    public static <E> void generatePDF(Document document, String title, String[] rowName, List<E[]> dataList) throws Exception {
        Integer length = 0;
        if (rowName != null && rowName.length > 0) {
            length = rowName.length;
        } else {
            if (dataList != null && dataList.size() > 0) {
                E[] data = dataList.get(0);
                if (data != null && data.length > 0) {
                    length = data.length;
                }
            }
        }
        if (length > 0) {
            PdfPTable table = createTable(length);
            if (title != null && title.trim().length() > 0) {
                table.addCell(createCell(title, keyfont, Element.ALIGN_CENTER, length, false));
            }
            if (rowName != null && rowName.length > 0) {
                for (String name : rowName) {
                    if (name != null) {
                        table.addCell(createCell(name, keyfont, Element.ALIGN_CENTER));
                    } else {
                        table.addCell(createCell("", keyfont, Element.ALIGN_CENTER));
                    }
                }
            }
            if (dataList != null && dataList.size() > 0) {
                for (E[] data : dataList) {
                    if (data != null && data.length > 0) {
                        int lengthTmp = data.length;
                        if (lengthTmp > length) {
                            lengthTmp = length;
                        }
                        for (int i = 0; i < lengthTmp; i++) {
                            if (data[i] != null) {
                                table.addCell(createCell(data[i].toString(), textfont));
                            } else {
                                table.addCell(createCell("".toString(), textfont));
                            }
                        }
                    }
                }
            }
            document.add(table);
        } else {
            document.add(new Paragraph("暂无数据", keyfont));
        }
        document.close();
    }

    public static void main(String[] args) throws Exception {
        // File file = new File("src\\source\\text.pdf");
        // file.createNewFile();
        // new PdfExport(file).generatePDF();
        String fileName = "test3";
        String filePath = "src/source/";
        String[] rowName = { "姓名", null, "性别", "住址" };
        Integer[] stu1 = { 1, 1, 1, 1 };
        Integer[] stu2 = { 2, 2, 2, 2 };
        Integer[] stu3 = { 3, 3, 3, 3 };
        Integer[] stu4 = { 4, 4, null, 4 };
        List<Integer[]> listStu = new ArrayList();
        listStu.add(stu1);
        listStu.add(stu2);
        listStu.add(stu3);
        listStu.add(stu4);

        System.out.println(pdfExport(fileName, filePath, "学生信息", rowName, listStu));
    }

}