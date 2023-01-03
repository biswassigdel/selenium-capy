package com.corporatepay.util;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileReader;
import java.util.Objects;
import java.util.Properties;


public class DriverUtil {
    public static WebDriver getDriver() {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\chromdriver\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get(Objects.requireNonNull(readFile()).getProperty("url"));
            System.out.println(driver);
            driver.manage().window().maximize();
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Properties readFile() {
        try {
            FileReader reader;
            reader = new FileReader("details.properties");
            Properties p = new Properties();
            p.load(reader);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CharSequence keyAction(Keys keys, int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            stringBuilder.append(keys);
        }
        return stringBuilder.toString();
    }
}