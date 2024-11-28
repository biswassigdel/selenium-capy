package com.corporatepay;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TEST {
        private static JavascriptExecutor js;

        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            driver.get("XXXX");
            driver.manage().window().maximize();
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys("PRITI1502");

            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("Abcd@1234");

            driver.findElement(By.name("corporatecode")).sendKeys("PVTLTD501");

            //login
            driver.findElement(By.className("btn")).click();
            Thread.sleep(10000);

            // login bank
            WebElement selectBank = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/main/div/div/div[1]/div/div/button[2]")));
            selectBank.click();

            //click login
            WebElement clickLoginBank = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/main/div/div/div[2]/div[1]/div[4]/div/div/a")));
            clickLoginBank.click();

            //enter password
            WebElement enterCredentials = wait.until(ExpectedConditions.elementToBeClickable(By.id("bankpassword")));
            enterCredentials.sendKeys("Ram@12345");
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"bankLogin\"]/div/div/div/div/form/button/div")).click();
            //select R2P
            WebElement clickNepalpay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bankMenuItemGroup\"]/li[5]/a")));
            clickNepalpay.click();

            WebElement clickR2P = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bankMenuItem3\"]/li/a")));
            clickR2P.click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payeeAccountNumber\"]/div/div[1]"))).click();
            Actions selectAccountActions = new Actions(driver);
            selectAccountActions.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

            driver.findElement(By.name("receiveBatchAmount")).sendKeys("78");

            driver.findElement(By.name("totalCount")).sendKeys("12");

            driver.findElement(By.name("referenceNo")).sendKeys("78");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"amountPreference\"]/div"))).click();
            driver.findElement(By.id("pills-bulk-tab")).click();
            WebElement uploadElement = driver.findElement(By.id("inputGroupFile02"));
            uploadElement.sendKeys("C:\\Users\\pritiyadav\\Downloads\\R2PRequestSample (2).xlsx");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebElement Element = driver.findElement(By.xpath("//*[@id=\"pills-tabContent\"]/div[2]/form/div/div[2]"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pills-tabContent\"]/div[2]/form/div/div[2]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[3]/button[2]"))).click();

            Thread.sleep(10000);

            //For individual txn//
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payeeAccountNumber\"]/div/div[1]"))).click();
            Thread.sleep(10000);
            Actions selectIndividualAccount = new Actions(driver);
            selectIndividualAccount.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

            driver.findElement(By.name("receiveBatchAmount")).sendKeys("15");

            driver.findElement(By.name("totalCount")).sendKeys("1");

            WebElement selectIndividual = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Individual")));
            selectIndividual.click();
            driver.findElement(By.name("referenceNo")).sendKeys("1145h");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"amountPreference\"]/div"))).click();
            Thread.sleep(10000);
            Actions selectAmountActions = new Actions(driver);
            selectAmountActions.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
            driver.findElement(By.name("userIdentifier")).sendKeys("9823070465");
            driver.findElement(By.name("receiveAmount")).sendKeys("15");

            driver.findElement(By.name("remarks")).sendKeys("LOAN");
            driver.findElement(By.xpath("//*[@id=\"pills-individual\"]/div[4]/div/button")).click();
            js.executeScript("arguments[0].scrollIntoView();", Element);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pills-tabContent\"]/div[2]/form/div/div[2]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[3]/button[2]"))).click();
            driver.findElement(By.xpath("//*[@id=\"pills-tabContent\"]/div[2]/form/div/div[2]/button")).click();




        }




}
