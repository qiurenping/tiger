package com.xmind;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public List<String> ExcelReader(String filepath) throws IOException {
        if (filepath == null){
            return null;
        }
        File xlsFile = new File(filepath);
        if (!xlsFile.exists()) return null;
        // 工作表
        Workbook workbook = WorkbookFactory.create(xlsFile);
        // 表个数
        int numberOfSheets = workbook.getNumberOfSheets();
        List list = new ArrayList();
        Sheet sheet = workbook.getSheet("SHeet1");
        int rowNumbers = sheet.getLastRowNum() + 1;
        System.out.println(rowNumbers);
        for (int row = 1; row < rowNumbers; row++) {
            Row r = sheet.getRow(row);
            if (r.getPhysicalNumberOfCells() >= 2) {
                String score = r.getCell(0).toString();
                list.add(score);
            }
        }
        return list;
    }


}
