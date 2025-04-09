package com.metlife_torload.testsuites;


import com.metlife_torload.po.PageObjects;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import static com.metlife_torload.Load_BLogic.BL_LoadTime.*;
import static com.metlife_torload.po.PageObjects.*;

import static com.metlife_torload.utils.jsExcutor_util.clickElementJs;
import static com.metlife_torload.utils.jsExcutor_util.ctrl_click;


public class LoadTImes extends SetupTear{

     // Get the last row number;
    @Test (priority = -1)
    public static void ExecutiveSummary() throws Exception {
        rowCount = sheet.getLastRowNum()+1;
        clickElement(L0_GTO);


        newRow = sheet.createRow(rowCount + 2); // Create a new row at the end
        newRow.createCell(0).setCellValue(date);
        newRow.createCell(1).setCellValue("Asia");
        newRow.createCell(2).setCellValue("India");
        newRow.createCell(3).setCellValue("Executive Summary");
        newRow.createCell(4).setCellValue("Drill Thru");
        newRow.createCell(5).setCellValue("GTO");
        newRow.createCell(6).setCellValue("GT");
        newRow.createCell(7).setCellValue(loadTime_Click(L0_GT));

        newRow=sheet.createRow(rowCount+3);
        newRow.createCell(3).setCellValue("Executive Summary");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("GT");
        newRow.createCell(7).setCellValue(loadTime_refresh());
//
        newRow=sheet.createRow(rowCount+4);
        newRow.createCell(3).setCellValue("Executive Summary");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("Asia");
//        clickElement_Refresh((L0_Slicer));
//        reset(L0_reset,L0_reset_OK);
//        Thread.sleep(10000);
        clickElement_Refresh((L0_Slicer));
        clickElement(L0_Slicer_GT_Checkbox);
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[text()='Asia Technology']")));

        newRow=sheet.createRow(rowCount+5);
        newRow.createCell(3).setCellValue("Executive Summary");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("CS");
//        clickElement((L0_Slicer));
//        clickElement(L0_Slicer_GT_Checkbox);
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[text()='Corporate Systems Technology']")));

        newRow=sheet.createRow(rowCount+6);
        newRow.createCell(3).setCellValue("Executive Summary");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("UST");
//        clickElement((L0_Slicer));
//        clickElement(L0_Slicer_GT_Checkbox);
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[text()='U.S. Technology']")));

        newRow=sheet.createRow(rowCount+7);
        newRow.createCell(3).setCellValue("Executive Summary");
        newRow.createCell(4).setCellValue("Reset Filter");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("GT");
//        clickElement((L0_Slicer));
//        clickElement(L0_Slicer_GT_Checkbox);
        newRow.createCell(7).setCellValue(load_Reset());

    }
    @Test(priority = 0,enabled = false)
    public static void OperationalHealth() throws Exception {
//        rowCount = sheet.getLastRowNum()+1;
        rowCount = sheet.getLastRowNum();
        newRow=sheet.createRow(rowCount+2);
        newRow.createCell(3).setCellValue("Operational Health");
        newRow.createCell(4).setCellValue("Drill Thru");
        newRow.createCell(5).setCellValue("L0");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(drillThru(By.xpath("(//*[@data-sub-selection-display-name='Card_Background_Color'])[9]")));


        newRow=sheet.createRow(rowCount+3);
        newRow.createCell(3).setCellValue("Operational Health");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(loadTime_refresh());

        clickElement_Refresh(By.xpath("//div[@class='imageBackground']"));
        clickElement_Refresh(By.xpath("(//*[@class='fill ui-role-button-fill sub-selectable'])[2]"));
        reset(L0_reset,L0_reset_OK);
        clickElement_Refresh(By.xpath("(//*[@class='slicer-dropdown-menu'])[1]"));

//        clickElement(By.xpath("//*[@class='glyphicon pbi-glyph-chevronupsmall']"));
        clickElement(By.xpath("//*[text()='Select all']"));
        clickElement(By.xpath("//*[text()='No CIO Identified']"));
        reset(L0_reset,L0_reset_OK);
        clickElement_Refresh(By.xpath("(//*[@class='slicer-dropdown-menu'])[1]"));
//        clickElement(By.xpath("//*[text()='Select all']"));
        clickElement(By.xpath("//*[text()='Global Technology']"));
        reset(L0_reset,L0_reset_OK);
        clickElement_Refresh(By.xpath("(//*[@class='slicer-dropdown-menu'])[1]"));
//        clickElement(By.xpath("//*[text()='Select all']"));
//        clickElement_Refresh(By.xpath("(//*[@class='slicer-dropdown-menu'])[1]"),
//                By.xpath("(//*[@class='glyphicon pbi-glyph-chevrondownsmall'])[2]"));
//EXPAND RAYALI
        newRow=sheet.createRow(rowCount+4);
        newRow.createCell(3).setCellValue("Operational Health");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("Asia");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[@title='Asia Technology']")));

        newRow=sheet.createRow(rowCount+5);
        newRow.createCell(3).setCellValue("Operational Health");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("CS");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[@title='Corporate Systems Technology']")));

        newRow=sheet.createRow(rowCount+6);
        newRow.createCell(3).setCellValue("Operational Health");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("UST");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[@title='U.S. Technology']")));

        newRow=sheet.createRow(rowCount+7);
        newRow.createCell(3).setCellValue("Operational Health");
        newRow.createCell(4).setCellValue("Reset Filter");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("GT");
//        clickElement((L0_Slicer));
//        clickElement(L0_Slicer_GT_Checkbox);
        newRow.createCell(7).setCellValue(load_Reset());

    }
    @Test(priority = 1)
    public static void HR_WorkForce() throws Exception {
        rowCount = sheet.getLastRowNum();
        newRow=sheet.createRow(rowCount+2);
        newRow.createCell(3).setCellValue("HR");
        newRow.createCell(4).setCellValue("Drill Thru");
        newRow.createCell(5).setCellValue("L0");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(drillThru(By.xpath("(//*[@class='visual customPadding allow-deferred-rendering visual-actionButton'])[8]")));

        newRow=sheet.createRow(rowCount+3);
        newRow.createCell(3).setCellValue("HR");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(loadTime_refresh());

        clickElement_Refresh(By.xpath("//*[text()='Employee']"));
        clickElement_Refresh(By.xpath("//*[text()='Employee']"));
        clickElement_Refresh(By.xpath("//*[text()='Employee']"));

        click(By.xpath("(//*[@class='imageBackground'])[2]"));

        newRow=sheet.createRow(rowCount+4);
        newRow.createCell(3).setCellValue("HR");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("UST");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("(//*[@class='slicer-content-wrapper'])[1]")));

        newRow=sheet.createRow(rowCount+5);
        newRow.createCell(3).setCellValue("HR");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("GT");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[text()='Global Technology']")));

        newRow=sheet.createRow(rowCount+6);
        newRow.createCell(3).setCellValue("HR");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("GS");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("(//*[text()='Global Security'])")));

