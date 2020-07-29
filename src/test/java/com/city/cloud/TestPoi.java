package com.city.cloud;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;

public class TestPoi {

    public static void main(String[] args) throws  Exception {
        //1 创建工作薄:Workbook是一个接口，它有一个实现类HSSFWorkbook对象，这个对象专门操作excel97-03，excel的后缀名是xls
        Workbook wb = new HSSFWorkbook();
        //2 创建工作表sheet:工作表
        Sheet sheet = wb.createSheet();
        //3 创建行对象,java中从0开始计数
        Row row = sheet.createRow(3);
        //4 创建列对象
        Cell cell = row.createCell(3);


        //5 设置内容
        cell.setCellValue("itcast,一统江湖");
        //6 设置内容格式
        Font font = wb.createFont();
        font.setFontHeightInPoints((short)17);//以像素点的方式设置字体大小
        font.setFontName("宋体");//设置字体




        //System.out.println(Short.MIN_VALUE+"-"+Short.MAX_VALUE);
        //创建格式
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFont(font);

        //将cellStyle给cell
        cell.setCellStyle(cellStyle);
        //7 保存（javase项目采用保存）
        FileOutputStream stream = new FileOutputStream(new File("d://a.xls"));
        wb.write(stream);//将对象写进流

        stream.flush();
        stream.close();
        //8 下载(web项目 才有下载)

        System.out.println("运行结束");
    }




}
