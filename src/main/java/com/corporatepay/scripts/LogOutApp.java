package com.corporatepay.scripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Properties;

public class LogOutApp {
    public static ExtentTest test;

    @Test
    public static void logOut(WebDriver driver, Properties p, ExtentReports extent) {
        try {
            test = extent.createTest("Logout Test");
            String click = "//*[@id=\"root\"]/div[1]/main/header/div[2]/div";
            String clickLogOut = "//*[@id=\"root\"]/div[1]/main/header/div[2]/div/div/div[1]/a";
            driver.findElement(By.xpath(click)).click();
            test.info("Click on profile button");
            driver.findElement(By.xpath(clickLogOut)).click();
            test.info("Click on logout menu");
            //get url after logout
            String url = driver.getCurrentUrl();
            if (url.equals("https://democorporatepay.connectips.com/#/login")) {
                test.info("logget out successfully");
                test.info("redireted to login page");
                test.info("url: " + url);
                test.pass("Logout Test Passed");
            } else if (url.equals("https://democorporatepay.connectips.com/#/corporate/home")) {
                test.info("logget out successfully");
                test.info("redireted to home page");
                test.info("url: " + url);
                test.pass("Logout Bank Test Passed");
            } else {
                test.info("url: " + url);
                test.fail("Logout Test Failed");
            }
        } catch (Exception e) {
            if (e != null) {
                test.fail(e);
            }
            e.printStackTrace();
        }
    }
}
