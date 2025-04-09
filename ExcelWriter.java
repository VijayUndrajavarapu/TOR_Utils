package com.metlife_torload.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class ExcelWriter {
    private static final String FILE_PATH = "Test_Reports/LoadTimes.xlsx";
    private static final Object lock = new Object();

    public static void writeRow(List<String> rowData) {
        synchronized (lock) {
            try (FileInputStream fis = new FileInputStream(FILE_PATH);
                 Workbook workbook = new XSSFWorkbook(fis)) {

                Sheet sheet = workbook.getSheetAt(0);
                int rowNum = sheet.getLastRowNum() + 1;
                Row row = sheet.createRow(rowNum);

                for (int i = 0; i < rowData.size(); i++) {
                    row.createCell(i).setCellValue(rowData.get(i));
                }

                fis.close(); // Must close before writing again

                try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                    workbook.write(fos);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
