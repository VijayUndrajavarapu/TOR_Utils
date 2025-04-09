package com.metlife_torload.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class jsExcutor_util extends WebDriver_Utils{
    public static void Scrollup(By element){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);", element);
    }
    public static void flash(WebElement element) {

        String bgcolor = element.getCssValue("backgroundColor");

        for(int i=0; i<500; i++) {
            changeColor("#000000", element);
            changeColor(bgcolor, element );
        }
    }
    public static void changeColor(String color, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color+ " ' ", element);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {

        }
    }
    public static void drawBorder(By element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(element));
    }
    public static String getTitilebyJSEx() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;

    }
    public static void clickElementJs(By element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", driver.findElement(element));
    }
    public static void generateAlert( String message) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" +message+ "')");
    }
    public static void refreshBrowserJs() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go[0]");
        System.out.println("Page Refresh!");

    }
    public static void ScrollintoView(By element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(element));
        System.out.println("scroll!");
    }
    public static void ctrl_click(By ele1, By ele2, By ele3){
        WebElement element1 = driver.findElement(ele1);
        WebElement element2 = driver.findElement(ele2);
        WebElement element3 = driver.findElement(ele3);
        String jsCode = "var ctrlClick = function(element) {" +
                "  var event = new MouseEvent('click', {" +
                "    bubbles: true," +
                "    cancelable: true," +
                "    view: window," +
                "    ctrlKey: true" +
                "  });" +
                "  element.dispatchEvent(event);" +
                "};" +
                "ctrlClick(arguments[0]);" +
                "ctrlClick(arguments[1]);" +
                "ctrlClick(arguments[2]);";

        // Execute the JavaScript to click the elements with Ctrl key pressed
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(jsCode, element1, element2, element3);
    }
    public static void zoomPage( double scale) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.body.style.transform = 'scale(" + scale + ")';");
        js.executeScript("document.body.style.transformOrigin = 'bottom right';");
    }
}
