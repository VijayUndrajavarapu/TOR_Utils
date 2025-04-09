/*
 *Created By: Undrajavarapu Vijay Kumar
 *Project: TOR Testing
 *
 */


package com.metlife_torload.Load_BLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static com.metlife_torload.po.PageObjects.L0_reset;
import static com.metlife_torload.po.PageObjects.L0_reset_OK;
import static com.metlife_torload.utils.WebDriver_Utils.*;


public class BL_LoadTime {
    public static double loadTime_Click(By locator) throws Exception {

        long startTime = System.currentTimeMillis();

        clickElement_Refresh(locator);

        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        wait.until((ExpectedCondition < Boolean >) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

        long endTime = System.currentTimeMillis();

        double loadtime=(endTime-startTime)/1000.0;

        System.out.println("loadtime : "+loadtime);
        return loadtime;
    }
    public static double loadTime_refresh(){
        long startTime = System.currentTimeMillis();
        driver.get().navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        wait.until((ExpectedCondition < Boolean >) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        long endTime = System.currentTimeMillis();
        double loadtime=(endTime-startTime)/1000.0;
        System.out.println("Page Refresh Time : "+loadtime);
        return loadtime;
    }
    public static double load_Reset() throws Exception {
        long startTime = System.currentTimeMillis();
        reset(L0_reset,L0_reset_OK);
        long endTime = System.currentTimeMillis();
        double loadtime=(endTime-startTime)/1000.0;
        System.out.println("loadtime : "+loadtime);
        return loadtime;
    }
    public static double drillThru(By locator) throws Exception {
        Thread.sleep(20000);
        clickElement_Refresh(locator);
        long startTime = System.currentTimeMillis();
        Set<String> windows = driver.get().getWindowHandles();
        for (String handle : windows) {
            if (!handle.equals(windows)) {
                driver.get().switchTo().window(handle);
                Thread.sleep(10000);
            }
        }
        long endTime = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
        wait.until((ExpectedCondition < Boolean >) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        double loadtime=(endTime-startTime)/1000.0;
        System.out.println("loadtime : "+loadtime);
        return loadtime;
    }
}