//        click(By.xpath("(//*[@class='glyphicon pbi-glyph-chevrondownsmall'])[3]"));

        newRow=sheet.createRow(rowCount+7);
        newRow.createCell(3).setCellValue("HR");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("DNA");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("(//*[text()='MetLife Data and Analytics'])")));


        //        sheet_HR.createRow(2);
//        sheet_HR.getRow(1).createCell(2).setCellValue(extractNumericValue(gettext(By.xpath("(//div[@class='visual customPadding allow-deferred-rendering visual-card'])"))));
        click(By.xpath("(//*[@class='imageBackground'])[2]"));
        click(By.xpath("(//*[@class='slicer-content-wrapper'])[1]"));
        click(By.xpath("(//*[@class='glyphicon pbi-glyph-chevrondownsmall'])[3]"));

        newRow=sheet.createRow(rowCount+8);
        newRow.createCell(3).setCellValue("HR");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("Asia");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[@title='Asia Technology']")));


        newRow=sheet.createRow(rowCount+9);
        newRow.createCell(3).setCellValue("HR");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("CS");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[@title='Corporate Systems Technology']")));

//        click(By.xpath("(//*[@class='glyphicon pbi-glyph-chevrondownsmall'])[3]"));

//        driver.navigate().refresh();
        Thread.sleep(20000);
        newRow=sheet.createRow(rowCount+10);
        newRow.createCell(3).setCellValue("HR");
        newRow.createCell(4).setCellValue("Reset Filter");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("GT");
        newRow.createCell(7).setCellValue(load_Reset());

