package com.corporatepay.scripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.corporatepay.util.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Properties;

public class LoginBank {
    public static ExtentTest test;

    @Test
    public static void loginBank(WebDriver driver, Properties p, ExtentReports extent) {
        try {
            test = extent.createTest("Login Bank Test");
            String clickBankXpath = "//*[@id=\"root\"]/div[1]/main/div/div/div[1]/div/div/button[2]";
            driver.findElement(By.xpath(clickBankXpath)).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            String clickLoginBank = "//*[@id=\"root\"]/div[1]/main/div/div/div[2]/div[1]/div[4]/div/div/a";
            WebElement bankLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(clickLoginBank)));
            bankLogin.click();
            test.info("Bank Login Input form displayed");

            String enterBankPassword = "bankpassword";
            WebElement bankPassword = wait.until(ExpectedConditions.elementToBeClickable(By.id(enterBankPassword)));
            bankPassword.click();
            bankPassword.clear();
            bankPassword.sendKeys(p.getProperty("BankPassword"));
            test.info("Password Entered");

            String bankLoginbtn = "//*[@id=\"bankLogin\"]/div/div/div/div/form/button";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bankLoginbtn))).click();
            test.info("Login Buttono click successfully");
            Thread.sleep(5000);
            test.pass("Login Bank Passed");
        } catch (Exception e) {
            if (e != null) {
                test.fail("Exception Occured Check Once");
            }
            e.printStackTrace();
        }
    }
}
