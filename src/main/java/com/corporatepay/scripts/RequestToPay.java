package com.corporatepay.scripts;

import com.corporatepay.util.DriverUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class RequestToPay {
    public static void r2pReq(WebDriver driver, Properties p) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clickReceivableMgmt = driver.findElement(By.xpath("//*[@id=\"bankMenuItemGroup\"]/li[5]"));
        clickReceivableMgmt.click();
        //go to NEPALPAY REQUEST Menu
        WebElement goToNepalPayReq = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bankMenuItem3\"]/li/a")));
        goToNepalPayReq.click();
    }

    public static void setPayeeDetails(WebDriver driver, Properties p) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payeeAccountNumber\"]/div/div[1]"))).click();
        Actions selectAccountActions = new Actions(driver);
        selectAccountActions.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        driver.findElement(By.name("receiveBatchAmount")).sendKeys("15");
        driver.findElement(By.name("totalCount")).sendKeys("1");
    }

    public static void initiateIndividualTransaction(WebDriver driver, Properties p) throws Exception {
        setPayeeDetails(driver, p);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement selectIndividual = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Individual")));
        selectIndividual.click();

        driver.findElement(By.name("referenceNo")).sendKeys("1145h");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"amountPreference\"]/div"))).click();
        Thread.sleep(10000);
        Actions selectAmountActions = new Actions(driver);
        selectAmountActions.sendKeys(DriverUtil.keyAction(Keys.DOWN, 2), Keys.chord(Keys.ENTER)).perform();
        driver.findElement(By.name("userIdentifier")).sendKeys("9823070465");
        driver.findElement(By.name("receiveAmount")).sendKeys("15");

        driver.findElement(By.name("remarks")).sendKeys("LOAN");
        driver.findElement(By.xpath("//*[@id=\"pills-individual\"]/div[4]/div/button")).click();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"pills-tabContent\"]/div[2]/form/div/div[2]"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pills-tabContent\"]/div[2]/form/div/div[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[3]/button[2]"))).click();
        driver.findElement(By.xpath("//*[@id=\"pills-tabContent\"]/div[2]/form/div/div[2]/button")).click();
    }

    public static void intiateBulkTransaction(WebDriver driver, Properties p) {
        try {
            setPayeeDetails(driver, p);
            driver.findElement(By.name("receiveBatchAmount")).sendKeys("78");
            driver.findElement(By.name("totalCount")).sendKeys("12");
            driver.findElement(By.name("referenceNo")).sendKeys("78");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