//        click(By.xpath("(//*[@class='slicer-content-wrapper'])[1]"));


    }
    @Test(priority = 2)
    public static void ADM_Testing() throws Exception {
        rowCount = sheet.getLastRowNum();
        newRow=sheet.createRow(rowCount+2);
        newRow.createCell(3).setCellValue("ADM");
        newRow.createCell(4).setCellValue("Drill Thru");
        newRow.createCell(5).setCellValue("L0");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(drillThru(By.xpath("(//*[@class='visual customPadding allow-deferred-rendering visual-actionButton'])[12]")));

        clickElement(By.xpath("(//*[contains(text(),'Azure Test Plan Adoption')])[1]"));

        /*reset(L0_reset,L0_reset_OK);
        driver.navigate().refresh();
        clickElement(By.xpath("(//div[@class='slicer-restatement'])[1]"));
*/
        newRow=sheet.createRow(rowCount+4);
        newRow.createCell(3).setCellValue("ADM");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("Page Refresh");
        newRow.createCell(7).setCellValue(loadTime_refresh());

//        clickElement(By.xpath("(//div[@class='slicer-restatement'])[1]"));
        clickElement(By.xpath("(//*[@class='imageBackground'])[5]"));
        clickElement(By.xpath("(//*[@class='slicer-restatement'])[1]"));

        clickElement(By.xpath("//*[@title='Select all']"));
        newRow=sheet.createRow(rowCount+3);
        newRow.createCell(3).setCellValue("ADM");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("Select All");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[contains(text(),'Select all')]")));

        clickElement(By.xpath("//*[@title='Select all']"));

        newRow=sheet.createRow(rowCount+5);
        newRow.createCell(3).setCellValue("ADM");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("GT");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[contains(text(),'Global Technology')]")));

        newRow=sheet.createRow(rowCount+6);
        newRow.createCell(3).setCellValue("ADM");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("GS");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[contains(text(),'Global Security')]")));

        clickElementJs(By.xpath("(//*[@class='expandButton'])[2]"));


        newRow=sheet.createRow(rowCount+7);
        newRow.createCell(3).setCellValue("ADM");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("DnA");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[contains(text(),'MetLife Data and Analytics')]")));


        newRow=sheet.createRow(rowCount+8);
        newRow.createCell(3).setCellValue("ADM");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("Gt_expand");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("(//*[@class='glyphicon pbi-glyph-chevrondownsmall'])[3]")));

