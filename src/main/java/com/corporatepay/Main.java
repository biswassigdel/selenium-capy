package com.corporatepay;

import com.corporatepay.scripts.*;
import com.corporatepay.util.DriverUtil;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            Properties p = DriverUtil.readFile();
            WebDriver driver = DriverUtil.getDriver();
            LoginApp.login(driver, p);
            LoginBank.loginBank(driver, p);

            RequestToPay.r2pReq(driver, p);
            RequestToPay.initiateIndividualTransaction(driver, p);

            //to logout from the bank
//            LogOutBank.logOutBank(driver, p);
            //to logout from corporate pay application
//            LogOutApp.logOut(driver, p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}