package com.corporatepay.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class LogOutBank {
    public static void logOutBank(WebDriver driver, Properties p) {
        try {
            String bankLogOutXpath = "//*[@id=\"root\"]/div[1]/main/div/div[2]/div[2]/div/div/div/a";
            WebElement logout = driver.findElement(By.xpath(bankLogOutXpath));
            logout.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
