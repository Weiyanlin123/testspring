package com.citycloud.dcm.street.util;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;


public class ExcelUtil {

    /**
     * 导出Excel
     * @return
     */

    //大标题的样式
    public static CellStyle bigTitle(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("仿宋_GB2312");
        font.setFontHeightInPoints((short)16);
        // font.setBoldweight(Font.BOLDWEIGHT_BOLD);					//字体加粗
        style.setFont(font);
        style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        return style;
    }
    //小标题的样式
    public static CellStyle title(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("仿宋_GB2312");
        font.setFontHeightInPoints((short)12);

        style.setFont(font);

        style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        font.setBoldweight(Font.BOLDWEIGHT_BOLD);                   //加粗

        style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
        style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
        style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
        style.setBorderRight(CellStyle.BORDER_THIN);				//右细线

        return style;
    }

    //文字样式
    public static CellStyle text(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("仿宋_GB2312");
        font.setFontHeightInPoints((short)12);

        style.setFont(font);
        style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
        style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
        style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
        style.setBorderRight(CellStyle.BORDER_THIN);				//右细线

        return style;
    }

    //文字样式
    public static CellStyle endText(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("仿宋_GB2312");
        font.setFontHeightInPoints((short)12);

        style.setFont(font);
        style.setAlignment(CellStyle.ALIGN_LEFT);					//横向居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        //横向居左
//        style.setAlignment(CellStyle.ALIGN_LEFT);
//        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

//        style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
//        style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
//        style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
//        style.setBorderRight(CellStyle.BORDER_THIN);				//右细线

        return style;
    }

}
