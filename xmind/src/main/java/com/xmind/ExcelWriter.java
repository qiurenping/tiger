package com.xmind;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

    private static HSSFWorkbook hWorkbook = null;
    private static XSSFWorkbook xWorkbook = null;

    /**
     * 判断文件是否存在.
     * @param fileDir  文件路径
     * @return
     */
    public static boolean fileExist(String fileDir){
        boolean flag = false;
        File file = new File(fileDir);
        flag = file.exists();
        return flag;
    }

    /**
     * 判断文件的sheet是否存在.
     * @param fileDir   文件路径
     * @param sheetName  表格索引名
     * @return boolean
     */
    public static boolean XlsSheetExist(String fileDir, String sheetName){

        boolean flag = false;
        File file = new File(fileDir);

        if (file.exists()) {
            //文件存在，创建workbook
            try {
                hWorkbook = new HSSFWorkbook(new FileInputStream(file));

                HSSFSheet sheet = hWorkbook.getSheet(sheetName);
                if (sheet!=null) {
                    //文件存在，sheet存在

                    flag = true;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else {
            //文件不存在
            flag = false;
        }
        return flag;
    }

    /**
     * 删除文件.
     * @param fileDir  文件路径
     * @return 如果文件不存在返回false, 如果文件存在删除成功之后返回true
     */
    public static boolean deleteExcel(String fileDir) {
        boolean flag = false;
        File file = new File(fileDir);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return flag;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                file.delete();
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 往excel(xls)中写入(已存在的数据无法写入).
     * @param fileDir    文件路径
     * @param sheetName  表格索引
     * @param mapList
     * @throws Exception
     */

    public static void writeToExcelXls(String fileDir, String sheetName, List<Map<String,String>> mapList) throws Exception{

        //创建workbook
        File file = new File(fileDir);

        try {
            hWorkbook = new HSSFWorkbook(new FileInputStream(file));

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        //文件流
        FileOutputStream fileOutputStream = null;
        HSSFSheet sheet = hWorkbook.getSheet(sheetName);
        // 获取表格的总行数
        // int rowCount = sheet.getLastRowNum() + 1; // 需要加一
        //获取表头的列数
        int columnCount = sheet.getRow(0).getLastCellNum();

        try {
            // 获得表头行对象
            HSSFRow titleRow = sheet.getRow(0);
            //创建单元格显示样式
            CellStyle cellStyle = hWorkbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.LEFT);
            cellStyle.setVerticalAlignment(VerticalAlignment.BOTTOM);


            if(titleRow!=null){
                for(int rowId = 0; rowId < mapList.size(); rowId++){
                    Map<String,String> map = mapList.get(rowId);
                    HSSFRow newRow=sheet.createRow(rowId+1);
                    newRow.setHeight((short)(20*20));//设置行高  基数为20

                    for (short columnIndex = 0; columnIndex < columnCount; columnIndex++) {  //遍历表头
                        //trim()的方法是删除字符串中首尾的空格
                        String mapKey = titleRow.getCell(columnIndex).toString().trim();
                        HSSFCell cell = newRow.createCell(columnIndex);
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue(map.get(mapKey)==null ? null : map.get(mapKey).toString());
                    }
                }
            }

            fileOutputStream = new FileOutputStream(fileDir);
            hWorkbook.write(fileOutputStream);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 往excel(xlsx)中写入(已存在的数据无法写入).
     * @param fileDir    文件路径
     * @param sheetName  表格索引
     * @param mapList
     * @throws Exception
     */

    public static void writeToExcelXlsx(String fileDir, String sheetName, List<Map<String,String>> mapList) throws Exception{

        //创建workbook
        File file = new File(fileDir);

        try {
            xWorkbook = new XSSFWorkbook(new FileInputStream(file));

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        //文件流
        FileOutputStream fileOutputStream = null;
        XSSFSheet sheet = xWorkbook.getSheet(sheetName);
        // 获取表格的总行数
        // int rowCount = sheet.getLastRowNum() + 1; // 需要加一
        //获取表头的列数
        int columnCount = sheet.getRow(0).getLastCellNum();

        try {
            // 获得表头行对象
            XSSFRow titleRow = sheet.getRow(0);
            //创建单元格显示样式
            CellStyle cellStyle = xWorkbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.LEFT);
            cellStyle.setVerticalAlignment(VerticalAlignment.BOTTOM);


            if(titleRow!=null){
                for(int rowId = 0; rowId < mapList.size(); rowId++){
                    Map<String,String> map = mapList.get(rowId);
                    XSSFRow newRow=sheet.createRow(rowId+1);
                    newRow.setHeight((short)(20*20));//设置行高  基数为20

                    for (short columnIndex = 0; columnIndex < columnCount; columnIndex++) {  //遍历表头
                        //trim()的方法是删除字符串中首尾的空格
                        String mapKey = titleRow.getCell(columnIndex).toString().trim();
                        XSSFCell cell = newRow.createCell(columnIndex);
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue(map.get(mapKey)==null ? null : map.get(mapKey).toString());
                    }
                }
            }

            fileOutputStream = new FileOutputStream(fileDir);
            xWorkbook.write(fileOutputStream);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
