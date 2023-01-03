package com.corporatepay.scripts;

import com.corporatepay.util.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class LoginBank {
    public static void loginBank(WebDriver driver, Properties p) {
        try {
            String clickBankXpath = "//*[@id=\"root\"]/div[1]/main/div/div/div[1]/div/div/button[2]";
            driver.findElement(By.xpath(clickBankXpath)).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            String clickLoginBank = "//*[@id=\"root\"]/div[1]/main/div/div/div[2]/div[1]/div[4]/div/div/a";
            WebElement bankLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(clickLoginBank)));
            bankLogin.click();

            String enterBankPassword = "bankpassword";
            WebElement bankPassword = wait.until(ExpectedConditions.elementToBeClickable(By.id(enterBankPassword)));
            bankPassword.click();
            bankPassword.clear();
            bankPassword.sendKeys(p.getProperty("BankPassword"));

            String bankLoginbtn = "//*[@id=\"bankLogin\"]/div/div/div/div/form/button";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bankLoginbtn))).click();
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
