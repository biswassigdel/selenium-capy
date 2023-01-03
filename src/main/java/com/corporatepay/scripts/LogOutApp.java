package com.corporatepay.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LogOutApp {
    public static void logOut(WebDriver driver, Properties p){
        String click = "//*[@id=\"root\"]/div[1]/main/header/div[2]/div";
        String clickLogOut = "//*[@id=\"root\"]/div[1]/main/header/div[2]/div/div/div[1]/a";
        driver.findElement(By.xpath(click)).click();
        driver.findElement(By.xpath(clickLogOut)).click();
    }
}
