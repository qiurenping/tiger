package com.xmind;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelCreate {

    /**
     * 创建新excel(xls).
     * @param fileDir excel的路径
     * @param sheetNames 要创建的表格索引列表
     * @param titleRow  excel的第一行即表格头
     */
    public static void createExcelXls(String fileDir, List<String> sheetNames, String titleRow[]){

        //创建workbook
        HSSFWorkbook hWorkbook = new HSSFWorkbook();
        //新建文件
        FileOutputStream fileOutputStream = null;
        HSSFRow row = null;
        try {

            CellStyle cellStyle = hWorkbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.LEFT);
            cellStyle.setVerticalAlignment(VerticalAlignment.BOTTOM);

            //添加Worksheet（不添加sheet时生成的xls文件打开时会报错)
            for(int i = 0; i<sheetNames.size(); i++){
                hWorkbook.createSheet(sheetNames.get(i));
                hWorkbook.getSheet(sheetNames.get(i)).createRow(0);
                //添加表头, 创建第一行
                row = hWorkbook.getSheet(sheetNames.get(i)).createRow(0);
                row.setHeight((short)(20*20));
                for (short j = 0; j < titleRow.length; j++) {

                    HSSFCell cell = row.createCell(j, CellType.BLANK);
                    cell.setCellValue(titleRow[j]);
                    cell.setCellStyle(cellStyle);
                }
                fileOutputStream = new FileOutputStream(fileDir);
                hWorkbook.write(fileOutputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 创建新excel(xlsx).
     * @param fileDir excel的路径
     * @param sheetNames 要创建的表格索引列表
     * @param titleRow  excel的第一行即表格头
     */
    public static void createExcelXlsx(String fileDir, List<String> sheetNames, String titleRow[]){

        //创建workbook
        XSSFWorkbook xWorkbook = new XSSFWorkbook();
        //新建文件
        FileOutputStream fileOutputStream = null;
        XSSFRow row = null;
        try {

            CellStyle cellStyle = xWorkbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.LEFT);
            cellStyle.setVerticalAlignment(VerticalAlignment.BOTTOM);

            //添加Worksheet（不添加sheet时生成的xls文件打开时会报错)
            for(int i = 0; i<sheetNames.size(); i++){
                xWorkbook.createSheet(sheetNames.get(i));
                xWorkbook.getSheet(sheetNames.get(i)).createRow(0);
                //添加表头, 创建第一行
                row = xWorkbook.getSheet(sheetNames.get(i)).createRow(0);
                row.setHeight((short)(20*20));
                for (short j = 0; j < titleRow.length; j++) {

                    XSSFCell cell = row.createCell(j, CellType.BLANK);
                    cell.setCellValue(titleRow[j]);
                    cell.setCellStyle(cellStyle);
                }
                fileOutputStream = new FileOutputStream(fileDir);
                xWorkbook.write(fileOutputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
