package com.corporatepay.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.util.Objects;
import java.util.Properties;


public class DriverUtil {
    @BeforeMethod
    public static WebDriver getDriver() {
        try {
            WebDriverManager.chromedriver().setup();
//            System.setProperty("webdriver.chrome.driver", "C:\\chromdriver\\chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.get(Objects.requireNonNull(readFile()).getProperty("url"));
            System.out.println(driver);
            driver.manage().window().maximize();
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeMethod
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