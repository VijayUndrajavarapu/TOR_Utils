package com.metlife_torload.testsuites;

import com.metlife_torload.utils.WebDriver_Utils;
//import com.metlife_torload.utils.WebDriver_Utils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.util.Date;


class SetupTear extends WebDriver_Utils {

    static Workbook workbook;
    static File file;
    static FileInputStream fis;

    static String filePath = "src//test//loadtime//load.xlsx";
//    static String  filePath = "src//test//loadtime//load.xlsx";
    //\\ns-sisci01.metlife.com\FS_GTO_EI_RnA\Performance Management A&BI\LoadTime_auto.xlsx
   static Sheet sheet;
    public static int rowCount;
    static Row newRow;
    static String date;
    @BeforeClass
    public static void initialize() throws IOException {
        System.out.println("Before Class!");
        file = new File(filePath);
        fis = new FileInputStream(file);
        workbook = new XSSFWorkbook(fis);
         // Get the last row number from existing sheet (if any)
    }
    @BeforeMethod
    public static void LaunchBrowser() throws IOException {
        init("edge");
        System.out.println("Initializing Edge Browser!");
        launchBrowser("https://app.powerbi.com/groups/fc0f8a3c-2e89-4fb5-a374-e16a286ea0f3/reports/245a66d2-2039-48cd-8483-43f6e089a268/ReportSectiond2a3aae8148708b80972?experience=power-bi");
        System.out.println("Browser launched!");

        Date currentDate = new Date();
        date = currentDate.toString().replace(":", " ");
        if (sheet == null) {
            sheet = workbook.createSheet(date);
        }

        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Date");
            headerRow.createCell(1).setCellValue("Region");
            headerRow.createCell(2).setCellValue("Country");
            headerRow.createCell(3).setCellValue("Report");
            headerRow.createCell(4).setCellValue("Test");
            headerRow.createCell(5).setCellValue("From");
            headerRow.createCell(6).setCellValue("To");
            headerRow.createCell(7).setCellValue("Time");
        }
    }
    @AfterMethod
    public void closeBrowser() throws IOException {
        driver.manage().deleteAllCookies();
        driver.quit();
        System.out.println("end of execution");
        System.out.println("After Method!");
    }
    @AfterClass
    public static void TearDown() throws IOException {
        fis.close();
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos); // Write the updated workbook to the file
        workbook.close(); // Close the workbook
        fos.close(); // Close the FileOutputStream
    }

}
