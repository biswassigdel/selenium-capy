package com.corporatepay.scripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Properties;

public class WalltLoad {
    public static ExtentTest test;
    @Test
    public static void loadWallet(WebDriver driver, Properties p, ExtentReports extent) {
        try {
            test = extent.createTest("Load Wallet Test");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            //click connectIPS menu
            WebElement clickConnectIPs = driver.findElement(By.xpath("//*[@id=\"bankMenuItemGroup\"]/li[3]/a"));
            clickConnectIPs.click();
            test.info("Click on connectIPS menu");
            //click service payment menu
            WebElement serviceMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bankMenuItem1\"]/a")));
            serviceMenu.click();
            test.info("Click on Service Payment Menu");
            //click creditor payment menu
            WebElement creditorPayment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"billPaymentItem2\"]/li[4]/a")));
            creditorPayment.click();
            test.info("Click on Creditor Payment Menu");
            test.info("Creditor Page is displayed");
            Thread.sleep(5000);

        }catch (Exception e){
            if (e != null) {
                test.fail("Exception Occured Check Once");
            }
            e.printStackTrace();
        }

    }
}
