package com.corporatepay.scripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.corporatepay.util.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Properties;

public class LoginApp {
    public static ExtentTest test;

    @Test
    public static void login(WebDriver driver, Properties p, ExtentReports extent) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //for username
            test = extent.createTest("Login Test");
            WebElement corporateusername = driver.findElement(By.id("corporateusername"));
            corporateusername.clear();
            corporateusername.sendKeys(p.getProperty("username"));

            WebElement password = driver.findElement(By.id("corporatepassword"));
            password.clear();
            password.sendKeys(p.getProperty("password"));

            WebElement corporateCode = driver.findElement(By.id("corporatecode"));
            corporateCode.click();
            corporateCode.clear();
            corporateCode.sendKeys(p.getProperty("code"));

            String buttonXpath = "//*[@id=\"root\"]/div[1]/div/div[2]/div/div[2]/form/button";
            driver.findElement(By.xpath(buttonXpath)).click();
            Thread.sleep(10000);
            String url = driver.getCurrentUrl();
            if (url.equals("https://democorporatepay.connectips.com/#/corporate/home")) {
                test.pass("Login Test Passed");
                test.info("current url: " + url);
            } else {
                test.fail("Login failed check your username and password");
                test.info("current url: " + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
           test.fail(e);
        }
    }

}
