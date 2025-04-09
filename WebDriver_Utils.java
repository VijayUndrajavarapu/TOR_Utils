/*
 *Author: Undrajavarapu Vijay Kumar
 *Project: TOR Testing
 *
 */

package com.metlife_torload.utils;


import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Set;


import static com.metlife_torload.utils.jsExcutor_util.clickElementJs;

public class WebDriver_Utils {
//    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    boolean exceptionOccured = false;

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static FileInputStream fis;
    public static Actions actions;


    public static void init(String browser){
        switch (browser){
            case "ff": case "firefox":
                driver = new FirefoxDriver();
                break;
            case "gc": case  "chrome":
                driver = new ChromeDriver();
                break;
            case "edge": case  "edgebrowser":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
    }
    public static void launchBrowser(String URL){
        driver.navigate().to(URL);
        System.err.println("Page launched!");
    }
    public static void type(By locator, String value){
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        driver.findElement(locator).sendKeys(value);
//        we.clear();

    }

    public static boolean isElementPresent(By elementBy, int waitForSeconds)
            throws Exception {

        boolean elementPresent = true;
        int count = 0;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitForSeconds));

        while(elementPresent){
            try{
                if (driver.findElement(elementBy).isDisplayed()){
                    break;
                }else{
                    if(count==waitForSeconds){
                        elementPresent = false;
                        break;
                    }

                    Thread.sleep(1000);
                    count++;
                }
            }catch(Exception ex){
                if(count==waitForSeconds){
                    elementPresent = false;
                    break;
                }

                Thread.sleep(1000);
                count++;
            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return elementPresent;
    }
    public static void clickElement(By locator) throws Exception {
        Thread.sleep(5000);
        boolean exceptionOccured = false;
//        String beforeClickUrl = driver.getCurrentUrl();
        try {
            if (isElementPresent(locator, 10)) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            }
            try {
                driver.findElement(locator).click();
            } catch (NoSuchElementException ex) {
                System.out.println(ex.getMessage());
                exceptionOccured=true;
            }
            if (exceptionOccured){
                try {
                    clickElementJs(locator);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                }
            }
            System.err.println("Clicked on: "+ locator);
        }
        catch (Exception e) {
            exceptionOccured=true;
                System.out.println(e.getMessage());

        }
    }
    public static void click(By locator) throws Exception {
        Thread.sleep(5000);
        boolean exceptionOccured = false;
//        String beforeClickUrl = driver.getCurrentUrl();
        try {
            if (isElementPresent(locator, 10)) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            }
            try {
                driver.findElement(locator).click();
            } catch (NoSuchElementException ex) {
                System.out.println(ex.getMessage());
                exceptionOccured=true;
            }
            if (exceptionOccured){
                try {
                    clickElementJs(locator);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                }
            }

        }
        catch (Exception e) {
            exceptionOccured=true;
            System.out.println(e.getMessage());

        }
    }
    public static void HardAssert(String ErrorValue, By ActualValue){
        Assert.assertEquals(ErrorValue,driver.findElement(ActualValue).getText());
    }
    public static String gettext(By locator) throws InterruptedException {
        Thread.sleep(5000);
        wait=new WebDriverWait(driver,Duration.ofSeconds(80));
//        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        String text= driver.findElement(locator).getText();
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        // You can use visibilityOfElementLocated if you specifically need visibility
        String text = element.getText();
        return  text;
    }
    public static void clickUsingActions(By locator) throws Exception {
        try{
            Actions actions = new Actions(driver);
            WebElement webButton =driver.findElement(locator);

        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
    public void selectClass( WebElement parentElement, String elementToSelect) throws Exception {
        try {
            Select dropdown = new Select(parentElement);
            dropdown.selectByVisibleText(elementToSelect);
//            Extent_Reporting.Log_Pass_Screenshot("selectClass ", "Selected " + elementToSelect + "in " + parent, driver);
        } catch (Exception e) {
//            Extent_Reporting.Log_Fail("selectClass", "Failed to Select" + elementName + driver);
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
    public void selectCheckBox( By locator) throws Exception {
        try {
            WebElement checkBox = driver.findElement(locator);
            checkBox.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    public void selectRadio(By locator) throws Exception {
        try {
            WebElement radioButton = driver.findElement(locator);
            radioButton.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
    public String decryptPassword(String encodedString) throws Exception {
        try {
            byte[] decodedString = Base64.getDecoder().decode(encodedString);
            String decodedStringValue = new String(decodedString);
            return decodedStringValue;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void SoftAssert(String Actual, By Expected){
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(Actual,driver.findElement(Expected).getText());
    }
    public static String captureScreenshot(String Filename){
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("src/Test_SShots"+Filename+".png");
        try{
            FileUtils.copyFile(srcFile,destFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Screenshot saved sucessfully!");
        return destFile.getAbsolutePath();
    }
    public static String captureScreenshot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        String Base64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);

        System.out.println("Screenshot saved sucessfully!");
        return Base64Code;
    }
    public static void waitforPageLoad(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }
    public static void reset(By resetClick, By resetOK) throws Exception {
//        Thread.sleep(10000);
        if (driver.findElement(resetClick).isEnabled()) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            System.out.println("Reset: "+driver.findElement(resetClick).isEnabled());
            wait.until(ExpectedConditions.elementToBeClickable(resetClick));
            clickElement(resetClick);
//            Thread.sleep(12000);
            try{
                wait.until(ExpectedConditions.elementToBeClickable(resetClick));
                wait.until(ExpectedConditions.visibilityOfElementLocated(resetOK));
                wait.until(ExpectedConditions.presenceOfElementLocated(resetOK));
                System.out.println(" ");Thread.sleep(10000);
//                driver.findElement(resetOK).isDisplayed()
                if (driver.findElement(resetOK).isDisplayed()) {
                    clickElement_Refresh(resetOK);
                }
            }catch (java.util.NoSuchElementException e){
                System.out.println("NoSuchElementException");
            }
        } else if (!driver.findElement(resetClick).isDisplayed()) {
            System.out.println("reset button is not displayed!");
        }
    }
    public static void DrillTo_L1(By drillElement) throws Exception {
        clickElement(drillElement);
        Set<String> windows =  driver.getWindowHandles();
        for (String handle : windows){
            if (!handle.equals(windows)){
                driver.switchTo().window(handle);
                Thread.sleep(10000);
            }
        }
        System.out.println("DrillDown, Switched to L1 Window!");
    }
    /*public static void scrollAction(){
        Actions act = new Actions(driver);
        act.
    }*/
    public static void scrollAction(By ScrollElement){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ScrollElement));

        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(ScrollElement)).clickAndHold().moveByOffset(100, 200).release().perform();

    }
    public static String getCellValue(XSSFCell cell){
        //this method will be used in dynamicIndexesCellValue()
        switch (cell.getCellType()){
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case STRING:
                return String.valueOf(cell.getStringCellValue());
            default:
                return cell.getStringCellValue();
        }
    }
    public static String StaticIndexesCellValue(int row, int cellNUm) throws IOException, InvalidFormatException {

        File file = new File("C:\\Users\\ukumar35\\IdeaProjects\\TOR\\TEST.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        //Static indexes
        String cellValue = sheet.getRow(row).getCell(cellNUm).getStringCellValue();
        System.out.println(cellValue);
//        workbook.close();
//        fis.close();
        return cellValue;
    }
    public static Object[][] readExcel(String workbook, String worksheet) {
        XSSFWorkbook wb;
        try {
            wb= new XSSFWorkbook(new FileInputStream("C:\\Users\\ukumar35\\IdeaProjects\\TOR\\"+workbook));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sh = wb.getSheet(worksheet);
        int row = sh.getPhysicalNumberOfRows()-1;
        int col = sh.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[row][col];
        for (int i=1;i<=row;i++){
            for(int j=0;j<col;j++){
                System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
                data[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return data;
    }
    /**/


    public static String extractNumericValue(String text) {
        StringBuilder numericValue = new StringBuilder();
        // Iterate through each character in the string
        for (char c : text.toCharArray()) {
            // Check if the character is a digit
            if (Character.isDigit(c)) {
                // Append the digit to the numericValue
                numericValue.append(c);
            }
        }
        // Return the numeric value as a string
        return numericValue.toString();
    }
    public static String removeCommas(String str){
        String removeComma=str;
        String Numberwithoutcomma=removeComma.replaceAll("(?<=\\d),(?=\\d)","");
        return Numberwithoutcomma;
    }
    public  static void mouseHoverAndClick(WebElement element) {
        // Ensure the element is visible before performing actions
        if (!element.isDisplayed()) {
            throw new RuntimeException("Element is not visible.");
        }

        // Create an Actions instance
        Actions actions = new Actions(driver);

        // Perform the hover and click actions
        actions.moveToElement(element).perform();
        actions.click().perform();
    }

    public static void mouseHoverAndClickByXPath(String xpath) throws InterruptedException {
        Thread.sleep(10000);
        WebElement element = driver.findElement(By.xpath(xpath));
        actions=new Actions(driver);
        actions.moveToElement(element);
    }
    /*public static String L0_RefreshTime() throws Exception {
        Thread.sleep(10000);
        clickElement(L0_redesignDrop);
        String L0_Date=gettext(PO_AppSecurity.L0_Date);
        String trimmedDate = L0_Date.replace("Data updated", "").trim();
        System.out.println("L0_Date: "+trimmedDate);
        clickElement(L0_redesignDrop);
        Thread.sleep(10000);
        return trimmedDate;
    }*/
//    String trimmedDate = dateText.replace("Data updated", "").trim();

    public static void clickElement_Refresh(By locator) throws Exception {
        int maxAttempts = 3;  // Number of attempts before refreshing the page
        boolean elementClicked = false;

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                if (isElementPresent(locator, 10)) {
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                    long startTime = System.currentTimeMillis();
                    driver.findElement(locator).click();
                    long endTime = System.currentTimeMillis();
                    double loadtime=(endTime-startTime)/1000.0;
                    System.out.println("loadtime : "+loadtime);
                    elementClicked = true;
                    System.err.println("Clicked on: "+ locator);
                    break;  // Exit the loop if element is clicked successfully

                }
            } catch (NoSuchElementException ex) {
                System.out.println("Element not found: " + ex.getMessage());
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            }

            if (!elementClicked && attempt < maxAttempts - 1) {
                System.out.println("Refreshing the page and retrying...");
                driver.navigate().refresh();  // Refresh the page if the element is not found
                Thread.sleep(5000);  // Wait for the page to load after refresh
//                clickElementJs(locator);
            }

        }

        if (!elementClicked) {
            System.out.println("Element could not be clicked after " + maxAttempts + " attempts.");
        }
    }
    public static void LT_clickElement_Refresh( By slicer, By locator) throws Exception {
        int maxAttempts = 3; // Number of attempts before refreshing the page
        boolean elementClicked = false;

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            try {
                // Wait for the element to be present
                if (isElementInteractable( locator, 10)) {
                    WebElement element = driver.findElement(locator);
                    element.click();
                    elementClicked = true;
                    System.out.println("Successfully clicked on: " + locator);
                    break; // Exit loop if clicked successfully
                }
            } catch (NoSuchElementException ex) {
                System.out.println("Element not found: " + ex.getMessage());
            } catch (Exception e) {
                System.out.println("Exception occurred while clicking: " + e.getMessage());
            }
        }

        // If element wasn't clicked after max attempts, refresh the page and retry
        if (!elementClicked) {
            System.out.println("Refreshing the page as the element could not be clicked...");
            driver.navigate().refresh(); // Refresh the page
            Thread.sleep(5000); // Wait for the page to load fully

            // Click on the slicer
            if (isElementInteractable( slicer, 10)) {
                driver.findElement(slicer).click();
                System.out.println("Clicked on slicer: " + slicer);
            } else {
                throw new Exception("Slicer element is not interactable after refreshing the page.");
            }

            // Retry clicking on the target element
            if (isElementInteractable( locator, 30)) {
                long startTime = System.currentTimeMillis();
                driver.findElement(locator).click();
                long endTime = System.currentTimeMillis();
                double loadtime=(endTime-startTime)/1000.0;
                System.out.println("clickElement_Refresh : "+loadtime);
                System.out.println("Successfully clicked on the target element after refresh: " + locator);
            } else {
                throw new Exception("Failed to click on the target element after refreshing the page.");
            }
        }
    }

    // Helper method to check if an element is interactable
    public static boolean isElementInteractable( By locator, int waitTimeInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
