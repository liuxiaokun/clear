package com.fred.ejingtong.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;

import java.io.FileOutputStream;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version 1.7
 * @date 2015/7/9
 */
public class GenerateExcel {


    public static void main(String[] args) throws Exception {

        // 第一步，HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        // 第二步，在HSSFWorkbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = hssfWorkbook.createSheet("sheet1");
        // 第三步，在sheet中添加表头第0行.
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //Green style.
        HSSFCellStyle greenStyle = hssfWorkbook.createCellStyle();
        Font greenFont = hssfWorkbook.createFont();
        greenFont.setColor(HSSFColor.GREEN.index);
        greenStyle.setFont(greenFont);

        //red style.
        HSSFCellStyle redStyle = hssfWorkbook.createCellStyle();
        Font redFont = hssfWorkbook.createFont();
        redFont.setColor(HSSFColor.RED.index);
        redStyle.setFont(redFont);

        //set title.
        HSSFCell cell0 = row.createCell(0);
        cell0.setCellValue("设备服务商");
        cell0.setCellStyle(style);

        HSSFCell cell1 = row.createCell(1);
        cell1.setCellValue("通关设备编号");
        cell1.setCellStyle(style);

        HSSFCell cell2 = row.createCell(2);
        cell2.setCellValue("设备系统版本号");
        cell2.setCellStyle(style);

        HSSFCell cell3 = row.createCell(3);
        cell3.setCellValue("景点名称");
        cell3.setCellStyle(style);

        HSSFCell cell4 = row.createCell(4);
        cell4.setCellValue("通关点名称");
        cell4.setCellStyle(style);

        HSSFCell cell5 = row.createCell(5);
        cell5.setCellValue("累计通关");
        cell5.setCellStyle(style);


        HSSFCell cell6 = row.createCell(6);
        cell6.setCellValue("是否有效");
        cell6.setCellStyle(style);

        for (int i = 0; i < 20; i++) {

            row = sheet.createRow(i + 1);
            // 第四步，创建单元格，并设置值
            row.createCell(0).setCellValue("LVMAMA");
            row.createCell(1).setCellValue("EQUIPMENTID");
            row.createCell(2).setCellValue("V3.0");
            row.createCell(3).setCellValue("北京欢乐谷");
            row.createCell(4).setCellValue("1号通关点");
            row.createCell(5).setCellValue(523L);
            HSSFCell cell = row.createCell(6);
            if (i % 2 == 0) {
                cell.setCellStyle(greenStyle);
                cell.setCellValue("有效");
            } else {
                cell.setCellStyle(redStyle);
                cell.setCellValue("无效");
            }

        }
        // 第六步，将文件存到指定位置
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E:/summary.xls");
            byte[] bytes = hssfWorkbook.getBytes();
            System.out.println(bytes);
            hssfWorkbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}