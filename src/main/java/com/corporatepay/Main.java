package com.corporatepay;

import com.aventstack.extentreports.ExtentReports;
import com.corporatepay.scripts.*;
import com.corporatepay.util.DriverUtil;
import com.corporatepay.util.ExtentReportUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            Properties p = DriverUtil.readFile();
            WebDriver driver = DriverUtil.getDriver();
            ExtentReports extent = ExtentReportUtil.getExtentReports();
            LoginApp.login(driver, p, extent);
            LoginBank.loginBank(driver, p, extent);
//            RequestToPay.r2pReq(driver, p);
//            RequestToPay.initiateIndividualTransaction(driver, p);
            WalltLoad.loadWallet(driver, p, extent);
            //to logout from the bank
            LogOutBank.logOutBank(driver, p);
            //to logout from corporate pay application
            LogOutApp.logOut(driver, p, extent);
            extent.flush();
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}