//        Thread.sleep(20000);
        newRow=sheet.createRow(rowCount+9);
        newRow.createCell(3).setCellValue("ADM");
        newRow.createCell(4).setCellValue("Reset Filter");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("GT");
        newRow.createCell(7).setCellValue(load_Reset());


    }
    @Test(priority = 3)
    public static void SAT() throws Exception {
        rowCount = sheet.getLastRowNum();
        newRow=sheet.createRow(rowCount+2);
        newRow.createCell(3).setCellValue("SAT");
        newRow.createCell(4).setCellValue("Drill Thru");
        newRow.createCell(5).setCellValue("L0");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(drillThru(By.xpath("(//*[@class='visual customPadding allow-deferred-rendering visual-actionButton'])[11]")));

        clickElement_Refresh(By.xpath("(//*[@class='visual customPadding allow-deferred-rendering visual-image'])[3]"));
        clickElement_Refresh(By.xpath("(//div[@class='slicer-dropdown-menu'])[1]"));
        clickElement(By.xpath("//*[text()='Select all']"));

        reset(L0_reset, L0_reset_OK);


        newRow=sheet.createRow(rowCount+3);
        newRow.createCell(3).setCellValue("SAT");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(loadTime_refresh());

        clickElement(By.xpath("(//div[@class='slicer-dropdown-menu'])[1]"));

        newRow=sheet.createRow(rowCount+4);
        newRow.createCell(3).setCellValue("SAT");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("GT");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[@title='Global Technology']")));

        clickElement(By.xpath("//*[@title='Global Technology']"));
        clickElement(By.xpath("(//*[@class='expandButton'])[2]"));

        newRow=sheet.createRow(rowCount+5);
        newRow.createCell(3).setCellValue("SAT");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("Asia");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[@title='Asia Technology']")));

        newRow=sheet.createRow(rowCount+6);
        newRow.createCell(3).setCellValue("SAT");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("CS");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[@title='Corporate Systems Technology']")));

        clickElement(By.xpath("(//*[@class='expandButton'])[2]"));

        reset(L0_reset, L0_reset_OK);
        clickElement(By.xpath("(//div[@class='slicer-dropdown-menu'])[1]"));

        newRow=sheet.createRow(rowCount+7);
        newRow.createCell(3).setCellValue("SAT");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("GS");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("(//*[text()='Global Security'])[2]")));

        newRow=sheet.createRow(rowCount+9);
        newRow.createCell(3).setCellValue("SAT");
        newRow.createCell(4).setCellValue("Reset Filter");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("GT");
        newRow.createCell(7).setCellValue(load_Reset());

        clickElement(By.xpath("(//div[@class='slicer-dropdown-menu'])[1]"));
        newRow=sheet.createRow(rowCount+8);
        newRow.createCell(3).setCellValue("SAT");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("GT");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("(//*[text()='MetLife Data and Analytics'])[2]")));

    }
    @Test(priority = 4)
    public static void AppSecurity() throws Exception {

        rowCount = sheet.getLastRowNum();
        newRow=sheet.createRow(rowCount+2);
        newRow.createCell(3).setCellValue("AppSecurity");
        newRow.createCell(4).setCellValue("Drill Thru");
        newRow.createCell(5).setCellValue("L0");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(drillThru(By.xpath("(//*[@class='visual customPadding allow-deferred-rendering visual-actionButton'])[15]")));

        newRow=sheet.createRow(rowCount+3);
        newRow.createCell(3).setCellValue("AppSecurity");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(loadTime_refresh());

        newRow=sheet.createRow(rowCount+4);
        newRow.createCell(3).setCellValue("AppSecurity");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("(//div[@class='slicer-restatement'])[2]")));
        Thread.sleep(15000);
        ctrl_click(By.xpath("//*[text()='Global Security']"),By.xpath("(//span[@class='glyphicon checkbox checkboxOutline'])[2]"),By.xpath("//*[text()='MetLife Data and Analytics']"));

        clickElement(PageObjects.L1_GS);


        newRow=sheet.createRow(rowCount+5);
        newRow.createCell(3).setCellValue("AppSecurity");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("GT");
        newRow.createCell(7).setCellValue(loadTime_Click((PageObjects.L1_GT)));
        clickElementJs(L1_GT_Expand);
        clickElement(By.xpath("//*[text()='Global Security']"));
        newRow=sheet.createRow(rowCount+6);
        newRow.createCell(3).setCellValue("AppSecurity");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("Asia");
        newRow.createCell(7).setCellValue(loadTime_Click((L1_AsiaTechnology)));

        newRow=sheet.createRow(rowCount+7);
        newRow.createCell(3).setCellValue("AppSecurity");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("CS");
        newRow.createCell(7).setCellValue(loadTime_Click((L1_CorporateSystemsTechnology)));
        scrollAction(L1_GT_Expand);

        newRow=sheet.createRow(rowCount+8);
        newRow.createCell(3).setCellValue("AppSecurity");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("UST");
        newRow.createCell(7).setCellValue(loadTime_Click((L1_USTechnology)));
        clickElementJs(L1_GT_Expand);

        newRow=sheet.createRow(rowCount+9);
        newRow.createCell(3).setCellValue("AppSecurity");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("GS");
        newRow.createCell(7).setCellValue(loadTime_Click((PageObjects.L1_GS)));


        newRow=sheet.createRow(rowCount+10);
        newRow.createCell(3).setCellValue("AppSecurity");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("DnA");
        newRow.createCell(7).setCellValue(loadTime_Click((PageObjects.L1_DnA)));

        newRow=sheet.createRow(rowCount+11);
        newRow.createCell(3).setCellValue("AppSecurity");
        newRow.createCell(4).setCellValue("Reset Filter");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("GT");
        newRow.createCell(7).setCellValue(load_Reset());
    }
    @Test(priority = 5)
    public static void NFRM() throws Exception {

        rowCount = sheet.getLastRowNum();
        newRow=sheet.createRow(rowCount+2);
        newRow.createCell(3).setCellValue("NFRM");
        newRow.createCell(4).setCellValue("Drill Thru");
        newRow.createCell(5).setCellValue("L0");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(drillThru(By.xpath("(//*[@class='visual customPadding allow-deferred-rendering visual-actionButton'])[4]")));

        newRow=sheet.createRow(rowCount+3);
        newRow.createCell(3).setCellValue("NFRM");
        newRow.createCell(4).setCellValue("Refresh");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(loadTime_refresh());

        newRow=sheet.createRow(rowCount+4);
        newRow.createCell(3).setCellValue("NFRM");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(loadTime_Click((By.xpath("(//*[@class='slicer-content-wrapper'])[3]"))));
        clickElement(By.xpath("//*[text()='Select all']"));
        clickElement(By.xpath("//*[text()='Select all']"));

        newRow=sheet.createRow(rowCount+8);
        newRow.createCell(3).setCellValue("NFRM");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[@title='Global Security']")));
        clickElement(By.xpath("(//*[@class='expandButton'])[7]"));

        newRow=sheet.createRow(rowCount+9);
        newRow.createCell(3).setCellValue("NFRM");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("L1");
//        scrollAction(By.xpath("//div[@class='scroll-bar' and @style='height: 108px; top: 0px;']"));
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[@title='MetLife Data and Analytics']")));

        newRow=sheet.createRow(rowCount+5);
        newRow.createCell(3).setCellValue("NFRM");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[@title='Global Technology']")));
        clickElement(By.xpath("(//*[@class='expandButton'])[6]"));
//        clickElement(By.xpath("//*[@title='Global Technology']"));

        newRow=sheet.createRow(rowCount+6);
        newRow.createCell(3).setCellValue("NFRM");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[text()='Asia Technology']")));

        newRow=sheet.createRow(rowCount+7);
        newRow.createCell(3).setCellValue("NFRM");
        newRow.createCell(4).setCellValue("Slicer Select");
        newRow.createCell(5).setCellValue("L1");
        newRow.createCell(6).setCellValue("L1");
        newRow.createCell(7).setCellValue(loadTime_Click(By.xpath("//*[text()='Corporate Systems Technology']")));


        newRow=sheet.createRow(rowCount+10);
        newRow.createCell(3).setCellValue("NFRM");
        newRow.createCell(4).setCellValue("Reset Filter");
        newRow.createCell(5).setCellValue("GT");
        newRow.createCell(6).setCellValue("GT");
        newRow.createCell(7).setCellValue(load_Reset());

    }

}
