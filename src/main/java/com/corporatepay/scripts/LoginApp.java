package com.corporatepay.scripts;

import com.corporatepay.util.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class LoginApp {
    public static void login(WebDriver driver, Properties p){
        try {
            //for username
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
